package com.dreamlock.core.messageSystem;

public interface IMessage {
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
    String getEffect();
    void setEffect(String effect);
}