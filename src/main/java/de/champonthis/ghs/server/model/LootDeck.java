package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class LootDeck {

	@Required
	private int current = -1;
	@Required
	private LinkedList<Loot> cards = new LinkedList<>();
	@Required
	private boolean active = false;

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public LinkedList<Loot> getCards() {
		return cards;
	}

	public void setCards(LinkedList<Loot> cards) {
		this.cards = cards;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
