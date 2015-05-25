package com.dreamlock.core.game.states.itemStates;

import com.dreamlock.core.game.IGameContext;
import com.dreamlock.core.game.jsonParser.items.Armor;
import com.dreamlock.core.game.jsonParser.items.Item;
import com.dreamlock.core.game.jsonParser.items.Weapon;
import com.dreamlock.core.game.states.IState;

public class CanEquip implements IState {
    @Override
    public Integer doAction(IGameContext context) {
        return null;
    }

    @Override
    public Integer doAction(IGameContext context, Item item) {
        context.getPlayer().getInventory().removeItem(item);

        Item forInv = null;

        if(item.getType().equalsIgnoreCase("armor")){
            forInv = (Armor) context.getPlayer().getSlot(((Armor) item).getEquipmentSlot());

        }else if(item.getType().equalsIgnoreCase("weapon")){
            forInv = (Weapon) context.getPlayer().getSlot(((Weapon) item).getEquipmentSlot());
        }

        if(forInv != null)
            context.getPlayer().getInventory().addItem(forInv);

        context.getPlayer().equipItem(item);
        context.getPlayer().calculateStats();

        return(1401);
    }

}