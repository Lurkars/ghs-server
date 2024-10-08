/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameMonsterEntityModel.
 */
public class GameMonsterEntityModel {

	@Required
	private int number;
	private String marker;
	@Required
	private MonsterType type;
	@Required
	private boolean dead;
	@Required
	private SummonState summon;
	@Required
	private boolean revealed = false;
	@Required
	private boolean active = false;
	private boolean dormant = false;
	@Required
	private boolean off = false;
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

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Gets the marker.
	 *
	 * @return the marker
	 */
	public String getMarker() {
		return marker;
	}

	/**
	 * Sets the marker.
	 *
	 * @param marker the new marker
	 */
	public void setMarker(String marker) {
		this.marker = marker;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public MonsterType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(MonsterType type) {
		this.type = type;
	}

	/**
	 * Checks if is dead.
	 *
	 * @return true, if is dead
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * Sets the dead.
	 *
	 * @param dead the new dead
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}

	/**
	 * Gets the summon.
	 *
	 * @return the summon
	 */
	public SummonState getSummon() {
		return summon;
	}

	/**
	 * Sets the summon.
	 *
	 * @param summon the new summon
	 */
	public void setSummon(SummonState summon) {
		this.summon = summon;
	}

	/**
	 * Checks if is revealed.
	 *
	 * @return true, if is revealed
	 */
	public boolean isRevealed() {
		return revealed;
	}

	/**
	 * Sets the revealed.
	 *
	 * @param revealed the new revealed
	 */
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
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

	/**
	 * Checks if is dormant.
	 *
	 * @return true, if is dormant
	 */
	public boolean isDormant() {
		return dormant;
	}

	/**
	 * Sets the dormant.
	 *
	 * @param dormant the new dormant
	 */
	public void setDormant(boolean dormant) {
		this.dormant = dormant;
	}

	/**
	 * Checks if is off.
	 *
	 * @return true, if is off
	 */
	public boolean isOff() {
		return off;
	}

	/**
	 * Sets the off.
	 *
	 * @param off the new off
	 */
	public void setOff(boolean off) {
		this.off = off;
	}

	/**
	 * Gets the health.
	 *
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the health.
	 *
	 * @param health the new health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets the max health.
	 *
	 * @return the max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Sets the max health.
	 *
	 * @param maxHealth the new max health
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * Gets the entity conditions.
	 *
	 * @return the entity conditions
	 */
	public LinkedList<GameEntityConditionModel> getEntityConditions() {
		return entityConditions;
	}

	/**
	 * Sets the entity conditions.
	 *
	 * @param entityConditions the new entity conditions
	 */
	public void setEntityConditions(LinkedList<GameEntityConditionModel> entityConditions) {
		this.entityConditions = entityConditions;
	}

	/**
	 * Gets the immunities.
	 *
	 * @return the immunities
	 */
	public LinkedList<ConditionName> getImmunities() {
		return immunities;
	}

	/**
	 * Sets the immunities.
	 *
	 * @param immunities the new immunities
	 */
	public void setImmunities(LinkedList<ConditionName> immunities) {
		this.immunities = immunities;
	}

	/**
	 * Gets the markers.
	 *
	 * @return the markers
	 */
	public LinkedList<String> getMarkers() {
		return markers;
	}

	/**
	 * Sets the markers.
	 *
	 * @param markers the new markers
	 */
	public void setMarkers(LinkedList<String> markers) {
		this.markers = markers;
	}

	/**
	 * Gets the tags.
	 *
	 * @return the tags
	 */
	public LinkedList<String> getTags() {
		return tags;
	}

	/**
	 * Sets the tags.
	 *
	 * @param tags the new tags
	 */
	public void setTags(LinkedList<String> tags) {
		this.tags = tags;
	}

	/**
	 * Gets the shield.
	 *
	 * @return the shield
	 */
	public String getShield() {
		return shield;
	}

	/**
	 * Sets the shield.
	 *
	 * @param shield the new shield
	 */
	public void setShield(String shield) {
		this.shield = shield;
	}

	/**
	 * Gets the shield permanent.
	 *
	 * @return the shield permanent
	 */
	public String getShieldPersistent() {
		return shieldPersistent;
	}

	/**
	 * Sets the shield permanent.
	 *
	 * @param shieldPersistent the new shield permanent
	 */
	public void setShieldPersistent(String shieldPersistent) {
		this.shieldPersistent = shieldPersistent;
	}

	/**
	 * Gets the retaliate.
	 *
	 * @return the retaliate
	 */
	public LinkedList<String> getRetaliate() {
		return retaliate;
	}

	/**
	 * Sets the retaliate.
	 *
	 * @param retaliate the new retaliate
	 */
	public void setRetaliate(LinkedList<String> retaliate) {
		this.retaliate = retaliate;
	}

	/**
	 * Gets the retaliate permanent.
	 *
	 * @return the retaliate permanent
	 */
	public LinkedList<String> getRetaliatePersistent() {
		return retaliatePersistent;
	}

	/**
	 * Sets the retaliate permanent.
	 *
	 * @param retaliatePersistent the new retaliate permanent
	 */
	public void setRetaliatePersistent(LinkedList<String> retaliatePersistent) {
		this.retaliatePersistent = retaliatePersistent;
	}

}
