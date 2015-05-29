package com.dreamlock.core.messageSystem;

import com.dreamlock.core.game.jsonParser.items.Consumable;
import com.dreamlock.core.game.jsonParser.items.Container;
import com.dreamlock.core.game.jsonParser.items.Item;
import com.dreamlock.core.game.models.Door;
import com.dreamlock.core.game.models.Enemy;
import com.dreamlock.core.game.models.Player;
import com.dreamlock.core.game.models.Room;
import com.dreamlock.core.messageSystem.messages.IMessage;
import com.dreamlock.core.messageSystem.messages.soundMessage.ISoundMessage;
import com.dreamlock.core.messageSystem.messages.soundMessage.SoundNDEMessage;
import com.dreamlock.core.messageSystem.messages.soundMessage.SoundNDMessage;
import com.dreamlock.core.messageSystem.messages.soundMessage.SoundNDSMessage;
import com.dreamlock.core.messageSystem.messages.stringMessage.NDEMessage;
import com.dreamlock.core.messageSystem.messages.stringMessage.NDMessage;
import com.dreamlock.core.messageSystem.messages.stringMessage.NDSMessage;

import java.util.HashMap;
import java.util.Map;

public class GameMessages {
    private Map<Integer,ISoundMessage> gameMessages;

    public GameMessages(Player player, Map<Integer, Room> rooms) {
        gameMessages = new HashMap<>();
        for (int i = 1 ; i < rooms.size() ; i++ ) {
            Room room = rooms.get(i);
            gameMessages.put(room.getId(), new SoundNDMessage(room.getTitle(), room.getDescription(), room.getTitlePath(), room.getDescriptionPath()));
            for (Item item : room.getItems()) {
                try {
                    if (item.getType().equals("Container")) {
                        Container container = (Container) item;
                        for (Item containerItem : container.getItems()) {
                            if (item.getType().equals("Consumable")) {
                                Consumable consumableItem = (Consumable) containerItem;
                                gameMessages.put(consumableItem.getId(), new SoundNDEMessage(consumableItem.getName(), consumableItem.getDescription(), consumableItem.getEffect(), "", "", consumableItem.getEffectPath()));
                            } else {
                                gameMessages.put(containerItem.getId(), new SoundNDMessage(containerItem.getName(), containerItem.getDescription(), "",""));
                            }
                        }
                    }
                    if (item.getType().equals("Consumable")) {
                        Consumable consumableItem = (Consumable) item;
                        gameMessages.put(consumableItem.getId(), new SoundNDEMessage(consumableItem.getName(), consumableItem.getDescription(), consumableItem.getEffect(), "", "", consumableItem.getEffectPath()));
                    } else {
                        gameMessages.put(item.getId(), new SoundNDMessage(item.getName(), item.getDescription(), "", ""));
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for(Enemy enemy: room.getEnemies()){
                gameMessages.put(enemy.getId(), new SoundNDEMessage(enemy.getName(), enemy.getDescription(), "", enemy.getNamePath(), enemy.getDescriptionPath(), enemy.getEffectPath()));

            }
            for(Door door: room.getDoors()){
                gameMessages.put(door.getId(), new SoundNDMessage(door.getName(), door.getDescription(), "", ""));
            }
            gameMessages.put(player.getId(), new SoundNDSMessage(player.getName(), "", player.getPlayerStatsMap()));
        }
    }

    public Map<Integer, ISoundMessage> getGameMessages() {
        return gameMessages;
    }

    public void setGameMessages(Map<Integer, ISoundMessage> gameMessages) {
        this.gameMessages = gameMessages;
    }
}
