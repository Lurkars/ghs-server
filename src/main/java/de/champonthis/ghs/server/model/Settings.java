/**
 * 
 */
package de.champonthis.ghs.server.model;

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
	private boolean activeStandees = true;
	@Required
	private boolean activeSummons = true;
	@Required
	private boolean alwaysAllyAttackModifierDeck = true;
	@Required
	private boolean alwaysFhSolo = true;
	@Required
	private boolean alwaysHazardousTerrain = true;
	@Required
	private boolean alwaysLootApplyDialog = false;
	@Required
	private boolean alwaysLootDeck = false;
	@Required
	private boolean applyConditions = true;
	@Required
	private boolean applyLoot = true;
	@Required
	private boolean automaticStandees = true;
	@Required
	private boolean calculate = true;
	@Required
	private boolean calculateStats = true;
	@Required
	private boolean characterHandSize = false;
	@Required
	private boolean combineSummonAction = true;
	@Required
	private boolean disableDragFigures = false;
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
	private boolean hideAbsent = false;
	@Required
	private boolean hideStats = true;
	@Required
	private boolean hints = true;
	@Required
	private boolean initiativeRequired = true;
	@Required
	private boolean interactiveAbilities = true;
	@Required
	private String locale = "en";
	private int maxUndo = 50;
	@Required
	private boolean moveElements = true;
	@Required
	private boolean randomStandees = false;
	@Required
	private boolean scenarioNumberInput = false;
	@Required
	private boolean scenarioRooms = true;
	@Required
	private boolean scenarioRules = true;
	@Required
	private boolean showFullAbilityCard = false;
	@Required
	private LinkedList<String> spoilers = new LinkedList<>();
	@Required
	private boolean treasures = true;
	@Required
	private boolean treasuresLoot = true;

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
	 * Checks if is disable drag figures.
	 *
	 * @return true, if is disable drag figures
	 */
	public boolean isDisableDragFigures() {
		return disableDragFigures;
	}

	/**
	 * Sets the disable drag figures.
	 *
	 * @param disableDragFigures the new disable drag figures
	 */
	public void setDisableDragFigures(boolean disableDragFigures) {
		this.disableDragFigures = disableDragFigures;
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
	 * Checks if is hints.
	 *
	 * @return true, if is hints
	 */
	public boolean isHints() {
		return hints;
	}

	/**
	 * Sets the hints.
	 *
	 * @param hints the new hints
	 */
	public void setHints(boolean hints) {
		this.hints = hints;
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

}
