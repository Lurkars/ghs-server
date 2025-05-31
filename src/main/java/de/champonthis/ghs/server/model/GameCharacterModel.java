package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class GameCharacterModel {

	@Required
	private String name;
	@Required
	private String edition;
	@Required
	private boolean marker;
	private String title;
	@Required
	private int initiative;
	@Required
	private int experience;
	@Required
	private int loot;
	@Required
	private LinkedList<Integer> lootCards = new LinkedList<>();
	@Required
	private LinkedList<String> treasures = new LinkedList<>();
	@Required
	private boolean exhausted;
	@Required
	private int level;
	@Required
	private boolean off;
	@Required
	private boolean active;
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
	@Required
	private int identity;
	@Required
	private LinkedList<GameSummonModel> summons = new LinkedList<>();
	private CharacterProgress progress;
	private ScenarioStats scenarioStats;
	@Required
	private int number;
	@Required
	private GameAttackModifierDeckModel attackModifierDeck = new GameAttackModifierDeckModel();
	@Required
	private int donations;
	@Required
	private int token;
	@Required
	private LinkedList<Integer> tokenValues = new LinkedList<>();
	@Required
	private boolean absent;
	@Required
	private boolean longRest;
	@Required
	private LinkedList<Identifier> battleGoals = new LinkedList<>();
	private Boolean battleGoal = false;
	private String shield;
	private String shieldPersistent;
	@Required
	private LinkedList<String> retaliate = new LinkedList<>();
	@Required
	private LinkedList<String> retaliatePersistent = new LinkedList<>();

}
