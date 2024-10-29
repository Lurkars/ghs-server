package de.champonthis.ghs.server.model;

import java.util.Arrays;
import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class Settings {

	@Required
	private boolean abilities = true;
	@Required
	private boolean abilityNumbers = true;
	@Required
	private boolean abilityReveal = true;
	@Required
	private boolean activeApplyConditions = true;
	@Required
	private LinkedList<ConditionName> activeApplyConditionsAuto = new LinkedList<>();
	@Required
	private LinkedList<ConditionName> activeApplyConditionsExcludes = new LinkedList<>(
			Arrays.asList(ConditionName.SHIELD));
	@Required
	private boolean activeStandees = true;
	@Required
	private boolean activeSummons = true;
	@Required
	private boolean addAllMonsters = false;
	@Required
	private boolean allyAttackModifierDeck = true;
	@Required
	private boolean alwaysAllyAttackModifierDeck = false;
	@Required
	private boolean alwaysFhAdvantage = false;
	@Required
	private boolean alwaysFhSolo = false;
	@Required
	private boolean alwaysHazardousTerrain = false;
	@Required
	private boolean alwaysLootApplyDialog = false;
	@Required
	private boolean alwaysLootDeck = false;
	@Required
	private boolean amAdvantage = false;
	@Required
	private boolean amAdvantageHouseRule = false;
	@Required
	private boolean applyBuildingRewards = true;
	@Required
	private boolean applyConditions = true;
	@Required
	private LinkedList<ConditionName> applyConditionsExcludes = new LinkedList<>(Arrays.asList(ConditionName.SHIELD));
	@Required
	private boolean applyLongRest = true;
	@Required
	private boolean applyLoot = true;
	@Required
	private boolean applyLootRandomItem = true;
	@Required
	private boolean applyRetirement = true;
	@Required
	private boolean automaticPassTime = true;
	@Required
	private boolean automaticStandees = true;
	@Required
	private boolean automaticStandeesDialog = false;
	@Required
	private boolean automaticUnlocking = true;
	@Required
	private boolean battleGoals = false;
	@Required
	private boolean battleGoalsCharacter = false;
	@Required
	private boolean battleGoalsFh = false;
	@Required
	private boolean battleGoalsReminder = true;
	@Required
	private boolean bbAm = true;
	@Required
	private boolean bbChars = true;
	@Required
	private boolean bbStandeeLimit = true;
	@Required
	private boolean calculate = true;
	@Required
	private boolean calculateStats = true;
	@Required
	private boolean calculateShieldStats = true;
	@Required
	private boolean characterAttackModifierDeck = true;
	@Required
	private boolean characterHandSize = false;
	@Required
	private boolean characterIdentities = true;
	@Required
	private boolean characterIdentityHint = true;
	@Required
	private boolean characterItems = false;
	@Required
	private boolean characterItemsApply = true;
	@Required
	private boolean characterSheet = true;
	@Required
	private boolean characterShieldRetaliate = false;
	@Required
	private boolean characterSortIndex = false;
	@Required
	private boolean characterTraits = false;
	@Required
	private boolean combineInteractiveAbilities = true;
	@Required
	private boolean combineSummonAction = true;
	@Required
	private boolean damageHP = false;
	@Required
	private boolean disabledTurnConfirmation = false;
	@Required
	private boolean disableSortFigures = false;
	@Required
	private boolean disableStandees = false;
	@Required
	private LinkedList<String> editionDataUrls = new LinkedList<>();
	@Required
	private LinkedList<String> editions = new LinkedList<>();
	@Required
	private boolean eliteFirst = true;
	@Required
	private LinkedList<String> excludeEditionDataUrls = new LinkedList<>();
	@Required
	private boolean expireConditions = true;
	@Required
	private boolean fhChallenges = false;
	@Required
	private boolean fhChallengesApply = true;
	@Required
	private boolean fhGhItems = false;
	@Required
	private boolean fhSecondEdition = false;
	@Required
	private boolean fhTrials = false;
	@Required
	private boolean fhTrialsApply = true;
	@Required
	private boolean hideAbsent = false;
	@Required
	private boolean hideStats = false;
	@Required
	private boolean initiativeRequired = true;
	@Required
	private boolean interactiveAbilities = true;
	@Required
	private String locale = "en";
	@Required
	private boolean lootDeck = true;
	private int maxUndo = 50;
	@Required
	private boolean monsters = true;
	@Required
	private boolean monsterAttackModifierDeck = true;
	@Required
	private boolean moveElements = true;
	@Required
	private boolean partySheet = true;
	@Required
	private boolean randomStandees = false;
	@Required
	private boolean removeUnusedMonster = false;
	@Required
	private boolean scenarioNumberInput = false;
	@Required
	private boolean scenarioRewards = true;
	@Required
	private boolean scenarioRewardsItems = true;
	@Required
	private boolean scenarioRooms = true;
	@Required
	private boolean scenarioRules = true;
	@Required
	private boolean scenarioRulesAutoapply = false;
	@Required
	private boolean scenarioStats = false;
	@Required
	private boolean showExpandedAbilityCard = false;
	@Required
	private boolean showFullAbilityCard = false;
	@Required
	private boolean sortFigures = true;
	@Required
	private LinkedList<String> spoilers = new LinkedList<>();
	@Required
	private boolean standees = true;
	@Required
	private boolean standeeShieldRetaliate = false;
	@Required
	private boolean standeeStats = false;
	@Required
	private boolean stats = true;
	@Required
	private boolean summons = true;
	@Required
	private boolean treasures = true;
	@Required
	private boolean treasuresLoot = true;
	@Required
	private boolean treasuresLootItem = true;
	@Required
	private boolean treasuresLootScenario = true;
	@Required
	private boolean turnConfirmation = true;
	@Required
	private boolean unlockEnvelopeBuildings = true;

	public boolean isAbilities() {
		return abilities;
	}

	public void setAbilities(boolean abilities) {
		this.abilities = abilities;
	}

	public boolean isAbilityNumbers() {
		return abilityNumbers;
	}

	public void setAbilityNumbers(boolean abilityNumbers) {
		this.abilityNumbers = abilityNumbers;
	}

	public boolean isAbilityReveal() {
		return abilityReveal;
	}

	public void setAbilityReveal(boolean abilityReveal) {
		this.abilityReveal = abilityReveal;
	}

	public boolean isActiveApplyConditions() {
		return activeApplyConditions;
	}

	public void setActiveApplyConditions(boolean activeApplyConditions) {
		this.activeApplyConditions = activeApplyConditions;
	}

	public LinkedList<ConditionName> getActiveApplyConditionsAuto() {
		return activeApplyConditionsAuto;
	}

	public void setActiveApplyConditionsAuto(LinkedList<ConditionName> activeApplyConditionsAuto) {
		this.activeApplyConditionsAuto = activeApplyConditionsAuto;
	}

	public LinkedList<ConditionName> getActiveApplyConditionsExcludes() {
		return activeApplyConditionsExcludes;
	}

	public void setActiveApplyConditionsExcludes(LinkedList<ConditionName> activeApplyConditionsExcludes) {
		this.activeApplyConditionsExcludes = activeApplyConditionsExcludes;
	}

	public boolean isActiveStandees() {
		return activeStandees;
	}

	public void setActiveStandees(boolean activeStandees) {
		this.activeStandees = activeStandees;
	}

	public boolean isActiveSummons() {
		return activeSummons;
	}

	public void setActiveSummons(boolean activeSummons) {
		this.activeSummons = activeSummons;
	}

	public boolean isAddAllMonsters() {
		return addAllMonsters;
	}

	public void setAddAllMonsters(boolean addAllMonsters) {
		this.addAllMonsters = addAllMonsters;
	}

	public boolean isAllyAttackModifierDeck() {
		return allyAttackModifierDeck;
	}

	public void setAllyAttackModifierDeck(boolean allyAttackModifierDeck) {
		this.allyAttackModifierDeck = allyAttackModifierDeck;
	}

	public boolean isAlwaysAllyAttackModifierDeck() {
		return alwaysAllyAttackModifierDeck;
	}

	public void setAlwaysAllyAttackModifierDeck(boolean alwaysAllyAttackModifierDeck) {
		this.alwaysAllyAttackModifierDeck = alwaysAllyAttackModifierDeck;
	}

	public boolean isAlwaysFhAdvantage() {
		return alwaysFhAdvantage;
	}

	public void setAlwaysFhAdvantage(boolean alwaysFhAdvantage) {
		this.alwaysFhAdvantage = alwaysFhAdvantage;
	}

	public boolean isAlwaysFhSolo() {
		return alwaysFhSolo;
	}

	public void setAlwaysFhSolo(boolean alwaysFhSolo) {
		this.alwaysFhSolo = alwaysFhSolo;
	}

	public boolean isAlwaysHazardousTerrain() {
		return alwaysHazardousTerrain;
	}

	public void setAlwaysHazardousTerrain(boolean alwaysHazardousTerrain) {
		this.alwaysHazardousTerrain = alwaysHazardousTerrain;
	}

	public boolean isAlwaysLootApplyDialog() {
		return alwaysLootApplyDialog;
	}

	public void setAlwaysLootApplyDialog(boolean alwaysLootApplyDialog) {
		this.alwaysLootApplyDialog = alwaysLootApplyDialog;
	}

	public boolean isAlwaysLootDeck() {
		return alwaysLootDeck;
	}

	public void setAlwaysLootDeck(boolean alwaysLootDeck) {
		this.alwaysLootDeck = alwaysLootDeck;
	}

	public boolean isAmAdvantage() {
		return amAdvantage;
	}

	public void setAmAdvantage(boolean amAdvantage) {
		this.amAdvantage = amAdvantage;
	}

	public boolean isAmAdvantageHouseRule() {
		return amAdvantageHouseRule;
	}

	public void setAmAdvantageHouseRule(boolean amAdvantageHouseRule) {
		this.amAdvantageHouseRule = amAdvantageHouseRule;
	}

	public boolean isApplyBuildingRewards() {
		return applyBuildingRewards;
	}

	public void setApplyBuildingRewards(boolean applyBuildingRewards) {
		this.applyBuildingRewards = applyBuildingRewards;
	}

	public boolean isApplyConditions() {
		return applyConditions;
	}

	public void setApplyConditions(boolean applyConditions) {
		this.applyConditions = applyConditions;
	}

	public LinkedList<ConditionName> getApplyConditionsExcludes() {
		return applyConditionsExcludes;
	}

	public void setApplyConditionsExcludes(LinkedList<ConditionName> applyConditionsExcludes) {
		this.applyConditionsExcludes = applyConditionsExcludes;
	}

	public boolean isApplyLongRest() {
		return applyLongRest;
	}

	public void setApplyLongRest(boolean applyLongRest) {
		this.applyLongRest = applyLongRest;
	}

	public boolean isApplyLoot() {
		return applyLoot;
	}

	public void setApplyLoot(boolean applyLoot) {
		this.applyLoot = applyLoot;
	}

	public boolean isApplyLootRandomItem() {
		return applyLootRandomItem;
	}

	public void setApplyLootRandomItem(boolean applyLootRandomItem) {
		this.applyLootRandomItem = applyLootRandomItem;
	}

	public boolean isApplyRetirement() {
		return applyRetirement;
	}

	public void setApplyRetirement(boolean applyRetirement) {
		this.applyRetirement = applyRetirement;
	}

	public boolean isAutomaticPassTime() {
		return automaticPassTime;
	}

	public void setAutomaticPassTime(boolean automaticPassTime) {
		this.automaticPassTime = automaticPassTime;
	}

	public boolean isAutomaticStandees() {
		return automaticStandees;
	}

	public void setAutomaticStandees(boolean automaticStandees) {
		this.automaticStandees = automaticStandees;
	}

	public boolean isAutomaticStandeesDialog() {
		return automaticStandeesDialog;
	}

	public void setAutomaticStandeesDialog(boolean automaticStandeesDialog) {
		this.automaticStandeesDialog = automaticStandeesDialog;
	}

	public boolean isAutomaticUnlocking() {
		return automaticUnlocking;
	}

	public void setAutomaticUnlocking(boolean automaticUnlocking) {
		this.automaticUnlocking = automaticUnlocking;
	}

	public boolean isBattleGoals() {
		return battleGoals;
	}

	public void setBattleGoals(boolean battleGoals) {
		this.battleGoals = battleGoals;
	}

	public boolean isBattleGoalsCharacter() {
		return battleGoalsCharacter;
	}

	public void setBattleGoalsCharacter(boolean battleGoalsCharacter) {
		this.battleGoalsCharacter = battleGoalsCharacter;
	}

	public boolean isBattleGoalsFh() {
		return battleGoalsFh;
	}

	public void setBattleGoalsFh(boolean battleGoalsFh) {
		this.battleGoalsFh = battleGoalsFh;
	}

	public boolean isBattleGoalsReminder() {
		return battleGoalsReminder;
	}

	public void setBattleGoalsReminder(boolean battleGoalsReminder) {
		this.battleGoalsReminder = battleGoalsReminder;
	}

	public boolean isBbAm() {
		return bbAm;
	}

	public void setBbAm(boolean bbAm) {
		this.bbAm = bbAm;
	}

	public boolean isBbChars() {
		return bbChars;
	}

	public void setBbChars(boolean bbChars) {
		this.bbChars = bbChars;
	}

	public boolean isBbStandeeLimit() {
		return bbStandeeLimit;
	}

	public void setBbStandeeLimit(boolean bbStandeeLimit) {
		this.bbStandeeLimit = bbStandeeLimit;
	}

	public boolean isCalculate() {
		return calculate;
	}

	public void setCalculate(boolean calculate) {
		this.calculate = calculate;
	}

	public boolean isCalculateStats() {
		return calculateStats;
	}

	public void setCalculateStats(boolean calculateStats) {
		this.calculateStats = calculateStats;
	}

	public boolean isCalculateShieldStats() {
		return calculateShieldStats;
	}

	public void setCalculateShieldStats(boolean calculateShieldStats) {
		this.calculateShieldStats = calculateShieldStats;
	}

	public boolean isCharacterAttackModifierDeck() {
		return characterAttackModifierDeck;
	}

	public void setCharacterAttackModifierDeck(boolean characterAttackModifierDeck) {
		this.characterAttackModifierDeck = characterAttackModifierDeck;
	}

	public boolean isCharacterHandSize() {
		return characterHandSize;
	}

	public void setCharacterHandSize(boolean characterHandSize) {
		this.characterHandSize = characterHandSize;
	}

	public boolean isCharacterIdentities() {
		return characterIdentities;
	}

	public void setCharacterIdentities(boolean characterIdentities) {
		this.characterIdentities = characterIdentities;
	}

	public boolean isCharacterIdentityHint() {
		return characterIdentityHint;
	}

	public void setCharacterIdentityHint(boolean characterIdentityHint) {
		this.characterIdentityHint = characterIdentityHint;
	}

	public boolean isCharacterItems() {
		return characterItems;
	}

	public void setCharacterItems(boolean characterItems) {
		this.characterItems = characterItems;
	}

	public boolean isCharacterItemsApply() {
		return characterItemsApply;
	}

	public void setCharacterItemsApply(boolean characterItemsApply) {
		this.characterItemsApply = characterItemsApply;
	}

	public boolean isCharacterSheet() {
		return characterSheet;
	}

	public void setCharacterSheet(boolean characterSheet) {
		this.characterSheet = characterSheet;
	}

	public boolean isCharacterShieldRetaliate() {
		return characterShieldRetaliate;
	}

	public void setCharacterShieldRetaliate(boolean characterShieldRetaliate) {
		this.characterShieldRetaliate = characterShieldRetaliate;
	}

	public boolean isCharacterSortIndex() {
		return characterSortIndex;
	}

	public void setCharacterSortIndex(boolean characterSortIndex) {
		this.characterSortIndex = characterSortIndex;
	}

	public boolean isCharacterTraits() {
		return characterTraits;
	}

	public void setCharacterTraits(boolean characterTraits) {
		this.characterTraits = characterTraits;
	}

	public boolean isCombineInteractiveAbilities() {
		return combineInteractiveAbilities;
	}

	public void setCombineInteractiveAbilities(boolean combineInteractiveAbilities) {
		this.combineInteractiveAbilities = combineInteractiveAbilities;
	}

	public boolean isCombineSummonAction() {
		return combineSummonAction;
	}

	public void setCombineSummonAction(boolean combineSummonAction) {
		this.combineSummonAction = combineSummonAction;
	}

	public boolean isDamageHP() {
		return damageHP;
	}

	public void setDamageHP(boolean damageHP) {
		this.damageHP = damageHP;
	}

	public boolean isDisabledTurnConfirmation() {
		return disabledTurnConfirmation;
	}

	public void setDisabledTurnConfirmation(boolean disabledTurnConfirmation) {
		this.disabledTurnConfirmation = disabledTurnConfirmation;
	}

	public boolean isDisableSortFigures() {
		return disableSortFigures;
	}

	public void setDisableSortFigures(boolean disableSortFigures) {
		this.disableSortFigures = disableSortFigures;
	}

	public boolean isDisableStandees() {
		return disableStandees;
	}

	public void setDisableStandees(boolean disableStandees) {
		this.disableStandees = disableStandees;
	}

	public LinkedList<String> getEditionDataUrls() {
		return editionDataUrls;
	}

	public void setEditionDataUrls(LinkedList<String> editionDataUrls) {
		this.editionDataUrls = editionDataUrls;
	}

	public LinkedList<String> getEditions() {
		return editions;
	}

	public void setEditions(LinkedList<String> editions) {
		this.editions = editions;
	}

	public boolean isEliteFirst() {
		return eliteFirst;
	}

	public void setEliteFirst(boolean eliteFirst) {
		this.eliteFirst = eliteFirst;
	}

	public LinkedList<String> getExcludeEditionDataUrls() {
		return excludeEditionDataUrls;
	}

	public void setExcludeEditionDataUrls(LinkedList<String> excludeEditionDataUrls) {
		this.excludeEditionDataUrls = excludeEditionDataUrls;
	}

	public boolean isExpireConditions() {
		return expireConditions;
	}

	public void setExpireConditions(boolean expireConditions) {
		this.expireConditions = expireConditions;
	}

	public boolean isFhChallenges() {
		return fhChallenges;
	}

	public void setFhChallenges(boolean fhChallenges) {
		this.fhChallenges = fhChallenges;
	}

	public boolean isFhChallengesApply() {
		return fhChallengesApply;
	}

	public void setFhChallengesApply(boolean fhChallengesApply) {
		this.fhChallengesApply = fhChallengesApply;
	}

	public boolean isFhGhItems() {
		return fhGhItems;
	}

	public void setFhGhItems(boolean fhGhItems) {
		this.fhGhItems = fhGhItems;
	}

	public boolean isFhSecondEdition() {
		return fhSecondEdition;
	}

	public void setFhSecondEdition(boolean fhSecondEdition) {
		this.fhSecondEdition = fhSecondEdition;
	}

	public boolean isFhTrials() {
		return fhTrials;
	}

	public void setFhTrials(boolean fhTrials) {
		this.fhTrials = fhTrials;
	}

	public boolean isFhTrialsApply() {
		return fhTrialsApply;
	}

	public void setFhTrialsApply(boolean fhTrialsApply) {
		this.fhTrialsApply = fhTrialsApply;
	}

	public boolean isHideAbsent() {
		return hideAbsent;
	}

	public void setHideAbsent(boolean hideAbsent) {
		this.hideAbsent = hideAbsent;
	}

	public boolean isHideStats() {
		return hideStats;
	}

	public void setHideStats(boolean hideStats) {
		this.hideStats = hideStats;
	}

	public boolean isInitiativeRequired() {
		return initiativeRequired;
	}

	public void setInitiativeRequired(boolean initiativeRequired) {
		this.initiativeRequired = initiativeRequired;
	}

	public boolean isInteractiveAbilities() {
		return interactiveAbilities;
	}

	public void setInteractiveAbilities(boolean interactiveAbilities) {
		this.interactiveAbilities = interactiveAbilities;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public boolean isLootDeck() {
		return lootDeck;
	}

	public void setLootDeck(boolean lootDeck) {
		this.lootDeck = lootDeck;
	}

	public int getMaxUndo() {
		return maxUndo;
	}

	public void setMaxUndo(int maxUndo) {
		this.maxUndo = maxUndo;
	}

	public boolean isMonsters() {
		return monsters;
	}

	public void setMonsters(boolean monsters) {
		this.monsters = monsters;
	}

	public boolean isMonsterAttackModifierDeck() {
		return monsterAttackModifierDeck;
	}

	public void setMonsterAttackModifierDeck(boolean monsterAttackModifierDeck) {
		this.monsterAttackModifierDeck = monsterAttackModifierDeck;
	}

	public boolean isMoveElements() {
		return moveElements;
	}

	public void setMoveElements(boolean moveElements) {
		this.moveElements = moveElements;
	}

	public boolean isPartySheet() {
		return partySheet;
	}

	public void setPartySheet(boolean partySheet) {
		this.partySheet = partySheet;
	}

	public boolean isRandomStandees() {
		return randomStandees;
	}

	public void setRandomStandees(boolean randomStandees) {
		this.randomStandees = randomStandees;
	}

	public boolean isRemoveUnusedMonster() {
		return removeUnusedMonster;
	}

	public void setRemoveUnusedMonster(boolean removeUnusedMonster) {
		this.removeUnusedMonster = removeUnusedMonster;
	}

	public boolean isScenarioNumberInput() {
		return scenarioNumberInput;
	}

	public void setScenarioNumberInput(boolean scenarioNumberInput) {
		this.scenarioNumberInput = scenarioNumberInput;
	}

	public boolean isScenarioRewards() {
		return scenarioRewards;
	}

	public void setScenarioRewards(boolean scenarioRewards) {
		this.scenarioRewards = scenarioRewards;
	}

	public boolean isScenarioRewardsItems() {
		return scenarioRewardsItems;
	}

	public void setScenarioRewardsItems(boolean scenarioRewardsItems) {
		this.scenarioRewardsItems = scenarioRewardsItems;
	}

	public boolean isScenarioRooms() {
		return scenarioRooms;
	}

	public void setScenarioRooms(boolean scenarioRooms) {
		this.scenarioRooms = scenarioRooms;
	}

	public boolean isScenarioRules() {
		return scenarioRules;
	}

	public void setScenarioRules(boolean scenarioRules) {
		this.scenarioRules = scenarioRules;
	}

	public boolean isScenarioRulesAutoapply() {
		return scenarioRulesAutoapply;
	}

	public void setScenarioRulesAutoapply(boolean scenarioRulesAutoapply) {
		this.scenarioRulesAutoapply = scenarioRulesAutoapply;
	}

	public boolean isScenarioStats() {
		return scenarioStats;
	}

	public void setScenarioStats(boolean scenarioStats) {
		this.scenarioStats = scenarioStats;
	}

	public boolean isShowExpandedAbilityCard() {
		return showExpandedAbilityCard;
	}

	public void setShowExpandedAbilityCard(boolean showExpandedAbilityCard) {
		this.showExpandedAbilityCard = showExpandedAbilityCard;
	}

	public boolean isShowFullAbilityCard() {
		return showFullAbilityCard;
	}

	public void setShowFullAbilityCard(boolean showFullAbilityCard) {
		this.showFullAbilityCard = showFullAbilityCard;
	}

	public boolean isSortFigures() {
		return sortFigures;
	}

	public void setSortFigures(boolean sortFigures) {
		this.sortFigures = sortFigures;
	}

	public LinkedList<String> getSpoilers() {
		return spoilers;
	}

	public void setSpoilers(LinkedList<String> spoilers) {
		this.spoilers = spoilers;
	}

	public boolean isStandees() {
		return standees;
	}

	public void setStandees(boolean standees) {
		this.standees = standees;
	}

	public boolean isStandeeShieldRetaliate() {
		return standeeShieldRetaliate;
	}

	public void setStandeeShieldRetaliate(boolean standeeShieldRetaliate) {
		this.standeeShieldRetaliate = standeeShieldRetaliate;
	}

	public boolean isStandeeStats() {
		return standeeStats;
	}

	public void setStandeeStats(boolean standeeStats) {
		this.standeeStats = standeeStats;
	}

	public boolean isStats() {
		return stats;
	}

	public void setStats(boolean stats) {
		this.stats = stats;
	}

	public void setSummons(boolean summons) {
		this.summons = summons;
	}

	public boolean isSummons() {
		return summons;
	}

	public boolean isTreasures() {
		return treasures;
	}

	public void setTreasures(boolean treasures) {
		this.treasures = treasures;
	}

	public boolean isTreasuresLoot() {
		return treasuresLoot;
	}

	public void setTreasuresLoot(boolean treasuresLoot) {
		this.treasuresLoot = treasuresLoot;
	}

	public boolean isTreasuresLootItem() {
		return treasuresLootItem;
	}

	public void setTreasuresLootItem(boolean treasuresLootItem) {
		this.treasuresLoot = treasuresLootItem;
	}

	public boolean isTreasuresLootScenario() {
		return treasuresLootScenario;
	}

	public void setTreasuresLootScenario(boolean treasuresLootScenario) {
		this.treasuresLootScenario = treasuresLootScenario;
	}

	public boolean isTurnConfirmation() {
		return turnConfirmation;
	}

	public void setTurnConfirmation(boolean turnConfirmation) {
		this.turnConfirmation = turnConfirmation;
	}

	public boolean isUnlockEnvelopeBuildings() {
		return unlockEnvelopeBuildings;
	}

	public void setUnlockEnvelopeBuildings(boolean unlockEnvelopeBuildings) {
		this.unlockEnvelopeBuildings = unlockEnvelopeBuildings;
	}

}
