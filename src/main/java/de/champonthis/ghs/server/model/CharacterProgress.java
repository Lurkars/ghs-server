package de.champonthis.ghs.server.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;

public class CharacterProgress {

	private int experience = 0;
	private int gold = 0;
	@Required
	private Map<LootType, Integer> loot = new HashMap<>();
	private String itemNotes = "";
	@Required
	private LinkedList<Identifier> items = new LinkedList<>();
	@Required
	private LinkedList<AdditionalIdentifier> equippedItems = new LinkedList<>();
	private String personalQuest = "";
	@Required
	private LinkedList<Integer> personalQuestProgress = new LinkedList<>();
	private int battleGoals = 0;
	private String notes = "";
	private boolean retired = false;
	private int retirements = 0;
	private int extraPerks = 0;
	@Required
	private LinkedList<Integer> perks = new LinkedList<>();
	@Required
	private LinkedList<Integer> masteries = new LinkedList<>();
	private int donations = 0;
	@Required
	private LinkedList<ScenarioStats> scenarioStats = new LinkedList<>();
	private Identifier trial;
	@Required
	private LinkedList<Integer> deck = new LinkedList<>();

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Map<LootType, Integer> getLoot() {
		return loot;
	}

	public void setLoot(Map<LootType, Integer> loot) {
		this.loot = loot;
	}

	public String getItemNotes() {
		return itemNotes;
	}

	public void setItemNotes(String itemNotes) {
		this.itemNotes = itemNotes;
	}

	public LinkedList<Identifier> getItems() {
		return items;
	}

	public void setItems(LinkedList<Identifier> items) {
		this.items = items;
	}

	public LinkedList<AdditionalIdentifier> getEquippedItems() {
		return equippedItems;
	}

	public void setEquippedItems(LinkedList<AdditionalIdentifier> equippedItems) {
		this.equippedItems = equippedItems;
	}

	public String getPersonalQuest() {
		return personalQuest;
	}

	public void setPersonalQuest(String personalQuest) {
		this.personalQuest = personalQuest;
	}

	public LinkedList<Integer> getPersonalQuestProgress() {
		return personalQuestProgress;
	}

	public void setPersonalQuestProgress(LinkedList<Integer> personalQuestProgress) {
		this.personalQuestProgress = personalQuestProgress;
	}

	public int getBattleGoals() {
		return battleGoals;
	}

	public void setBattleGoals(int battleGoals) {
		this.battleGoals = battleGoals;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public int getRetirements() {
		return retirements;
	}

	public void setRetirements(int retirements) {
		this.retirements = retirements;
	}

	public int getExtraPerks() {
		return extraPerks;
	}

	public void setExtraPerks(int extraPerks) {
		this.extraPerks = extraPerks;
	}

	public LinkedList<Integer> getPerks() {
		return perks;
	}

	public void setPerks(LinkedList<Integer> perks) {
		this.perks = perks;
	}

	public LinkedList<Integer> getMasteries() {
		return masteries;
	}

	public void setMasteries(LinkedList<Integer> masteries) {
		this.masteries = masteries;
	}

	public int getDonations() {
		return donations;
	}

	public void setDonations(int donations) {
		this.donations = donations;
	}

	public LinkedList<ScenarioStats> getScenarioStats() {
		return scenarioStats;
	}

	public void setScenarioStats(LinkedList<ScenarioStats> scenarioStats) {
		this.scenarioStats = scenarioStats;
	}

	public Identifier getTrial() {
		return trial;
	}

	public void setTrial(Identifier trial) {
		this.trial = trial;
	}

	public LinkedList<Integer> getDeck() {
		return deck;
	}

	public void setDeck(LinkedList<Integer> deck) {
		this.deck = deck;
	}
}
