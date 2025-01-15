package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class GameAttackModifierDeckModel {

	@Required
	private int current;
	@Required
	private LinkedList<String> cards = new LinkedList<>();
	@Required
	private LinkedList<Integer> discarded = new LinkedList<>();
	@Required
	private boolean active = true;
	private Integer lastVisible;
	private String state;
	private Boolean bb;
	// migration
	private LinkedList<Integer> disgarded = new LinkedList<>();

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public LinkedList<String> getCards() {
		return cards;
	}

	public void setCards(LinkedList<String> cards) {
		this.cards = cards;
	}

	public LinkedList<Integer> getDiscarded() {
		return discarded;
	}

	public void setDiscarded(LinkedList<Integer> discarded) {
		this.discarded = discarded;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getLastVisible() {
		return lastVisible;
	}

	public void setLastVisible(Integer lastVisible) {
		this.lastVisible = lastVisible;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getBb() {
		return bb;
	}

	public void setState(Boolean bb) {
		this.bb = bb;
	}

	public LinkedList<Integer> getDisgarded() {
		return disgarded;
	}

	public void setDisgarded(LinkedList<Integer> disgarded) {
		this.disgarded = disgarded;
	}

}
