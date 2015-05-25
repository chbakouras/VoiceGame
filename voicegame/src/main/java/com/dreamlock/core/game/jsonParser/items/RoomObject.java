package com.dreamlock.core.game.jsonParser.items;

import com.dreamlock.core.game.constants.ActionState;
import com.dreamlock.core.game.jsonParser.DTOs.itemDTOs.RoomObjectDTO;
import com.dreamlock.core.game.states.itemStates.CanNotPickUp;
import com.dreamlock.core.game.states.itemStates.CanOpen;
import com.google.gson.Gson;

import java.util.HashMap;

public class RoomObject extends Item {
    public RoomObject(String jsonItem) {
        Gson gson = new Gson();
        RoomObjectDTO roomObjectDTO = gson.fromJson(jsonItem, RoomObjectDTO.class);
        id = roomObjectDTO.getId();
        type = roomObjectDTO.getType();
        name = roomObjectDTO.getName();
        description = roomObjectDTO.getDescription();

        stats = new HashMap<>();

        states = new HashMap<>();
        // changing states
        states.put(ActionState.PICK_UP, new CanNotPickUp());
        states.put(ActionState.OPEN, new CanOpen());
    }
}
