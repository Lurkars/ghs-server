/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.Arrays;
import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Settings.
 */
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
	private boolean alwaysFhSolo = false;
	@Required
	private boolean alwaysHazardousTerrain = false;
	@Required
	private boolean alwaysLootApplyDialog = false;
	@Required
	private boolean alwaysLootDeck = false;
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
	private boolean battleGoalsReminder = false;
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
	private boolean characterItems = true;
	@Required
	private boolean characterSheet = true;
	@Required
	private boolean characterTraits = false;
	@Required
	private boolean combineSummonAction = true;
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
	private boolean fhGhItems = false;
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
	private boolean standeeStats = false;
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

	/**
	 * Checks if is abilities.
	 *
	 * @return true, if is abilities
	 */
	public boolean isAbilities() {
		return abilities;
	}

	/**
	 * Sets the abilities.
	 *
	 * @param abilities the new abilities
	 */
	public void setAbilities(boolean abilities) {
		this.abilities = abilities;
	}

	/**
	 * Checks if is ability numbers.
	 *
	 * @return true, if is ability numbers
	 */
	public boolean isAbilityNumbers() {
		return abilityNumbers;
	}

	/**
	 * Sets the ability numbers.
	 *
	 * @param abilityNumbers the new ability numbers
	 */
	public void setAbilityNumbers(boolean abilityNumbers) {
		this.abilityNumbers = abilityNumbers;
	}

	/**
	 * Checks if is ability reveal.
	 *
	 * @return true, if is ability reveal
	 */
	public boolean isAbilityReveal() {
		return abilityReveal;
	}

	/**
	 * Sets the ability reveal.
	 *
	 * @param abilityReveal the new ability reveal
	 */
	public void setAbilityReveal(boolean abilityReveal) {
		this.abilityReveal = abilityReveal;
	}

	/**
	 * Checks if is active apply conditions.
	 *
	 * @return true, if is active apply conditions
	 */
	public boolean isActiveApplyConditions() {
		return activeApplyConditions;
	}

	/**
	 * Sets the active apply conditions.
	 *
	 * @param activeApplyConditions the new active apply conditions
	 */
	public void setActiveApplyConditions(boolean activeApplyConditions) {
		this.activeApplyConditions = activeApplyConditions;
	}

	/**
	 * Gets the active apply conditions excludes.
	 *
	 * @return the active apply conditions excludes
	 */
	public LinkedList<ConditionName> getActiveApplyConditionsExcludes() {
		return activeApplyConditionsExcludes;
	}

	/**
	 * Sets the active apply conditions excludes.
	 *
	 * @param activeApplyConditionsExcludes the new active apply conditions excludes
	 */
	public void setActiveApplyConditionsExcludes(LinkedList<ConditionName> activeApplyConditionsExcludes) {
		this.activeApplyConditionsExcludes = activeApplyConditionsExcludes;
	}

	/**
	 * Checks if is active standees.
	 *
	 * @return true, if is active standees
	 */
	public boolean isActiveStandees() {
		return activeStandees;
	}

	/**
	 * Sets the active standees.
	 *
	 * @param activeStandees the new active standees
	 */
	public void setActiveStandees(boolean activeStandees) {
		this.activeStandees = activeStandees;
	}

	/**
	 * Checks if is active summons.
	 *
	 * @return true, if is active summons
	 */
	public boolean isActiveSummons() {
		return activeSummons;
	}

	/**
	 * Sets the active summons.
	 *
	 * @param activeSummons the new active summons
	 */
	public void setActiveSummons(boolean activeSummons) {
		this.activeSummons = activeSummons;
	}

	/**
	 * Checks if is adds the all monsters.
	 *
	 * @return true, if is adds the all monsters
	 */
	public boolean isAddAllMonsters() {
		return addAllMonsters;
	}

	/**
	 * Sets the adds the all monsters.
	 *
	 * @param addAllMonsters the new adds the all monsters
	 */
	public void setAddAllMonsters(boolean addAllMonsters) {
		this.addAllMonsters = addAllMonsters;
	}

	/**
	 * Checks if is ally attack modifier deck.
	 *
	 * @return true, if is ally attack modifier deck
	 */
	public boolean isAllyAttackModifierDeck() {
		return allyAttackModifierDeck;
	}

	/**
	 * Sets the ally attack modifier deck.
	 *
	 * @param allyAttackModifierDeck the new ally attack modifier deck
	 */
	public void setAllyAttackModifierDeck(boolean allyAttackModifierDeck) {
		this.allyAttackModifierDeck = allyAttackModifierDeck;
	}

	/**
	 * Checks if is always ally attack modifier deck.
	 *
	 * @return true, if is always ally attack modifier deck
	 */
	public boolean isAlwaysAllyAttackModifierDeck() {
		return alwaysAllyAttackModifierDeck;
	}

	/**
	 * Sets the always ally attack modifier deck.
	 *
	 * @param alwaysAllyAttackModifierDeck the new always ally attack modifier deck
	 */
	public void setAlwaysAllyAttackModifierDeck(boolean alwaysAllyAttackModifierDeck) {
		this.alwaysAllyAttackModifierDeck = alwaysAllyAttackModifierDeck;
	}

	/**
	 * Checks if is always fh solo.
	 *
	 * @return true, if is always fh solo
	 */
	public boolean isAlwaysFhSolo() {
		return alwaysFhSolo;
	}

	/**
	 * Sets the always fh solo.
	 *
	 * @param alwaysFhSolo the new always fh solo
	 */
	public void setAlwaysFhSolo(boolean alwaysFhSolo) {
		this.alwaysFhSolo = alwaysFhSolo;
	}

	/**
	 * Checks if is always hazardous terrain.
	 *
	 * @return true, if is always hazardous terrain
	 */
	public boolean isAlwaysHazardousTerrain() {
		return alwaysHazardousTerrain;
	}

	/**
	 * Sets the always hazardous terrain.
	 *
	 * @param alwaysHazardousTerrain the new always hazardous terrain
	 */
	public void setAlwaysHazardousTerrain(boolean alwaysHazardousTerrain) {
		this.alwaysHazardousTerrain = alwaysHazardousTerrain;
	}

	/**
	 * Checks if is always loot apply dialog.
	 *
	 * @return true, if is always loot apply dialog
	 */
	public boolean isAlwaysLootApplyDialog() {
		return alwaysLootApplyDialog;
	}

	/**
	 * Sets the always loot apply dialog.
	 *
	 * @param alwaysLootApplyDialog the new always loot apply dialog
	 */
	public void setAlwaysLootApplyDialog(boolean alwaysLootApplyDialog) {
		this.alwaysLootApplyDialog = alwaysLootApplyDialog;
	}

	/**
	 * Checks if is always loot deck.
	 *
	 * @return true, if is always loot deck
	 */
	public boolean isAlwaysLootDeck() {
		return alwaysLootDeck;
	}

	/**
	 * Sets the always loot deck.
	 *
	 * @param alwaysLootDeck the new always loot deck
	 */
	public void setAlwaysLootDeck(boolean alwaysLootDeck) {
		this.alwaysLootDeck = alwaysLootDeck;
	}

	/**
	 * Checks if is apply building rewards.
	 *
	 * @return true, if is apply building rewards
	 */
	public boolean isApplyBuildingRewards() {
		return applyBuildingRewards;
	}

	/**
	 * Sets the apply building rewards.
	 *
	 * @param applyBuildingRewards the new apply building rewards
	 */
	public void setApplyBuildingRewards(boolean applyBuildingRewards) {
		this.applyBuildingRewards = applyBuildingRewards;
	}

	/**
	 * Checks if is apply conditions.
	 *
	 * @return true, if is apply conditions
	 */
	public boolean isApplyConditions() {
		return applyConditions;
	}

	/**
	 * Sets the apply conditions.
	 *
	 * @param applyConditions the new apply conditions
	 */
	public void setApplyConditions(boolean applyConditions) {
		this.applyConditions = applyConditions;
	}

	/**
	 * Gets the apply conditions excludes.
	 *
	 * @return the apply conditions excludes
	 */
	public LinkedList<ConditionName> getApplyConditionsExcludes() {
		return applyConditionsExcludes;
	}

	/**
	 * Sets the apply conditions excludes.
	 *
	 * @param applyConditionsExcludes the new apply conditions excludes
	 */
	public void setApplyConditionsExcludes(LinkedList<ConditionName> applyConditionsExcludes) {
		this.applyConditionsExcludes = applyConditionsExcludes;
	}

	/**
	 * Checks if is apply long rest.
	 *
	 * @return true, if is apply long rest
	 */
	public boolean isApplyLongRest() {
		return applyLongRest;
	}

	/**
	 * Sets the apply long rest.
	 *
	 * @param applyLongRest the new apply long rest
	 */
	public void setApplyLongRest(boolean applyLongRest) {
		this.applyLongRest = applyLongRest;
	}

	/**
	 * Checks if is apply loot.
	 *
	 * @return true, if is apply loot
	 */
	public boolean isApplyLoot() {
		return applyLoot;
	}

	/**
	 * Sets the apply loot.
	 *
	 * @param applyLoot the new apply loot
	 */
	public void setApplyLoot(boolean applyLoot) {
		this.applyLoot = applyLoot;
	}

	/**
	 * Checks if is apply loot random item.
	 *
	 * @return true, if is apply loot random item
	 */
	public boolean isApplyLootRandomItem() {
		return applyLootRandomItem;
	}

	/**
	 * Sets the apply loot random item.
	 *
	 * @param applyLootRandomItem the new apply loot random item
	 */
	public void setApplyLootRandomItem(boolean applyLootRandomItem) {
		this.applyLootRandomItem = applyLootRandomItem;
	}

	/**
	 * Checks if is apply retirement.
	 *
	 * @return true, if is apply retirement
	 */
	public boolean isApplyRetirement() {
		return applyRetirement;
	}

	/**
	 * Sets the apply retirement.
	 *
	 * @param applyRetirement the new apply retirement
	 */
	public void setApplyRetirement(boolean applyRetirement) {
		this.applyRetirement = applyRetirement;
	}

	/**
	 * Checks if is automatic pass time.
	 *
	 * @return true, if is automatic pass time
	 */
	public boolean isAutomaticPassTime() {
		return automaticPassTime;
	}

	/**
	 * Sets the automatic pass time.
	 *
	 * @param automaticPassTime the new automatic pass time
	 */
	public void setAutomaticPassTime(boolean automaticPassTime) {
		this.automaticPassTime = automaticPassTime;
	}

	/**
	 * Checks if is automatic standees.
	 *
	 * @return true, if is automatic standees
	 */
	public boolean isAutomaticStandees() {
		return automaticStandees;
	}

	/**
	 * Sets the automatic standees.
	 *
	 * @param automaticStandees the new automatic standees
	 */
	public void setAutomaticStandees(boolean automaticStandees) {
		this.automaticStandees = automaticStandees;
	}

	/**
	 * Checks if is automatic standees dialog.
	 *
	 * @return true, if is automatic standees dialog
	 */
	public boolean isAutomaticStandeesDialog() {
		return automaticStandeesDialog;
	}

	/**
	 * Sets the automatic standees dialog.
	 *
	 * @param automaticStandeesDialog the new automatic standees dialog
	 */
	public void setAutomaticStandeesDialog(boolean automaticStandeesDialog) {
		this.automaticStandeesDialog = automaticStandeesDialog;
	}

	/**
	 * Checks if is automatic unlocking.
	 *
	 * @return true, if is automatic unlocking
	 */
	public boolean isAutomaticUnlocking() {
		return automaticUnlocking;
	}

	/**
	 * Sets the automatic unlocking.
	 *
	 * @param automaticUnlocking the new automatic unlocking
	 */
	public void setAutomaticUnlocking(boolean automaticUnlocking) {
		this.automaticUnlocking = automaticUnlocking;
	}

	/**
	 * Checks if is battle goals.
	 *
	 * @return true, if is battle goals
	 */
	public boolean isBattleGoals() {
		return battleGoals;
	}

	/**
	 * Sets the battle goals.
	 *
	 * @param battleGoals the new battle goals
	 */
	public void setBattleGoals(boolean battleGoals) {
		this.battleGoals = battleGoals;
	}

	/**
	 * Checks if is battle goals character.
	 *
	 * @return true, if is battle goals character
	 */
	public boolean isBattleGoalsCharacter() {
		return battleGoalsCharacter;
	}

	/**
	 * Sets the battle goals character.
	 *
	 * @param battleGoalsCharacter the new battle goals character
	 */
	public void setBattleGoalsCharacter(boolean battleGoalsCharacter) {
		this.battleGoalsCharacter = battleGoalsCharacter;
	}

	/**
	 * Checks if is battle goals fh.
	 *
	 * @return true, if is battle goals fh
	 */
	public boolean isBattleGoalsFh() {
		return battleGoalsFh;
	}

	/**
	 * Sets the battle goals fh.
	 *
	 * @param battleGoalsFh the new battle goals fh
	 */
	public void setBattleGoalsFh(boolean battleGoalsFh) {
		this.battleGoalsFh = battleGoalsFh;
	}

	/**
	 * Checks if is battle goals reminder.
	 *
	 * @return true, if is battle goals reminder
	 */
	public boolean isBattleGoalsReminder() {
		return battleGoalsReminder;
	}

	/**
	 * Sets the battle goals reminder.
	 *
	 * @param battleGoalsReminder the new battle goals reminder
	 */
	public void setBattleGoalsReminder(boolean battleGoalsReminder) {
		this.battleGoalsReminder = battleGoalsReminder;
	}

	/**
	 * Checks if is calculate.
	 *
	 * @return true, if is calculate
	 */
	public boolean isCalculate() {
		return calculate;
	}

	/**
	 * Sets the calculate.
	 *
	 * @param calculate the new calculate
	 */
	public void setCalculate(boolean calculate) {
		this.calculate = calculate;
	}

	/**
	 * Checks if is calculate stats.
	 *
	 * @return true, if is calculate stats
	 */
	public boolean isCalculateStats() {
		return calculateStats;
	}

	/**
	 * Sets the calculate stats.
	 *
	 * @param calculateStats the new calculate stats
	 */
	public void setCalculateStats(boolean calculateStats) {
		this.calculateStats = calculateStats;
	}

	/**
	 * Checks if is calculate shield stats.
	 *
	 * @return true, if is calculate shield stats
	 */
	public boolean isCalculateShieldStats() {
		return calculateShieldStats;
	}

	/**
	 * Sets the calculate shield stats.
	 *
	 * @param calculateShieldStats the new calculate shield stats
	 */
	public void setCalculateShieldStats(boolean calculateShieldStats) {
		this.calculateShieldStats = calculateShieldStats;
	}

	/**
	 * Checks if is character attack modifier deck.
	 *
	 * @return true, if is character attack modifier deck
	 */
	public boolean isCharacterAttackModifierDeck() {
		return characterAttackModifierDeck;
	}

	/**
	 * Sets the character attack modifier deck.
	 *
	 * @param characterAttackModifierDeck the new character attack modifier deck
	 */
	public void setCharacterAttackModifierDeck(boolean characterAttackModifierDeck) {
		this.characterAttackModifierDeck = characterAttackModifierDeck;
	}

	/**
	 * Checks if is character hand size.
	 *
	 * @return true, if is character hand size
	 */
	public boolean isCharacterHandSize() {
		return characterHandSize;
	}

	/**
	 * Sets the character hand size.
	 *
	 * @param characterHandSize the new character hand size
	 */
	public void setCharacterHandSize(boolean characterHandSize) {
		this.characterHandSize = characterHandSize;
	}

	/**
	 * Checks if is character identities.
	 *
	 * @return true, if is character identities
	 */
	public boolean isCharacterIdentities() {
		return characterIdentities;
	}

	/**
	 * Sets the character identities.
	 *
	 * @param characterIdentities the new character identities
	 */
	public void setCharacterIdentities(boolean characterIdentities) {
		this.characterIdentities = characterIdentities;
	}

	/**
	 * Checks if is character identity hint.
	 *
	 * @return true, if is character identity hint
	 */
	public boolean isCharacterIdentityHint() {
		return characterIdentityHint;
	}

	/**
	 * Sets the character identity hint.
	 *
	 * @param characterIdentityHint the new character identity hint
	 */
	public void setCharacterIdentityHint(boolean characterIdentityHint) {
		this.characterIdentityHint = characterIdentityHint;
	}

	/**
	 * Checks if is character items.
	 *
	 * @return true, if is character items
	 */
	public boolean isCharacterItems() {
		return characterItems;
	}

	/**
	 * Sets the character items.
	 *
	 * @param characterItems the new character items
	 */
	public void setCharacterItems(boolean characterItems) {
		this.characterItems = characterItems;
	}

	/**
	 * Checks if is character sheet.
	 *
	 * @return true, if is character sheet
	 */
	public boolean isCharacterSheet() {
		return characterSheet;
	}

	/**
	 * Sets the character sheet.
	 *
	 * @param characterSheet the new character sheet
	 */
	public void setCharacterSheet(boolean characterSheet) {
		this.characterSheet = characterSheet;
	}

	/**
	 * Checks if is character traits.
	 *
	 * @return true, if is character traits
	 */
	public boolean isCharacterTraits() {
		return characterTraits;
	}

	/**
	 * Sets the character traits.
	 *
	 * @param characterTraits the new character traits
	 */
	public void setCharacterTraits(boolean characterTraits) {
		this.characterTraits = characterTraits;
	}

	/**
	 * Checks if is combine summon action.
	 *
	 * @return true, if is combine summon action
	 */
	public boolean isCombineSummonAction() {
		return combineSummonAction;
	}

	/**
	 * Sets the combine summon action.
	 *
	 * @param combineSummonAction the new combine summon action
	 */
	public void setCombineSummonAction(boolean combineSummonAction) {
		this.combineSummonAction = combineSummonAction;
	}

	/**
	 * Checks if is disabled turn confirmation.
	 *
	 * @return true, if is disabled turn confirmation
	 */
	public boolean isDisabledTurnConfirmation() {
		return disabledTurnConfirmation;
	}

	/**
	 * Sets the disabled turn confirmation.
	 *
	 * @param disabledTurnConfirmation the new disabled turn confirmation
	 */
	public void setDisabledTurnConfirmation(boolean disabledTurnConfirmation) {
		this.disabledTurnConfirmation = disabledTurnConfirmation;
	}

	/**
	 * Checks if is disable sort figures.
	 *
	 * @return true, if is disable sort figures
	 */
	public boolean isDisableSortFigures() {
		return disableSortFigures;
	}

	/**
	 * Sets the disable sort figures.
	 *
	 * @param disableSortFigures the new disable sort figures
	 */
	public void setDisableSortFigures(boolean disableSortFigures) {
		this.disableSortFigures = disableSortFigures;
	}

	/**
	 * Checks if is disable standees.
	 *
	 * @return true, if is disable standees
	 */
	public boolean isDisableStandees() {
		return disableStandees;
	}

	/**
	 * Sets the disable standees.
	 *
	 * @param disableStandees the new disable standees
	 */
	public void setDisableStandees(boolean disableStandees) {
		this.disableStandees = disableStandees;
	}

	/**
	 * Gets the edition data urls.
	 *
	 * @return the edition data urls
	 */
	public LinkedList<String> getEditionDataUrls() {
		return editionDataUrls;
	}

	/**
	 * Sets the edition data urls.
	 *
	 * @param editionDataUrls the new edition data urls
	 */
	public void setEditionDataUrls(LinkedList<String> editionDataUrls) {
		this.editionDataUrls = editionDataUrls;
	}

	/**
	 * Gets the editions.
	 *
	 * @return the editions
	 */
	public LinkedList<String> getEditions() {
		return editions;
	}

	/**
	 * Sets the editions.
	 *
	 * @param editions the new editions
	 */
	public void setEditions(LinkedList<String> editions) {
		this.editions = editions;
	}

	/**
	 * Checks if is elite first.
	 *
	 * @return true, if is elite first
	 */
	public boolean isEliteFirst() {
		return eliteFirst;
	}

	/**
	 * Sets the elite first.
	 *
	 * @param eliteFirst the new elite first
	 */
	public void setEliteFirst(boolean eliteFirst) {
		this.eliteFirst = eliteFirst;
	}

	/**
	 * Gets the exclude edition data urls.
	 *
	 * @return the exclude edition data urls
	 */
	public LinkedList<String> getExcludeEditionDataUrls() {
		return excludeEditionDataUrls;
	}

	/**
	 * Sets the exclude edition data urls.
	 *
	 * @param excludeEditionDataUrls the new exclude edition data urls
	 */
	public void setExcludeEditionDataUrls(LinkedList<String> excludeEditionDataUrls) {
		this.excludeEditionDataUrls = excludeEditionDataUrls;
	}

	/**
	 * Checks if is expire conditions.
	 *
	 * @return true, if is expire conditions
	 */
	public boolean isExpireConditions() {
		return expireConditions;
	}

	/**
	 * Sets the expire conditions.
	 *
	 * @param expireConditions the new expire conditions
	 */
	public void setExpireConditions(boolean expireConditions) {
		this.expireConditions = expireConditions;
	}

	/**
	 * Checks if is fh gh items.
	 *
	 * @return true, if is fh gh items
	 */
	public boolean isFhGhItems() {
		return fhGhItems;
	}

	/**
	 * Sets the fh gh items.
	 *
	 * @param fhGhItems the new fh gh items
	 */
	public void setFhGhItems(boolean fhGhItems) {
		this.fhGhItems = fhGhItems;
	}

	/**
	 * Checks if is hide absent.
	 *
	 * @return true, if is hide absent
	 */
	public boolean isHideAbsent() {
		return hideAbsent;
	}

	/**
	 * Sets the hide absent.
	 *
	 * @param hideAbsent the new hide absent
	 */
	public void setHideAbsent(boolean hideAbsent) {
		this.hideAbsent = hideAbsent;
	}

	/**
	 * Checks if is hide stats.
	 *
	 * @return true, if is hide stats
	 */
	public boolean isHideStats() {
		return hideStats;
	}

	/**
	 * Sets the hide stats.
	 *
	 * @param hideStats the new hide stats
	 */
	public void setHideStats(boolean hideStats) {
		this.hideStats = hideStats;
	}

	/**
	 * Checks if is initiative required.
	 *
	 * @return true, if is initiative required
	 */
	public boolean isInitiativeRequired() {
		return initiativeRequired;
	}

	/**
	 * Sets the initiative required.
	 *
	 * @param initiativeRequired the new initiative required
	 */
	public void setInitiativeRequired(boolean initiativeRequired) {
		this.initiativeRequired = initiativeRequired;
	}

	/**
	 * Checks if is interactive abilities.
	 *
	 * @return true, if is interactive abilities
	 */
	public boolean isInteractiveAbilities() {
		return interactiveAbilities;
	}

	/**
	 * Sets the interactive abilities.
	 *
	 * @param interactiveAbilities the new interactive abilities
	 */
	public void setInteractiveAbilities(boolean interactiveAbilities) {
		this.interactiveAbilities = interactiveAbilities;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale the new locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * Checks if is loot deck.
	 *
	 * @return true, if is loot deck
	 */
	public boolean isLootDeck() {
		return lootDeck;
	}

	/**
	 * Sets the loot deck.
	 *
	 * @param lootDeck the new loot deck
	 */
	public void setLootDeck(boolean lootDeck) {
		this.lootDeck = lootDeck;
	}

	/**
	 * Gets the max undo.
	 *
	 * @return the max undo
	 */
	public int getMaxUndo() {
		return maxUndo;
	}

	/**
	 * Sets the max undo.
	 *
	 * @param maxUndo the new max undo
	 */
	public void setMaxUndo(int maxUndo) {
		this.maxUndo = maxUndo;
	}

	/**
	 * Checks if is monsters.
	 *
	 * @return true, if is monsters
	 */
	public boolean isMonsters() {
		return monsters;
	}

	/**
	 * Sets the monsters.
	 *
	 * @param monsters the new monsters
	 */
	public void setMonsters(boolean monsters) {
		this.monsters = monsters;
	}

	/**
	 * Checks if is monster attack modifier deck.
	 *
	 * @return true, if is monster attack modifier deck
	 */
	public boolean isMonsterAttackModifierDeck() {
		return monsterAttackModifierDeck;
	}

	/**
	 * Sets the monster attack modifier deck.
	 *
	 * @param monsterAttackModifierDeck the new monster attack modifier deck
	 */
	public void setMonsterAttackModifierDeck(boolean monsterAttackModifierDeck) {
		this.monsterAttackModifierDeck = monsterAttackModifierDeck;
	}

	/**
	 * Checks if is move elements.
	 *
	 * @return true, if is move elements
	 */
	public boolean isMoveElements() {
		return moveElements;
	}

	/**
	 * Sets the move elements.
	 *
	 * @param moveElements the new move elements
	 */
	public void setMoveElements(boolean moveElements) {
		this.moveElements = moveElements;
	}

	/**
	 * Checks if is party sheet.
	 *
	 * @return true, if is party sheet
	 */
	public boolean isPartySheet() {
		return partySheet;
	}

	/**
	 * Sets the party sheet.
	 *
	 * @param partySheet the new party sheet
	 */
	public void setPartySheet(boolean partySheet) {
		this.partySheet = partySheet;
	}

	/**
	 * Checks if is random standees.
	 *
	 * @return true, if is random standees
	 */
	public boolean isRandomStandees() {
		return randomStandees;
	}

	/**
	 * Sets the random standees.
	 *
	 * @param randomStandees the new random standees
	 */
	public void setRandomStandees(boolean randomStandees) {
		this.randomStandees = randomStandees;
	}

	/**
	 * Checks if is remove unused monster.
	 *
	 * @return true, if is remove unused monster
	 */
	public boolean isremoveUnusedMonster() {
		return removeUnusedMonster;
	}

	/**
	 * Sets the remove unused monster.
	 *
	 * @param removeUnusedMonster the new remove unused monster
	 */
	public void setRemoveUnusedMonster(boolean removeUnusedMonster) {
		this.removeUnusedMonster = removeUnusedMonster;
	}

	/**
	 * Checks if is scenario number input.
	 *
	 * @return true, if is scenario number input
	 */
	public boolean isScenarioNumberInput() {
		return scenarioNumberInput;
	}

	/**
	 * Sets the scenario number input.
	 *
	 * @param scenarioNumberInput the new scenario number input
	 */
	public void setScenarioNumberInput(boolean scenarioNumberInput) {
		this.scenarioNumberInput = scenarioNumberInput;
	}

	/**
	 * Checks if is scenario rewards.
	 *
	 * @return true, if is scenario rewards
	 */
	public boolean isScenarioRewards() {
		return scenarioRewards;
	}

	/**
	 * Sets the scenario rewards.
	 *
	 * @param scenarioRewards the new scenario rewards
	 */
	public void setScenarioRewards(boolean scenarioRewards) {
		this.scenarioRewards = scenarioRewards;
	}

	/**
	 * Checks if is scenario rewards.
	 *
	 * @return true, if is scenario rewards
	 */
	public boolean isScenarioRewardsItems() {
		return scenarioRewardsItems;
	}

	/**
	 * Sets the scenario rewards items.
	 *
	 * @param scenarioRewardsItems the new scenario rewards items
	 */
	public void setScenarioRewardsItems(boolean scenarioRewardsItems) {
		this.scenarioRewardsItems = scenarioRewardsItems;
	}

	/**
	 * Checks if is scenario rooms.
	 *
	 * @return true, if is scenario rooms
	 */
	public boolean isScenarioRooms() {
		return scenarioRooms;
	}

	/**
	 * Sets the scenario rooms.
	 *
	 * @param scenarioRooms the new scenario rooms
	 */
	public void setScenarioRooms(boolean scenarioRooms) {
		this.scenarioRooms = scenarioRooms;
	}

	/**
	 * Checks if is scenario rules.
	 *
	 * @return true, if is scenario rules
	 */
	public boolean isScenarioRules() {
		return scenarioRules;
	}

	/**
	 * Sets the scenario rules.
	 *
	 * @param scenarioRules the new scenario rules
	 */
	public void setScenarioRules(boolean scenarioRules) {
		this.scenarioRules = scenarioRules;
	}

	/**
	 * Checks if is show expanded ability card.
	 *
	 * @return true, if is show expanded ability card
	 */
	public boolean isShowExpandedAbilityCard() {
		return showExpandedAbilityCard;
	}

	/**
	 * Sets the show expanded ability card.
	 *
	 * @param showExpandedAbilityCard the new show expanded ability card
	 */
	public void setShowExpandedAbilityCard(boolean showExpandedAbilityCard) {
		this.showExpandedAbilityCard = showExpandedAbilityCard;
	}

	/**
	 * Checks if is show full ability card.
	 *
	 * @return true, if is show full ability card
	 */
	public boolean isShowFullAbilityCard() {
		return showFullAbilityCard;
	}

	/**
	 * Sets the show full ability card.
	 *
	 * @param showFullAbilityCard the new show full ability card
	 */
	public void setShowFullAbilityCard(boolean showFullAbilityCard) {
		this.showFullAbilityCard = showFullAbilityCard;
	}

	/**
	 * Checks if is sort figures.
	 *
	 * @return true, if is sort figures
	 */
	public boolean isSortFigures() {
		return sortFigures;
	}

	/**
	 * Sets the sort figures.
	 *
	 * @param sortFigures the new sort figures
	 */
	public void setSortFigures(boolean sortFigures) {
		this.sortFigures = sortFigures;
	}

	/**
	 * Gets the spoilers.
	 *
	 * @return the spoilers
	 */
	public LinkedList<String> getSpoilers() {
		return spoilers;
	}

	/**
	 * Sets the spoilers.
	 *
	 * @param spoilers the new spoilers
	 */
	public void setSpoilers(LinkedList<String> spoilers) {
		this.spoilers = spoilers;
	}

	/**
	 * Checks if is standees.
	 *
	 * @return true, if is standees
	 */
	public boolean isStandees() {
		return standees;
	}

	/**
	 * Sets the standees.
	 *
	 * @param standees the new standees
	 */
	public void setStandees(boolean standees) {
		this.standees = standees;
	}

	/**
	 * Checks if is standee stats.
	 *
	 * @return true, if is standee stats
	 */
	public boolean isStandeeStats() {
		return standeeStats;
	}

	/**
	 * Sets the standee stats.
	 *
	 * @param standeeStats the new standee stats
	 */
	public void setStandeeStats(boolean standeeStats) {
		this.standeeStats = standeeStats;
	}

	/**
	 * Sets the summons.
	 *
	 * @param summons the new summons
	 */
	public void setSummons(boolean summons) {
		this.summons = summons;
	}

	/**
	 * Checks if is summons.
	 *
	 * @return true, if is summons
	 */
	public boolean isSummons() {
		return summons;
	}

	/**
	 * Checks if is treasures.
	 *
	 * @return true, if is treasures
	 */
	public boolean isTreasures() {
		return treasures;
	}

	/**
	 * Sets the treasures.
	 *
	 * @param treasures the new treasures
	 */
	public void setTreasures(boolean treasures) {
		this.treasures = treasures;
	}

	/**
	 * Checks if is treasures loot.
	 *
	 * @return true, if is treasures loot
	 */
	public boolean isTreasuresLoot() {
		return treasuresLoot;
	}

	/**
	 * Sets the treasures loot.
	 *
	 * @param treasuresLoot the new treasures loot
	 */
	public void setTreasuresLoot(boolean treasuresLoot) {
		this.treasuresLoot = treasuresLoot;
	}

	/**
	 * Checks if is treasures loot item.
	 *
	 * @return true, if is treasures loot item
	 */
	public boolean isTreasuresLootItem() {
		return treasuresLootItem;
	}

	/**
	 * Sets the treasures loot item.
	 *
	 * @param treasuresLootItem the new treasures loot item
	 */
	public void setTreasuresLootItem(boolean treasuresLootItem) {
		this.treasuresLoot = treasuresLootItem;
	}

	/**
	 * Checks if is treasures loot.
	 *
	 * @return true, if is treasures loot
	 */
	public boolean isTreasuresLootScenario() {
		return treasuresLootScenario;
	}

	/**
	 * Sets the treasures loot scenario.
	 *
	 * @param treasuresLootScenario the new treasures loot scenario
	 */
	public void setTreasuresLootScenario(boolean treasuresLootScenario) {
		this.treasuresLootScenario = treasuresLootScenario;
	}



	/**
	 * Checks if is turn confirmation.
	 *
	 * @return true, if is turn confirmation
	 */
	public boolean isTurnConfirmation() {
		return turnConfirmation;
	}

	/**
	 * Sets the turn confirmation.
	 *
	 * @param turnConfirmation the new turn confirmation
	 */
	public void setTurnConfirmation(boolean turnConfirmation) {
		this.turnConfirmation = turnConfirmation;
	}

}
