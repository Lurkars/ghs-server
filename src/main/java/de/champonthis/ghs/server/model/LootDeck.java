/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class LootDeck.
 */
public class LootDeck {

	@Required
	private int current = -1;
	@Required
	private LinkedList<Loot> cards = new LinkedList<Loot>();
	@Required
	private boolean active = false;

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
	public LinkedList<Loot> getCards() {
		return cards;
	}

	/**
	 * Sets the cards.
	 *
	 * @param cards the new cards
	 */
	public void setCards(LinkedList<Loot> cards) {
		this.cards = cards;
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
