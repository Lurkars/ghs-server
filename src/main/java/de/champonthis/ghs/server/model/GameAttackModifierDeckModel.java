/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameAttackModifierDeckModel.
 */
public class GameAttackModifierDeckModel {

	@Required
	private int current;
	@Required
	private LinkedList<String> cards = new LinkedList<>();
	@Required
	private LinkedList<Integer> disgarded = new LinkedList<>();
	@Required
	private boolean active = true;

	/**
	 * Gets the current.
	 *
	 * @return the current
	 */
	public int getCurrent() {
		return current;
	}

	/**
	 * Sets the current.
	 *
	 * @param current the new current
	 */
	public void setCurrent(int current) {
		this.current = current;
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	public LinkedList<String> getCards() {
		return cards;
	}

	/**
	 * Sets the cards.
	 *
	 * @param cards the new cards
	 */
	public void setCards(LinkedList<String> cards) {
		this.cards = cards;
	}

	/**
	 * Gets the disgarded.
	 *
	 * @return the disgarded
	 */
	public LinkedList<Integer> getDisgarded() {
		return disgarded;
	}

	/**
	 * Sets the disgarded.
	 *
	 * @param disgarded the new disgarded
	 */
	public void setDisgarded(LinkedList<Integer> disgarded) {
		this.disgarded = disgarded;
	}

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}
