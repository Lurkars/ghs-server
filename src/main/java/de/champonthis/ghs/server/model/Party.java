/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class Party.
 */
public class Party {

	private int id = 0;
	private String name;
	private String edition;
	private String location;
	private String notes;
	private String achievements;
	private int reputation = 0;
	private int prosperity = 0;
	@Required
	private LinkedList<GameScenarioModel> scenarios = new LinkedList<GameScenarioModel>();
	@Required
	private LinkedList<GameScenarioModel> manualScenarios = new LinkedList<GameScenarioModel>();
	private boolean campaignMode = false;
	private String globalAchievements;
	private int donations = 0;
	@Required
	private LinkedList<GameCharacterModel> characters = new LinkedList<GameCharacterModel>();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the edition.
	 *
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the edition.
	 *
	 * @param edition the new edition
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Gets the achievements.
	 *
	 * @return the achievements
	 */
	public String getAchievements() {
		return achievements;
	}

	/**
	 * Sets the achievements.
	 *
	 * @param achievements the new achievements
	 */
	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	/**
	 * Gets the reputation.
	 *
	 * @return the reputation
	 */
	public int getReputation() {
		return reputation;
	}

	/**
	 * Sets the reputation.
	 *
	 * @param reputation the new reputation
	 */
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	/**
	 * Gets the prosperity.
	 *
	 * @return the prosperity
	 */
	public int getProsperity() {
		return prosperity;
	}

	/**
	 * Sets the prosperity.
	 *
	 * @param prosperity the new prosperity
	 */
	public void setProsperity(int prosperity) {
		this.prosperity = prosperity;
	}

	/**
	 * Gets the scenarios.
	 *
	 * @return the scenarios
	 */
	public LinkedList<GameScenarioModel> getScenarios() {
		return scenarios;
	}

	/**
	 * Sets the scenarios.
	 *
	 * @param scenarios the new scenarios
	 */
	public void setScenarios(LinkedList<GameScenarioModel> scenarios) {
		this.scenarios = scenarios;
	}

	/**
	 * Gets the manual scenarios.
	 *
	 * @return the manual scenarios
	 */
	public LinkedList<GameScenarioModel> getManualScenarios() {
		return manualScenarios;
	}

	/**
	 * Sets the manual scenarios.
	 *
	 * @param manualScenarios the new manual scenarios
	 */
	public void setManualScenarios(LinkedList<GameScenarioModel> manualScenarios) {
		this.manualScenarios = manualScenarios;
	}

	/**
	 * Checks if is campaign mode.
	 *
	 * @return true, if is campaign mode
	 */
	public boolean isCampaignMode() {
		return campaignMode;
	}

	/**
	 * Sets the campaign mode.
	 *
	 * @param campaignMode the new campaign mode
	 */
	public void setCampaignMode(boolean campaignMode) {
		this.campaignMode = campaignMode;
	}

	/**
	 * Gets the global achievements.
	 *
	 * @return the global achievements
	 */
	public String getGlobalAchievements() {
		return globalAchievements;
	}

	/**
	 * Sets the global achievements.
	 *
	 * @param globalAchievements the new global achievements
	 */
	public void setGlobalAchievements(String globalAchievements) {
		this.globalAchievements = globalAchievements;
	}

	/**
	 * Gets the donations.
	 *
	 * @return the donations
	 */
	public int getDonations() {
		return donations;
	}

	/**
	 * Sets the donations.
	 *
	 * @param donations the new donations
	 */
	public void setDonations(int donations) {
		this.donations = donations;
	}

	/**
	 * Gets the characters.
	 *
	 * @return the characters
	 */
	public LinkedList<GameCharacterModel> getCharacters() {
		return characters;
	}

	/**
	 * Sets the characters.
	 *
	 * @param characters the new characters
	 */
	public void setCharacters(LinkedList<GameCharacterModel> characters) {
		this.characters = characters;
	}

}
