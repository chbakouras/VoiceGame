package com.dreamlock.core.messageSystem;

import java.util.List;
import java.util.Map;

public interface IMessageHandler {
    void register(Map<Integer, IMessage> messages);

    void registerString(String string, int id);

    void print(List<Integer> messageIds);

    String printAndroid(List<Integer> messageIds);
}
