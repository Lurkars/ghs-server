package de.champonthis.ghs.server.model;

import java.util.LinkedList;

public class GameMonsterStatEffectModel {

    private String health;
    private String movement;
    private String attack;
    private String range;
    private String actions;
    private LinkedList<ConditionName> immunities = new LinkedList<>();
    private String deck;
    private Boolean absolute;

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public LinkedList<ConditionName> getImmunities() {
        return immunities;
    }

    public void setImmunities(LinkedList<ConditionName> immunities) {
        this.immunities = immunities;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public Boolean getAbsolute() {
        return absolute;
    }

    public void setAbsolute(Boolean absolute) {
        this.absolute = absolute;
    }

}
