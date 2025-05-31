package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class GameMonsterEntityModel {

	@Required
	private int number;
	private String marker;
	@Required
	private MonsterType type;
	@Required
	private boolean dead;
	@Required
	private SummonState summon;
	@Required
	private boolean revealed = false;
	@Required
	private boolean active = false;
	private boolean dormant = false;
	@Required
	private boolean off = false;
	@Required
	private int health;
	@Required
	private int maxHealth;
	@Required
	private LinkedList<GameEntityConditionModel> entityConditions = new LinkedList<>();
	private LinkedList<ConditionName> immunities = new LinkedList<>();
	@Required
	private LinkedList<String> markers = new LinkedList<>();
	@Required
	private LinkedList<String> tags = new LinkedList<>();
	private String shield;
	private String shieldPersistent;
	@Required
	private LinkedList<String> retaliate = new LinkedList<>();
	@Required
	private LinkedList<String> retaliatePersistent = new LinkedList<>();

}
