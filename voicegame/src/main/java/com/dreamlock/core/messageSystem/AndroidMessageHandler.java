package com.dreamlock.core.messageSystem;

import android.view.View;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class AndroidMessageHandler implements Serializable, IMessageHandler {

    @Override
    public void register(Map<Integer, IMessage> messages) {

    }

    @Override
    public void registerString(String string, int id) {

    }

    @Override
    public String print(List<Integer> messageIds) {
        return "";
    }

    @Override
    public void print(List<Integer> messageIds, View view) {

    }
}
