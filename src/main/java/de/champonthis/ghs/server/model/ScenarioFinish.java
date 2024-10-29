package de.champonthis.ghs.server.model;

import java.util.LinkedList;
import java.util.Map;

import de.champonthis.ghs.server.util.Required;

public class ScenarioFinish {

	private GameScenarioModel conclusion;
	private boolean success = false;
	@Required
	private LinkedList<Integer> battleGoals = new LinkedList<>();
	@Required
	private LinkedList<Integer> collectiveGold = new LinkedList<>();
	@Required
	private LinkedList<Map<LootType, Integer>> collectiveResources = new LinkedList<>();
	@Required
	private LinkedList<LinkedList<Integer>> items = new LinkedList<>();
	private String chooseLocation;
	private String chooseUnlockCharacter;
	private int challenges;
	@Required
	private LinkedList<Integer> calenderSectionManual = new LinkedList<>();
	@Required
	private LinkedList<Integer> calendarSectionManual = new LinkedList<>();
	private Identifier randomItem;
	private Integer randomItemIndex = -1;
	private LinkedList<Identifier> randomItems = new LinkedList<>();
	@Required
	private LinkedList<Integer> randomItemBlueprints = new LinkedList<>();
	@Required
	private LinkedList<Boolean> trials = new LinkedList<>();

	public GameScenarioModel getConclusion() {
		return conclusion;
	}

	public void setConclusion(GameScenarioModel conclusion) {
		this.conclusion = conclusion;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public LinkedList<Integer> getBattleGoals() {
		return battleGoals;
	}

	public void setBattleGoals(LinkedList<Integer> battleGoals) {
		this.battleGoals = battleGoals;
	}

	public LinkedList<Integer> getCollectiveGold() {
		return collectiveGold;
	}

	public void setCollectiveGold(LinkedList<Integer> collectiveGold) {
		this.collectiveGold = collectiveGold;
	}

	public LinkedList<Map<LootType, Integer>> getCollectiveResources() {
		return collectiveResources;
	}

	public void setCollectiveResources(LinkedList<Map<LootType, Integer>> collectiveResources) {
		this.collectiveResources = collectiveResources;
	}

	public LinkedList<LinkedList<Integer>> getItems() {
		return items;
	}

	public void setItems(LinkedList<LinkedList<Integer>> items) {
		this.items = items;
	}

	public String getChooseLocation() {
		return chooseLocation;
	}

	public void setChooseLocation(String chooseLocation) {
		this.chooseLocation = chooseLocation;
	}

	public String getChooseUnlockCharacter() {
		return chooseUnlockCharacter;
	}

	public void setChooseUnlockCharacter(String chooseUnlockCharacter) {
		this.chooseUnlockCharacter = chooseUnlockCharacter;
	}

	public int getChallenges() {
		return challenges;
	}

	public void setChallenges(int challenges) {
		this.challenges = challenges;
	}

	public LinkedList<Integer> getCalenderSectionManual() {
		return calenderSectionManual;
	}

	public void setCalenderSectionManual(LinkedList<Integer> calenderSectionManual) {
		this.calenderSectionManual = calenderSectionManual;
	}

	public LinkedList<Integer> getCalendarSectionManual() {
		return calendarSectionManual;
	}

	public void setCalendarSectionManual(LinkedList<Integer> calendarSectionManual) {
		this.calendarSectionManual = calendarSectionManual;
	}

	public Identifier getRandomItem() {
		return randomItem;
	}

	public void setRandomItem(Identifier randomItem) {
		this.randomItem = randomItem;
	}

	public Integer getRandomItemIndex() {
		return randomItemIndex;
	}

	public void setRandomItemIndex(Integer randomItemIndex) {
		this.randomItemIndex = randomItemIndex;
	}

	public LinkedList<Identifier> getRandomItems() {
		return randomItems;
	}

	public void setRandomItems(LinkedList<Identifier> randomItems) {
		this.randomItems = randomItems;
	}

	public LinkedList<Integer> getRandomItemBlueprints() {
		return randomItemBlueprints;
	}

	public void setRandomItemBlueprints(LinkedList<Integer> randomItemBlueprints) {
		this.randomItemBlueprints = randomItemBlueprints;
	}

	public LinkedList<Boolean> getTrials() {
		return trials;
	}

	public void setTrials(LinkedList<Boolean> trials) {
		this.trials = trials;
	}

}
