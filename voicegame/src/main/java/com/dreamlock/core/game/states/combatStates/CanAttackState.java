package com.dreamlock.core.game.states.combatStates;


import com.dreamlock.core.game.IGameContext;
import com.dreamlock.core.game.combat.Combatant;
import com.dreamlock.core.game.states.ICombatState;

import java.io.Serializable;

public class CanAttackState implements ICombatState, Serializable {
    protected int damageDone;

    @Override
    public Integer doAction(IGameContext context) {
        return null;
    }

    @Override
    public Integer doAction(IGameContext context, Combatant current, Combatant enemy) {
        
        damageDone =  current.getAttack() - enemy.getDefense();
        if (damageDone <= 0)
            damageDone = 1;

        enemy.setHealth(enemy.getHealth() - damageDone);
        return damageDone;
    }

}
