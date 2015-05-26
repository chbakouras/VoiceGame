package com.dreamlock.core.game.states.itemStates;

import com.dreamlock.core.game.IGameContext;
import com.dreamlock.core.game.jsonParser.items.Consumable;
import com.dreamlock.core.game.jsonParser.items.Item;
import com.dreamlock.core.game.states.IState;

public class CanEat implements IState {

    @Override
    public Integer doAction(IGameContext context) {
        return null;
    }

    @Override
    public Integer doAction(IGameContext context, Item item) {
        String itemType = item.getType();
        if (itemType.equals("Consumable")) {
                Consumable consumable = (Consumable) item;
                if(consumable.getState().equals("Food")){
                        context.getPlayer().calculateStats();
                        context.getPlayer().addStats(item.getStats());
                }
        }
        context.getPlayer().getInventory().removeItem(item);
        return 10006;
    }
}