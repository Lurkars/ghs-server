package de.champonthis.ghs.server.model;

import lombok.Data;

@Data
public class DamageStats {

    private Integer dealtDamage;
    private Integer monsterDamage;
    private Integer otherDamage;
    private Integer healedDamage;
    private Integer heals;
    private Integer normalKills;
    private Integer eliteKills;
    private Integer bossKills;
    private Integer exhausts;
    private Integer maxDealtDamage;
    private Integer maxDamage;

}
