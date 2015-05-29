package com.dreamlock.core.game.jsonParser.DTOs;

public class EnemyDTO {
    private int id;
    private String path;
    private String name;
    private String description;
    private String namePath;
    private String descriptionPath;
    private String effectPath;
    private int health;
    private int attack;
    private int defense;

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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
}
