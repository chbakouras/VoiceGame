package com.dreamlock.core.game.models;

import com.dreamlock.core.game.combat.Combatant;
import com.dreamlock.core.game.constants.ActionState;
import com.dreamlock.core.game.jsonParser.DTOs.EnemyDTO;
import com.dreamlock.core.game.states.combatStates.CanAttackState;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;

public class Enemy extends Combatant implements Serializable{
    private int id;
    private String namePath;
    private String descriptionPath;
    private String effectPath;
    private String description;
    private String effect;

    public Enemy(){
        states = new HashMap<>();
        states.put(ActionState.ATTACK, new CanAttackState());
    }

    public Enemy (String jsonEnemy) {
        Gson gson = new Gson();
        EnemyDTO enemyDTO = gson.fromJson(jsonEnemy, EnemyDTO.class);
        id = enemyDTO.getId();
        name = enemyDTO.getName();
        description = enemyDTO.getDescription();
        descriptionPath = enemyDTO.getDescriptionPath();
        effectPath = enemyDTO.getEffectPath();
        namePath = enemyDTO.getNamePath();
        health = enemyDTO.getHealth();
        attack = enemyDTO.getAttack();
        defense = enemyDTO.getDefense();
        effect = "";

        states = new HashMap<>();
        states.put(ActionState.ATTACK, new CanAttackState());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNamePath() {
        return namePath;
    }

    public void setNamePath(String namePath) {
        this.namePath = namePath;
    }

    public String getDescriptionPath() {
        return descriptionPath;
    }

    public void setDescriptionPath(String descriptionPath) {
        this.descriptionPath = descriptionPath;
    }

    public String getEffectPath() {
        return effectPath;
    }

    public void setEffectPath(String effectPath) {
        this.effectPath = effectPath;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}