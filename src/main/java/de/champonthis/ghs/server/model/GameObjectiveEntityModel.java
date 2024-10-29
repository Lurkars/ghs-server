package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class GameObjectiveEntityModel {

	@Required
	private String uuid = "";
	@Required
	private int number;
	private String marker;
	@Required
	private boolean dead;
	@Required
	private boolean active = false;
	private boolean dormant = false;
	@Required
	private boolean revealed = false;
	@Required
	private int health;
	@Required
	private int maxHealth;
	@Required
	private LinkedList<GameEntityConditionModel> entityConditions = new LinkedList<>();
	private LinkedList<ConditionName> immunities = new LinkedList<>();
	@Required
	private LinkedList<String> markers = new LinkedList<>();
	@Required
	private LinkedList<String> tags = new LinkedList<>();
	private String shield;
	private String shieldPersistent;
	@Required
	private LinkedList<String> retaliate = new LinkedList<>();
	@Required
	private LinkedList<String> retaliatePersistent = new LinkedList<>();

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDormant() {
		return dormant;
	}

	public void setDormant(boolean dormant) {
		this.dormant = dormant;
	}

	public boolean isRevealed() {
		return revealed;
	}

	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public LinkedList<GameEntityConditionModel> getEntityConditions() {
		return entityConditions;
	}

	public void setEntityConditions(LinkedList<GameEntityConditionModel> entityConditions) {
		this.entityConditions = entityConditions;
	}

	public LinkedList<ConditionName> getImmunities() {
		return immunities;
	}

	public void setImmunities(LinkedList<ConditionName> immunities) {
		this.immunities = immunities;
	}

	public LinkedList<String> getMarkers() {
		return markers;
	}

	public void setMarkers(LinkedList<String> markers) {
		this.markers = markers;
	}

	public LinkedList<String> getTags() {
		return tags;
	}

	public void setTags(LinkedList<String> tags) {
		this.tags = tags;
	}

	public String getShield() {
		return shield;
	}

	public void setShield(String shield) {
		this.shield = shield;
	}

	public String getShieldPersistent() {
		return shieldPersistent;
	}

	public void setShieldPersistent(String shieldPersistent) {
		this.shieldPersistent = shieldPersistent;
	}

	public LinkedList<String> getRetaliate() {
		return retaliate;
	}

	public void setRetaliate(LinkedList<String> retaliate) {
		this.retaliate = retaliate;
	}

	public LinkedList<String> getRetaliatePersistent() {
		return retaliatePersistent;
	}

	public void setRetaliatePersistent(LinkedList<String> retaliatePersistent) {
		this.retaliatePersistent = retaliatePersistent;
	}

}
