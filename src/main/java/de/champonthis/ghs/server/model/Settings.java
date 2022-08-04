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
	private boolean eliteFirst = true;
	@Required
	private boolean expireConditions = true;
	@Required
	private boolean applyConditions = true;
	@Required
	private boolean moveElements = true;
	@Required
	private boolean hideStats = true;
	@Required
	private boolean randomStandees = false;
	@Required
	private boolean initiativeRequired = true;
	@Required
	private boolean fullscreen = false;
	@Required
	private boolean disableColumns = false;
	@Required
	private boolean hints = true;
	@Required
	private int zoom = 100;
	@Required
	private String locale = "en";
	@Required
	private LinkedList<String> editionDataUrls = new LinkedList<String>();
	@Required
	private LinkedList<String> excludeEditionDataUrls = new LinkedList<String>();
	@Required
	private LinkedList<String> spoilers = new LinkedList<String>();
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
