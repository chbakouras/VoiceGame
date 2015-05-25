package com.dreamlock.core.messageSystem;

import android.view.View;

import java.util.List;
import java.util.Map;

public interface IMessageHandler {
    void register(Map<Integer, IMessage> messages);
    void registerString(String string, int id);
    String print(List<Integer> messageIds);
    void print(List<Integer> messageIds, View view);
}
