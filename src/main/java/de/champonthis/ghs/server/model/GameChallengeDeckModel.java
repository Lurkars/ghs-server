/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameChallengeDeckModel.
 */
public class GameChallengeDeckModel {

	@Required
	private int current;
	@Required
	private int finished;
	@Required
	private LinkedList<Integer> keep = new LinkedList<>();
	@Required
	private LinkedList<Identifier> cards = new LinkedList<>();
	@Required
	private boolean active = false;

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getFinished() {
		return finished;
	}

	public void setFinished(int finished) {
		this.finished = finished;
	}

	public LinkedList<Integer> getKeep() {
		return keep;
	}

	public void setKeep(LinkedList<Integer> keep) {
		this.keep = keep;
	}

	public LinkedList<Identifier> getCards() {
		return cards;
	}

	public void setCards(LinkedList<Identifier> cards) {
		this.cards = cards;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
