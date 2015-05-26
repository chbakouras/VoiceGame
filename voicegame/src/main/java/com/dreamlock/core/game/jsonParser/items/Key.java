package com.dreamlock.core.game.jsonParser.items;

import com.dreamlock.core.game.constants.ActionState;
import com.dreamlock.core.game.jsonParser.DTOs.itemDTOs.KeyDTO;
import com.dreamlock.core.game.states.itemStates.*;
import com.google.gson.Gson;

import java.util.HashMap;

public class Key extends Item {
    public Key(String jsonItem) {
        Gson gson = new Gson();
        KeyDTO keyDTO = gson.fromJson(jsonItem, KeyDTO.class);
        id = keyDTO.getId();
        type = keyDTO.getType();
        name = keyDTO.getName();
        description = keyDTO.getDescription();

        stats = new HashMap<>();

        states = new HashMap<>();

        // Item states
        states.put(ActionState.PICK_UP, new CanPickUp());
        states.put(ActionState.DROP, new CanDrop());
        states.put(ActionState.EQUIP, new CanNotEquip());
        states.put(ActionState.USE, new CanNotUse());
        states.put(ActionState.DRINK, new CanNotDrink());
        states.put(ActionState.EAT, new CanNotEat());
        states.put(ActionState.OPEN, new CanNotOpen());
    }
}
