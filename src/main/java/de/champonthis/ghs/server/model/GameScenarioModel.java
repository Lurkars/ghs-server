package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class GameScenarioModel {

	@Required
	private String index;
	@Required
	private String edition;
	private String group;
	private boolean isCustom = false;
	private String custom;
	@Required
	private LinkedList<Integer> revealedRooms = new LinkedList<>();

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public boolean isCustom() {
		return isCustom;
	}

	public void setCustom(boolean isCustom) {
		this.isCustom = isCustom;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public LinkedList<Integer> getRevealedRooms() {
		return revealedRooms;
	}

	public void setRevealedRooms(LinkedList<Integer> revealedRooms) {
		this.revealedRooms = revealedRooms;
	}

}
