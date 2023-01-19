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
	private boolean calculate = true;
	@Required
	private boolean calculateStats = true;
	@Required
	private boolean abilityNumbers = true;
	@Required
	private boolean eliteFirst = true;
	@Required
	private boolean expireConditions = true;
	@Required
	private boolean applyConditions = true;
	@Required
	private boolean activeApplyConditions = true;
	@Required
	private boolean moveElements = true;
	@Required
	private boolean hideStats = true;
	@Required
	private boolean randomStandees = false;
	@Required
	private boolean activeStandees = true;
	@Required
	private boolean allyAttackModifierDeck = true;
	@Required
	private boolean initiativeRequired = true;
	@Required
	private boolean disableStandees = false;
	@Required
	private boolean abilityReveal = true;
	@Required
	private boolean applyLoot = true;
	@Required
	private boolean alwaysLootApplyDialog = false;
	@Required
	private boolean alwaysLootDeck = false;
	@Required
	private boolean fullscreen = false;
	@Required
	private boolean fhStyle = false;
	@Required
	private String theme = "default";
	@Required
	private boolean autoscroll = true;
	@Required
	private boolean scenarioRules = true;
	@Required
	private boolean scenarioRooms = true;
	@Required
	private boolean automaticStandees = true;
	@Required
	private boolean scenarioNumberInput = false;
	@Required
	private boolean disableColumns = false;
	@Required
	private boolean dragValues = true;
	@Required
	private boolean hideAbsent = false;
	@Required
	private boolean hints = true;
	@Required
	private int zoom = 100;
	@Required
	private boolean automaticAttackModifierFullscreen = true;
	@Required
	private int barsize = 1;
	@Required
	private int fontsize = 1;
	@Required
	private String locale = "en";
	@Required
	private LinkedList<String> editions = new LinkedList<>();
	@Required
	private LinkedList<String> editionDataUrls = new LinkedList<>();
	@Required
	private LinkedList<String> excludeEditionDataUrls = new LinkedList<>();
	@Required
	private LinkedList<String> spoilers = new LinkedList<>();
	private boolean browserNavigation = false;
	private String serverUrl;
	private int serverPort;
	private String serverPassword;
	private boolean serverAutoconnect = true;
	private boolean serverSettings = false;
	private boolean serverWss = false;
	private int maxUndo = 50;

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
	 * Checks if is fullscreen.
	 *
	 * @return true, if is fullscreen
	 */
	public boolean isFullscreen() {
		return fullscreen;
	}

	/**
	 * Sets the fullscreen.
	 *
	 * @param fullscreen the new fullscreen
	 */
	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	/**
	 * Checks if is fh style.
	 *
	 * @return true, if is fh style
	 */
	public boolean isFhStyle() {
		return fhStyle;
	}

	/**
	 * Sets the fh style.
	 *
	 * @param fhStyle the new fh style
	 */
	public void setFhStyle(boolean fhStyle) {
		this.fhStyle = fhStyle;
	}

	/**
	 * Gets the theme.
	 *
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * Sets the theme.
	 *
	 * @param theme the new theme
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * Checks if is autoscroll.
	 *
	 * @return true, if is autoscroll
	 */
	public boolean isAutoscroll() {
		return autoscroll;
	}

	/**
	 * Sets the autoscroll.
	 *
	 * @param autoscroll the new autoscroll
	 */
	public void setAutoscroll(boolean autoscroll) {
		this.autoscroll = autoscroll;
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
	 * Checks if is disable columns.
	 *
	 * @return true, if is disable columns
	 */
	public boolean isDisableColumns() {
		return disableColumns;
	}

	/**
	 * Sets the disable columns.
	 *
	 * @param disableColumns the new disable columns
	 */
	public void setDisableColumns(boolean disableColumns) {
		this.disableColumns = disableColumns;
	}

	/**
	 * Checks if is drag values.
	 *
	 * @return true, if is drag values
	 */
	public boolean isDragValues() {
		return dragValues;
	}

	/**
	 * Sets the drag values.
	 *
	 * @param dragValues the new drag values
	 */
	public void setDragValues(boolean dragValues) {
		this.dragValues = dragValues;
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
	 * Gets the zoom.
	 *
	 * @return the zoom
	 */
	public int getZoom() {
		return zoom;
	}

	/**
	 * Sets the zoom.
	 *
	 * @param zoom the new zoom
	 */
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	/**
	 * Checks if is automatic attack modifier fullscreen.
	 *
	 * @return true, if is automatic attack modifier fullscreen
	 */
	public boolean isAutomaticAttackModifierFullscreen() {
		return automaticAttackModifierFullscreen;
	}

	/**
	 * Sets the automatic attack modifier fullscreen.
	 *
	 * @param automaticAttackModifierFullscreen the new automatic attack modifier
	 *                                          fullscreen
	 */
	public void setAutomaticAttackModifierFullscreen(boolean automaticAttackModifierFullscreen) {
		this.automaticAttackModifierFullscreen = automaticAttackModifierFullscreen;
	}

	/**
	 * Gets the barsize.
	 *
	 * @return the barsize
	 */
	public int getBarsize() {
		return barsize;
	}

	/**
	 * Sets the barsize.
	 *
	 * @param barsize the new barsize
	 */
	public void setBarsize(int barsize) {
		this.barsize = barsize;
	}

	/**
	 * Gets the fontsize.
	 *
	 * @return the fontsize
	 */
	public int getFontsize() {
		return fontsize;
	}

	/**
	 * Sets the fontsize.
	 *
	 * @param fontsize the new fontsize
	 */
	public void setFontsize(int fontsize) {
		this.fontsize = fontsize;
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
	 * Checks if is browser navigation.
	 *
	 * @return true, if is browser navigation
	 */
	public boolean isBrowserNavigation() {
		return browserNavigation;
	}

	/**
	 * Sets the browser navigation.
	 *
	 * @param browserNavigation the new browser navigation
	 */
	public void setBrowserNavigation(boolean browserNavigation) {
		this.browserNavigation = browserNavigation;
	}

	/**
	 * Gets the server url.
	 *
	 * @return the server url
	 */
	public String getServerUrl() {
		return serverUrl;
	}

	/**
	 * Sets the server url.
	 *
	 * @param serverUrl the new server url
	 */
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	/**
	 * Gets the server port.
	 *
	 * @return the server port
	 */
	public int getServerPort() {
		return serverPort;
	}

	/**
	 * Sets the server port.
	 *
	 * @param serverPort the new server port
	 */
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	/**
	 * Gets the server password.
	 *
	 * @return the server password
	 */
	public String getServerPassword() {
		return serverPassword;
	}

	/**
	 * Sets the server password.
	 *
	 * @param serverPassword the new server password
	 */
	public void setServerPassword(String serverPassword) {
		this.serverPassword = serverPassword;
	}

	/**
	 * Checks if is server autoconnect.
	 *
	 * @return true, if is server autoconnect
	 */
	public boolean isServerAutoconnect() {
		return serverAutoconnect;
	}

	/**
	 * Sets the server autoconnect.
	 *
	 * @param serverAutoconnect the new server autoconnect
	 */
	public void setServerAutoconnect(boolean serverAutoconnect) {
		this.serverAutoconnect = serverAutoconnect;
	}

	/**
	 * Checks if is server settings.
	 *
	 * @return true, if is server settings
	 */
	public boolean isServerSettings() {
		return serverSettings;
	}

	/**
	 * Sets the server settings.
	 *
	 * @param serverSettings the new server settings
	 */
	public void setServerSettings(boolean serverSettings) {
		this.serverSettings = serverSettings;
	}

	/**
	 * Checks if is server wss.
	 *
	 * @return true, if is server wss
	 */
	public boolean isServerWss() {
		return serverWss;
	}

	/**
	 * Sets the server wss.
	 *
	 * @param serverWss the new server wss
	 */
	public void setServerWss(boolean serverWss) {
		this.serverWss = serverWss;
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

}
