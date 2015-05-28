package com.dreamlock.core.messageSystem.messages.soundMessage;

import com.dreamlock.core.messageSystem.messages.stringMessage.IStringMessage;

import java.io.Serializable;

public class SoundNDSMessage implements ISoundMessage, Serializable {

    private String name;
    private String description;
    private String playerStats ;

    public SoundNDSMessage(String name, String description, String playerStats) {
        this.name = name;
        this.description = description;
        this.playerStats  = playerStats;
    }

    public SoundNDSMessage() {
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
    public String getNamePath() {
        return null;
    }

    @Override
    public void setNamePath(String namePath) {

    }

    @Override
    public String getDescriptionPath() {
        return null;
    }

    @Override
    public void setDescriptionPath(String descriptionPath) {

    }

    @Override
    public String getEffectPath() {
        return null;
    }

    @Override
    public void setEffectPath(String effectPath) {

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
