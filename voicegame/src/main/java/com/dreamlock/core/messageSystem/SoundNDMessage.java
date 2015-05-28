package com.dreamlock.core.messageSystem;

import java.io.Serializable;

public class SoundNDMessage implements Serializable, ISoundMessage{
    private String name;
    private String description;
    private String namePath;
    private String descriptionPath;

    public SoundNDMessage(String name, String description, String namePath, String descriptionPath) {
        this.name = name;
        this.description = description;
        this.namePath = namePath;
        this.descriptionPath = descriptionPath;
    }

    public SoundNDMessage() {
        name = "";
        description = "";
        namePath = "";
        descriptionPath = "";
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

    @Override
    public String getNamePath() {
        return namePath;
    }

    @Override
    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }

    @Override
    public String getDescriptionPath() {
        return descriptionPath;
    }

    @Override
    public void setDescriptionPath(String descriptionPath) {
        this.descriptionPath = descriptionPath;
    }

    @Override
    public String getEffectPath() {
        return null;
    }

    @Override
    public void setEffectPath(String effectPath) {

    }
}
