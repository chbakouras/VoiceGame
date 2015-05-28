package com.dreamlock.core.messageSystem;

import com.dreamlock.core.messageSystem.messages.IMessage;
import com.dreamlock.core.messageSystem.messages.soundMessage.ISoundMessage;

import java.util.List;
import java.util.Map;

public interface IMessageHandler {
    void register(Map<Integer, IMessage> messages);

    void registerAndroid(Map<Integer, ISoundMessage> messages);

    void registerString(String string, int id);

    void print(List<Integer> messageIds);

    String printAndroid(List<Integer> messageIds);

    Map<Integer, ISoundMessage> getMessages();
}
