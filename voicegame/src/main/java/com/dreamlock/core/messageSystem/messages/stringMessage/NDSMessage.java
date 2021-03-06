package com.dreamlock.core.messageSystem.messages.stringMessage;

import java.io.Serializable;

public class NDSMessage implements IStringMessage, Serializable {

    private String name;
    private String description;
    private String playerStats ;

    public NDSMessage(String name, String description, String playerStats) {
        this.name = name;
        this.description = description;
        this.playerStats  = playerStats;
    }

    public NDSMessage() {
        this.name = "";
        this.description = "";
        this.playerStats  = "";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public String getEffect() {
        return null;
    }

    @Override
    public void setEffect(String effect) {

    }

    @Override
    public String getPlayerStats() {
        return playerStats ;
    }

    @Override
    public void setPlayerStats(String playerStats) {
        this.playerStats  = playerStats;
    }
}
