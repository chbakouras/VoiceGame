package com.dreamlock.core.messageSystem;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import com.dreamlock.core.messageSystem.messages.soundMessage.ISoundMessage;
import com.dreamlock.core.messageSystem.messages.soundMessage.SoundMessage;

import java.io.*;
import java.util.*;

public class SoundPlayer {
    private MediaPlayer mediaPlayer;
    private Context context;
    private List<String> playList;
    private int trackCounter;
    private int maxMessages;
    SoundPool soundPool;
    Map<Integer, ISoundMessage> messages;

    public SoundPlayer(Context context) {
        soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 100);
        this.mediaPlayer = new MediaPlayer();
        playList = new ArrayList<>();
        this.context = context;
        trackCounter = 0;
    }

    public SoundPlayer(Context applicationContext, Map<Integer, ISoundMessage> messages) {
        soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 100);
        this.mediaPlayer = new MediaPlayer();
        this.context = applicationContext;
        playList = new ArrayList<>();
        this.messages = messages;
        trackCounter = 0;
    }

    public void play(List<Integer> messageIds) throws IOException {
        buildPlaylist(messageIds);
        maxMessages = playList.size();

        playFile();


    }

    private void playFile() {
        if (trackCounter < maxMessages) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = new MediaPlayer();
                }
                AssetFileDescriptor descriptor = context.getAssets().openFd(playList.get(trackCounter));
                mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();

                trackCounter++;

                if (trackCounter < maxMessages) {
                    AssetFileDescriptor descriptor2 = context.getAssets().openFd(playList.get(trackCounter));
                    MediaPlayer mediaPlayer1 = new MediaPlayer();
                    mediaPlayer1.setDataSource(descriptor2.getFileDescriptor(), descriptor2.getStartOffset(), descriptor2.getLength());
                    mediaPlayer1.prepare();
                    mediaPlayer1.setVolume(1f, 1f);
                    mediaPlayer1.setLooping(false);
//                    mediaPlayer1.start();
                    mediaPlayer.setNextMediaPlayer(mediaPlayer1);
                }

                mediaPlayer.prepare();
                mediaPlayer.setVolume(1f, 1f);
                mediaPlayer.setLooping(false);
                mediaPlayer.start();
                trackCounter++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void playFile(String path) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = new MediaPlayer();
            }
            AssetFileDescriptor descriptor = context.getAssets().openFd(path);
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            mediaPlayer.prepare();
            mediaPlayer.setVolume(1f, 1f);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildPlaylist(List<Integer> messageIds) {
        if (messageIds.contains(10000)) {
            for (int i = 0 ; i < messageIds.size() ; i++) {
                int messageId = messageIds.get(i);

                if((!asItself(messageIds,i,messageId))&& !messages.get(messageId).getNamePath().equals("")) {
                    playList.add(messages.get(messageId).getNamePath());
                }
            }
        }
        else if (messageIds.contains(10001)) {
            for (Integer messageId : messageIds) {
                if (!messages.get(messageId).getDescriptionPath().equals("")) {
                    playList.add(messages.get(messageId).getDescriptionPath());
                }
            }
        }
        else if (messageIds.contains(10004)) {
            for (Integer messageId : messageIds) {
                if (!messages.get(messageId).getNamePath().equals("")) {
                    playList.add(messages.get(messageId).getNamePath());
                }
                if (!messages.get(messageId).getDescriptionPath().equals("")) {
                    playList.add(messages.get(messageId).getDescriptionPath());
                }
            }
        }
        else if (messageIds.contains(10006)) {
            for (Integer messageId : messageIds) {
                if (messages.get(messageId) instanceof SoundMessage) {
                    if (!messages.get(messageId).getEffectPath().equals("")) {
                        playList.add(messages.get(messageId).getEffectPath());
                    }
                }
            }
        }
        else {
            for (Integer messageId : messageIds) {
                if (!messages.get(messageId).getNamePath().equals("")) {
                    playList.add(messages.get(messageId).getNamePath());
                }
                if (!messages.get(messageId).getDescriptionPath().equals("")) {
                    playList.add(messages.get(messageId).getDescriptionPath());
                }
            }
        }
    }

    private boolean asItself(List<Integer> messageIds, int i, int messageId){
        int next_message_id_idx = i+1;
        if(next_message_id_idx < messageIds.size() && messageIds.contains(1301) && messageIds.get(next_message_id_idx) == 1309)
            return true;
        else if( next_message_id_idx < messageIds.size() && messageIds.get(next_message_id_idx) == 1308)
            return true;
        return false;
    }

    public void stop() {
        this.mediaPlayer.stop();
    }
}
