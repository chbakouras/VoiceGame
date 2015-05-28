package com.dreamlock.core.messageSystem;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidMessageHandler implements Serializable, IMessageHandler{
    private Map<Integer, ISoundMessage> messages;
    private Context context;
    MediaPlayer m = new MediaPlayer();

    public AndroidMessageHandler(Context context) {
        this.context = context;
        messages = new HashMap<>();
    }

    public void playSound (String filePath)
    {
        try {
        if (m.isPlaying()) {
            m.stop();
            m.release();
            m = new MediaPlayer();
        }

        AssetFileDescriptor descriptor = context.getAssets().openFd(filePath);
        m.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
        descriptor.close();

        m.prepare();
        m.setVolume(1f, 1f);
        m.setLooping(false);
        m.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    public void register(Map<Integer, IMessage> messages) {
    }

    @Override
    public void registerAndroid(Map<Integer, ISoundMessage> messages) {
        this.messages.putAll(messages);
    }

    @Override
    public void registerString(String string, int id) {
        ISoundMessage message = new SoundNDMessage(string, "", "", "");
        this.messages.put(id, message);
    }

    @Override
    public void print(List<Integer> messageIds) {

    }

    @Override
    public String printAndroid(List<Integer> messageIds) {
        StringBuilder stringBuilder = new StringBuilder();

        if (messageIds.contains(10000)) {
            messageIds.add(10002);
            messageIds.add(10002);

            for (int i = 0 ; i < messageIds.size() ; i++) {
                int messageId = messageIds.get(i);

                if(asItself(messageIds,i,messageId)) {
                    stringBuilder.append(messageId);
                }
                else {
                    stringBuilder.append(messages.get(messageId).getName());
                }
            }
        }
        else if (messageIds.contains(10001)) {
            messageIds.add(10003);
            messageIds.add(10003);
            for (Integer messageId : messageIds) {
                stringBuilder.append(messages.get(messageId).getDescription());
            }
        }
        else if (messageIds.contains(10004)) {
            messageIds.add(10003);
            messageIds.add(10003);
            for (Integer messageId : messageIds) {
                if (!messages.get(messageId).getName().equals("")) {
                    stringBuilder.append(messages.get(messageId).getName());
                }
                if (!messages.get(messageId).getDescription().equals("")) {
                    stringBuilder.append(messages.get(messageId).getDescription());
                }
            }
        }
        else if (messageIds.contains(10006)) {
            messageIds.add(10007);
            messageIds.add(10007);
            for (Integer messageId : messageIds) {
                if (!messages.get(messageId).getEffect().equals("")) {
                    stringBuilder.append(messages.get(messageId).getEffect());
                }
            }
        }
        else if (messageIds.contains(10005)) {
            for (Integer messageId : messageIds) {
                if (!messages.get(messageId).getPlayerStats().equals("")) {
                    stringBuilder.append(messages.get(messageId).getName());
                    stringBuilder.append(messages.get(messageId).getPlayerStats());
                }
            }
        }
        else {

            messageIds.add(10003);
            messageIds.add(10003);
            for (Integer messageId : messageIds) {
                if (!messages.get(messageId).getName().equals("")) {
                    if (!messages.get(messageId).getNamePath().equals("")) {
                        playSound(messages.get(messageId).getNamePath());
                    }
                    stringBuilder.append(messages.get(messageId).getName());
                }
                if (!messages.get(messageId).getDescription().equals("")) {
                    stringBuilder.append(messages.get(messageId).getDescription());
                }
            }
        }
        return stringBuilder.toString();
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
