package com.dreamlock.core.game.jsonParser.items;

import com.dreamlock.core.game.constants.ActionState;
import com.dreamlock.core.game.jsonParser.DTOs.itemDTOs.MiscellaneousDTO;
import com.dreamlock.core.game.states.itemStates.*;
import com.google.gson.Gson;

import java.util.HashMap;

public class Miscellaneous extends Item {
    public Miscellaneous(String jsonItem) {
        Gson gson = new Gson();
        MiscellaneousDTO miscellaneousDTO = gson.fromJson(jsonItem, MiscellaneousDTO.class);
        id = miscellaneousDTO.getId();
        type = miscellaneousDTO.getType();
        name = miscellaneousDTO.getName();
        description = miscellaneousDTO.getDescription();

        stats = new HashMap<>();

        states = new HashMap<>();
        // Item states
        states.put(ActionState.PICK_UP, new CanPickUp());
        states.put(ActionState.DROP, new CanDrop());
        states.put(ActionState.EQUIP, new CanNotEquip());
        states.put(ActionState.USE, new CanNotUse());
        states.put(ActionState.OPEN, new CanNotOpen());
    }
}
