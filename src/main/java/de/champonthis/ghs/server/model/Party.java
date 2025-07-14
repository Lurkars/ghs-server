package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class Party {

	private int id = 0;
	private String name;
	private String edition;
	private LinkedList<ConditionName> conditions = new LinkedList<>();
	private LinkedList<String> battleGoalEditions = new LinkedList<>();
	private LinkedList<Identifier> filteredBattleGoals = new LinkedList<>();
	private String location;
	private String notes;
	private String achievements;
	@Required
	private LinkedList<String> achievementsList = new LinkedList<>();
	private int reputation = 0;
	private int prosperity = 0;
	@Required
	private LinkedList<GameScenarioModel> scenarios = new LinkedList<>();
	@Required
	private LinkedList<GameScenarioModel> conclusions = new LinkedList<>();
	@Required
	private LinkedList<GameScenarioModel> casualScenarios = new LinkedList<>();
	@Required
	private LinkedList<GameScenarioModel> manualScenarios = new LinkedList<>();
	private boolean campaignMode = false;
	private String globalAchievements;
	@Required
	private LinkedList<String> globalAchievementsList = new LinkedList<>();
	@Required
	private LinkedList<Identifier> treasures = new LinkedList<>();
	private int donations = 0;
	@Required
	private LinkedList<String> players = new LinkedList<>();
	@Required
	private LinkedList<GameCharacterModel> characters = new LinkedList<>();
	@Required
	private LinkedList<GameCharacterModel> availableCharacters = new LinkedList<>();
	@Required
	private LinkedList<GameCharacterModel> retirements = new LinkedList<>();
	@Required
	private LinkedList<CountIdentifier> unlockedItems = new LinkedList<>();
	@Required
	private LinkedList<String> unlockedCharacters = new LinkedList<>();
	private Integer level;
	private Boolean levelCalculation;
	private Integer levelAdjustment;
	private Integer bonusAdjustment;
	private Boolean ge5Player;
	private Integer playerCount;
	private Boolean solo;
	private int weeks = 0;
	@Required
	private Map<Integer, LinkedList<String>> weekSections = new HashMap<>();
	@Required
	private Map<LootType, Integer> loot = new HashMap<>();
	@Required
	private LinkedList<GameScenarioModel> randomItemLooted = new LinkedList<>();
	private int inspiration = 0;
	private int defense = 0;
	private int soldiers = 0;
	private int morale = 0;
	private int townGuardPerks = 0;
	@Required
	private LinkedList<String> townGuardPerkSections = new LinkedList<>();
	@Required
	private LinkedList<String> campaignStickers = new LinkedList<>();
	@Required
	private GameAttackModifierDeckModel townGuardDeck = new GameAttackModifierDeckModel();
	@Required
	private LinkedList<BuildingModel> buildings = new LinkedList<>();
	@Required
	private LinkedList<PetIdentifier> pets = new LinkedList<>();
	@Required
	private LinkedList<Loot> lootDeckEnhancements = new LinkedList<>();
	@Required
	private LinkedList<LootType> lootDeckFixed = new LinkedList<>();
	@Required
	private LinkedList<String> lootDeckSections = new LinkedList<>();
	private Boolean envelopeB;
	@Required
	private Map<String, LinkedList<String>> eventDecks = new HashMap<>();
	@Required
	private LinkedList<EventCardIdentifier> eventCards = new LinkedList<>();
	private Integer trials;
	private GardenModel garden;
	@Required
	private Map<String, Integer> factionReputation = new HashMap<>();
	private Integer imbuement;

}
