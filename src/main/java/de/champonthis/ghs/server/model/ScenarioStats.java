package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;

public class ScenarioStats extends DamageStats {

    private GameScenarioModel scenario;
    private boolean success;
    private Integer level;
    private Integer difficutly;
    private Integer gold;
    private Integer xp;
    private Integer treasures;
    @Required
    private Map<LootType, Integer> loot = new HashMap<>();
    @Required
    private DamageStats summons = new DamageStats();

    public GameScenarioModel getScenario() {
        return scenario;
    }

    public void setScenario(GameScenarioModel scenario) {
        this.scenario = scenario;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDifficutly() {
        return difficutly;
    }

    public void setDifficutly(Integer difficutly) {
        this.difficutly = difficutly;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getTreasures() {
        return treasures;
    }

    public void setTreasures(Integer treasures) {
        this.treasures = treasures;
    }

    public Map<LootType, Integer> getLoot() {
        return loot;
    }

    public void setLoot(Map<LootType, Integer> loot) {
        this.loot = loot;
    }

    public DamageStats getSummons() {
        return summons;
    }

    public void setSummons(DamageStats summons) {
        this.summons = summons;
    }

}
