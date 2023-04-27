/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class ScenarioFinish.
 */
public class ScenarioFinish {

	private GameScenarioModel conclusion;
	private boolean success = false;
	@Required
	private LinkedList<Integer> battleGoals = new LinkedList<>();
	@Required
	private LinkedList<Integer> collectiveGold = new LinkedList<>();
	@Required
	private LinkedList<LinkedList<Integer>> items = new LinkedList<>();
	private String chooseLocation;
	private String chooseUnlockCharacter;
	private int challenges;

	/**
	 * Gets the conclusion.
	 *
	 * @return the conclusion
	 */
	public GameScenarioModel getConclusion() {
		return conclusion;
	}

	/**
	 * Sets the conclusion.
	 *
	 * @param conclusion the new conclusion
	 */
	public void setConclusion(GameScenarioModel conclusion) {
		this.conclusion = conclusion;
	}

	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets the success.
	 *
	 * @param success the new success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Gets the battle goals.
	 *
	 * @return the battle goals
	 */
	public LinkedList<Integer> getBattleGoals() {
		return battleGoals;
	}

	/**
	 * Sets the battle goals.
	 *
	 * @param battleGoals the new battle goals
	 */
	public void setBattleGoals(LinkedList<Integer> battleGoals) {
		this.battleGoals = battleGoals;
	}

	/**
	 * Gets the collective gold.
	 *
	 * @return the collective gold
	 */
	public LinkedList<Integer> getCollectiveGold() {
		return collectiveGold;
	}

	/**
	 * Sets the collective gold.
	 *
	 * @param collectiveGold the new collective gold
	 */
	public void setCollectiveGold(LinkedList<Integer> collectiveGold) {
		this.collectiveGold = collectiveGold;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public LinkedList<LinkedList<Integer>> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public void setItems(LinkedList<LinkedList<Integer>> items) {
		this.items = items;
	}

	/**
	 * Gets the choose location.
	 *
	 * @return the choose location
	 */
	public String getChooseLocation() {
		return chooseLocation;
	}

	/**
	 * Sets the choose location.
	 *
	 * @param chooseLocation the new choose location
	 */
	public void setChooseLocation(String chooseLocation) {
		this.chooseLocation = chooseLocation;
	}

	/**
	 * Gets the choose unlock character.
	 *
	 * @return the choose unlock character
	 */
	public String getChooseUnlockCharacter() {
		return chooseUnlockCharacter;
	}

	/**
	 * Sets the choose unlock character.
	 *
	 * @param chooseUnlockCharacter the new choose unlock character
	 */
	public void setChooseUnlockCharacter(String chooseUnlockCharacter) {
		this.chooseUnlockCharacter = chooseUnlockCharacter;
	}

	/**
	 * Gets the challenges.
	 *
	 * @return the challenges
	 */
	public int getChallenges() {
		return challenges;
	}

	/**
	 * Sets the challenges.
	 *
	 * @param challenges the new challenges
	 */
	public void setChallenges(int challenges) {
		this.challenges = challenges;
	}

}
