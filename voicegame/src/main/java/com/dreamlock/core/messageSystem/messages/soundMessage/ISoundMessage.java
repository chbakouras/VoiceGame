package com.dreamlock.core.messageSystem.messages.soundMessage;

import com.dreamlock.core.messageSystem.messages.IMessage;

public interface ISoundMessage extends IMessage {
    String getNamePath();
    void setNamePath(String namePath);

    String getDescriptionPath();
    void setDescriptionPath(String descriptionPath);

    String getEffectPath();
    void setEffectPath(String effectPath);

    String getPlayerStats();
    void setPlayerStats(String playerStats);
}
