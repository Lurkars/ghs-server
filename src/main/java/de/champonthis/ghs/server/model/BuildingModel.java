package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

public class BuildingModel {

	@Required
	private String name;
	@Required
	private int level;
	@Required
	private String state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
