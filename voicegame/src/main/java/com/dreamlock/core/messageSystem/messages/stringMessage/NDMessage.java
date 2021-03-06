package com.dreamlock.core.messageSystem.messages.stringMessage;

import java.io.Serializable;

public class NDMessage implements Serializable, IStringMessage {
    private String name;
    private String description;

    public NDMessage(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public NDMessage() {
        name = "";
        description = "";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
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
        return null;
    }

    @Override
    public void setPlayerStats(String playerStats) {

    }
}
