package com.dreamlock.core.messageSystem.messages;

public interface IMessage {
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
    String getEffect();
    void setEffect(String effect);
    String getPlayerStats();
    void setPlayerStats(String playerStats);
}
