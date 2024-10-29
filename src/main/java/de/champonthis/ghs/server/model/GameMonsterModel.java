package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class GameMonsterModel {

	@Required
	private String name;
	@Required
	private String edition;
	@Required
	private int level = 1;
	@Required
	private boolean off = false;
	@Required
	private boolean active = false;
	@Required
	private boolean drawExtra = false;
	@Required
	private int lastDraw = -1;
	@Required
	private int ability = -1;
	@Required
	private LinkedList<Integer> abilities = new LinkedList<>();
	@Required
	private LinkedList<GameMonsterEntityModel> entities = new LinkedList<>();
	@Required
	private boolean isAlly = false;
	@Required
	private boolean isAllied = false;
	@Required
	private LinkedList<String> tags = new LinkedList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean getOff() {
		return off;
	}

	public void setOff(boolean off) {
		this.off = off;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDrawExtra() {
		return drawExtra;
	}

	public void setDrawExtra(boolean drawExtra) {
		this.drawExtra = drawExtra;
	}

	public int getLastDraw() {
		return lastDraw;
	}

	public void setLastDraw(int lastDraw) {
		this.lastDraw = lastDraw;
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public LinkedList<Integer> getAbilities() {
		return abilities;
	}

	public void setAbilities(LinkedList<Integer> abilities) {
		this.abilities = abilities;
	}

	public LinkedList<GameMonsterEntityModel> getEntities() {
		return entities;
	}

	public void setEntities(LinkedList<GameMonsterEntityModel> entities) {
		this.entities = entities;
	}

	public boolean isAlly() {
		return isAlly;
	}

	public void setAlly(boolean isAlly) {
		this.isAlly = isAlly;
	}

	public boolean isAllied() {
		return isAllied;
	}

	public void setAllied(boolean isAllied) {
		this.isAllied = isAllied;
	}

	public LinkedList<String> getTags() {
		return tags;
	}

	public void setTags(LinkedList<String> tags) {
		this.tags = tags;
	}
}
