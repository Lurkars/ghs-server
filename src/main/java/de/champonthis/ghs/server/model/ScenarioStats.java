package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
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

}
