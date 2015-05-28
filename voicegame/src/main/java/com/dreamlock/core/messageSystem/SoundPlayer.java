package com.dreamlock.core.messageSystem;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.dreamlock.core.messageSystem.messages.soundMessage.ISoundMessage;

import java.util.*;

public class SoundPlayer {
    private MediaPlayer mediaPlayer;
    private Context context;
    private List<String> playList;
    private int trackCounter;
    Map<Integer, ISoundMessage> messages;

    public SoundPlayer(Context context) {
        this.mediaPlayer = new MediaPlayer();
        this.context = context;
        trackCounter = 0;
    }

    public SoundPlayer(Context applicationContext, Map<Integer, ISoundMessage> messages) {
        this.context = applicationContext;
        this.messages = messages;
        trackCounter = 0;
    }

    public void play(List<Integer> messageIds) {
        buildPlaylist(messageIds);

        playFile();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playFile();
            }
        });

    }

    private void playFile() {
        try {
            AssetFileDescriptor descriptor = context.getAssets().openFd(playList.get(trackCounter));
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            mediaPlayer.prepare();
            mediaPlayer.setVolume(1f, 1f);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
            trackCounter++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playFile(String path) {
        try {
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

                if(!asItself(messageIds,i,messageId)) {
                    playList.add(messages.get(messageId).getNamePath());
                }
            }
        }
        else if (messageIds.contains(10001)) {
            for (Integer messageId : messageIds) {
                playList.add(messages.get(messageId).getDescriptionPath());
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
                if (!messages.get(messageId).getEffectPath().equals("")) {
                    playList.add(messages.get(messageId).getEffectPath());
                }
            }
        }
        else {
            for (Integer messageId : messageIds) {
                if (!messages.get(messageId).getNamePath().equals("")) {
                    if (!messages.get(messageId).getNamePath().equals("")) {

                        playList.add(messages.get(messageId).getNamePath());
                    }
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


}
