/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class CharacterProgress.
 */
public class CharacterProgress {

	private int experience = 0;
	private int gold = 0;
	@Required
	private Map<LootType, Integer> loot = new HashMap<LootType, Integer>();
	@Required
	private LinkedList<Identifier> items = new LinkedList<Identifier>();
	private int personalQuest = 0;
	private int battleGoals = 0;
	private String notes = "";
	private boolean retired = false;
	private int retirements = 0;
	@Required
	private LinkedList<Integer> perks = new LinkedList<Integer>();
	@Required
	private LinkedList<Integer> masteries = new LinkedList<Integer>();
	private int donations = 0;

	/**
	 * Gets the experience.
	 *
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Sets the experience.
	 *
	 * @param experience the new experience
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Gets the gold.
	 *
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Sets the gold.
	 *
	 * @param gold the new gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * Gets the loot.
	 *
	 * @return the loot
	 */
	public Map<LootType, Integer> getLoot() {
		return loot;
	}

	/**
	 * Sets the loot.
	 *
	 * @param loot the loot
	 */
	public void setLoot(Map<LootType, Integer> loot) {
		this.loot = loot;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public LinkedList<Identifier> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public void setItems(LinkedList<Identifier> items) {
		this.items = items;
	}

	/**
	 * Gets the personal quest.
	 *
	 * @return the personal quest
	 */
	public int getPersonalQuest() {
		return personalQuest;
	}

	/**
	 * Sets the personal quest.
	 *
	 * @param personalQuest the new personal quest
	 */
	public void setPersonalQuest(int personalQuest) {
		this.personalQuest = personalQuest;
	}

	/**
	 * Gets the battle goals.
	 *
	 * @return the battle goals
	 */
	public int getBattleGoals() {
		return battleGoals;
	}

	/**
	 * Sets the battle goals.
	 *
	 * @param battleGoals the new battle goals
	 */
	public void setBattleGoals(int battleGoals) {
		this.battleGoals = battleGoals;
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
	 * Checks if is retired.
	 *
	 * @return true, if is retired
	 */
	public boolean isRetired() {
		return retired;
	}

	/**
	 * Sets the retired.
	 *
	 * @param retired the new retired
	 */
	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	/**
	 * Gets the retirements.
	 *
	 * @return the retirements
	 */
	public int getRetirements() {
		return retirements;
	}

	/**
	 * Sets the retirements.
	 *
	 * @param retirements the new retirements
	 */
	public void setRetirements(int retirements) {
		this.retirements = retirements;
	}

	/**
	 * Gets the perks.
	 *
	 * @return the perks
	 */
	public LinkedList<Integer> getPerks() {
		return perks;
	}

	/**
	 * Sets the perks.
	 *
	 * @param perks the new perks
	 */
	public void setPerks(LinkedList<Integer> perks) {
		this.perks = perks;
	}

	/**
	 * Gets the masteries.
	 *
	 * @return the masteries
	 */
	public LinkedList<Integer> getMasteries() {
		return masteries;
	}

	/**
	 * Sets the masteries.
	 *
	 * @param masteries the new masteries
	 */
	public void setMasteries(LinkedList<Integer> masteries) {
		this.masteries = masteries;
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

}
