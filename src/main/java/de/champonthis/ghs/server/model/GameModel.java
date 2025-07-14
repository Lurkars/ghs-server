package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class GameModel {

	@Required
	private Long revision;
	private int revisionOffset = 0;
	private String edition;
	@Required
	private LinkedList<ConditionName> conditions = new LinkedList<>();
	@Required
	private LinkedList<String> battleGoalEditions = new LinkedList<>();
	@Required
	private LinkedList<Identifier> filteredBattleGoals = new LinkedList<>();
	@Required
	private LinkedList<String> figures = new LinkedList<>();
	@Required
	private LinkedList<EntityCounter> entitiesCounter = new LinkedList<>();
	@Required
	private LinkedList<GameCharacterModel> characters = new LinkedList<>();
	@Required
	private LinkedList<GameMonsterModel> monsters = new LinkedList<>();
	private LinkedList<GameObjectiveContainerModel> objectiveContainers = new LinkedList<>();
	@Required
	private GameState state = GameState.DRAW;
	private GameScenarioModel scenario;
	@Required
	private LinkedList<GameScenarioModel> sections = new LinkedList<>();
	@Required
	private LinkedList<ScenarioRuleIdentifier> scenarioRules = new LinkedList<>();
	@Required
	private LinkedList<ScenarioRuleIdentifier> appliedScenarioRules = new LinkedList<>();
	@Required
	private LinkedList<ScenarioRuleIdentifier> discardedScenarioRules = new LinkedList<>();
	@Required
	private int level = 1;
	@Required
	private boolean levelCalculation = true;
	@Required
	private int levelAdjustment = 0;
	@Required
	private int bonusAdjustment = 0;
	@Required
	private boolean ge5Player = true;
	@Required
	private int playerCount = 0;
	@Required
	private int round = 0;
	@Required
	private LinkedList<Integer> roundResets = new LinkedList<>();
	@Required
	private LinkedList<Integer> roundResetsHidden = new LinkedList<>();
	@Required
	private long playSeconds = 0;
	@Required
	private long totalSeconds = 0;
	@Required
	private GameAttackModifierDeckModel monsterAttackModifierDeck = new GameAttackModifierDeckModel();
	@Required
	private GameAttackModifierDeckModel allyAttackModifierDeck = new GameAttackModifierDeckModel();
	@Required
	private LinkedList<ElementModel> elementBoard = new LinkedList<>();
	@Required
	private boolean solo = false;
	@Required
	private Party party = new Party();
	@Required
	private LinkedList<Party> parties = new LinkedList<>();
	@Required
	private LootDeck lootDeck = new LootDeck();
	@Required
	private LinkedList<Loot> lootDeckEnhancements = new LinkedList<>();
	@Required
	private LinkedList<LootType> lootDeckFixed = new LinkedList<>();
	@Required
	private LinkedList<String> lootDeckSections = new LinkedList<>();
	@Required
	private LinkedList<String> unlockedCharacters = new LinkedList<>();
	@Required
	private boolean server = false;
	private ScenarioFinish finish;
	@Required
	private LinkedList<GameClockTimestamp> gameClock = new LinkedList<>();
	private GameChallengeDeckModel challengeDeck = new GameChallengeDeckModel();
	@Required
	private LinkedList<Identifier> favors = new LinkedList<>();
	@Required
	private LinkedList<Integer> favorPoints = new LinkedList<>();
	private Boolean keepFavors = false;
	private String eventDraw;
	// Migration
	private LinkedList<ScenarioRuleIdentifier> disgardedScenarioRules = new LinkedList<>();

}
