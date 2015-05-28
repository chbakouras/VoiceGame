package com.dreamlock.core.messageSystem.constants;

import com.dreamlock.core.messageSystem.IMessage;

import java.util.Map;
import java.util.Set;

public interface ICommandMessages {

    IMessage getCommandMessage(Integer messageId);

    Map<Integer, IMessage> getCommandMessages();

    Set<Integer> getDefinedCommandMessages();
}
