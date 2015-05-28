package com.dreamlock.core.messageSystem.messages.soundMessage;

import java.io.Serializable;

public class SoundNDEMessage implements Serializable, ISoundMessage {
    private String name;
    private String description;
    private String effect;
    private String namePath;
    private String descriptionPath;
    private String effectPath;

    public SoundNDEMessage(String name, String description, String effect, String namePath, String descriptionPath, String effectPath) {
        this.name = name;
        this.description = description;
        this.effect = effect;
        this.namePath = namePath;
        this.descriptionPath = descriptionPath;
        this.effectPath = effectPath;
    }

    public SoundNDEMessage() {
        name = "";
        namePath = "";
        description = "";
        descriptionPath = "";
        effect = "";
        effectPath = "";
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
    public String getEffect() {
        return effect;
    }

    @Override
    public void setEffect(String effect) {
        this.effect = effect;
    }

    @Override
    public String getEffectPath() {
        return effectPath;
    }

    @Override
    public void setEffectPath(String effectPath) {
        this.effectPath = effectPath;
    }

    @Override
    public String getPlayerStats() {
        return null;
    }

    @Override
    public void setPlayerStats(String playerStats) {

    }
}
