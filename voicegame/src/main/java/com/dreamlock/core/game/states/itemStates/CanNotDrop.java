package com.dreamlock.core.game.states.itemStates;

import com.dreamlock.core.game.IGameContext;
import com.dreamlock.core.game.jsonParser.items.Item;
import com.dreamlock.core.game.states.IState;

public class CanNotDrop implements IState {
    @Override
    public Integer doAction(IGameContext context) {
        return null;
    }

    @Override
    public Integer doAction(IGameContext context, Item item) {
        return 1041;
    }
}