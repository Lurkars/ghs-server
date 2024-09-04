/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameSummonModel.
 */
public class GameSummonModel {

	@Required
	private String uuid = "";
	@Required
	private String name;
	private String title;
	private String cardId;
	@Required
	private int number;
	@Required
	private SummonColor color;
	private String attack;
	private Integer movement;
	private Integer range;
	private Boolean flying;
	private Boolean dead;
	@Required
	private SummonState state;
	private Integer level;
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
	private String action;
	private String additionalAction;
	private boolean active = false;
	private boolean dormant = false;
	private boolean revealed = false;
	private String thumbnail;
	private String thumbnailUrl;
	private boolean noThumbnail = false;
	private String shield;
	private String shieldPersistent;
	@Required
	private LinkedList<String> retaliate = new LinkedList<>();
	@Required
	private LinkedList<String> retaliatePersistent = new LinkedList<>();

	/**
	 * Gets the uuid.
	 *
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets the uuid.
	 *
	 * @param uuid the new uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the card id.
	 *
	 * @return the card id
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * Sets the card id.
	 *
	 * @param cardId the new card id
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

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
	 * Gets the color.
	 *
	 * @return the color
	 */
	public SummonColor getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(SummonColor color) {
		this.color = color;
	}

	/**
	 * Gets the attack.
	 *
	 * @return the attack
	 */
	public String getAttack() {
		return attack;
	}

	/**
	 * Sets the attack.
	 *
	 * @param attack the new attack
	 */
	public void setAttack(String attack) {
		this.attack = attack;
	}

	/**
	 * Gets the movement.
	 *
	 * @return the movement
	 */
	public Integer getMovement() {
		return movement;
	}

	/**
	 * Sets the movement.
	 *
	 * @param movement the new movement
	 */
	public void setMovement(Integer movement) {
		this.movement = movement;
	}

	/**
	 * Gets the range.
	 *
	 * @return the range
	 */
	public Integer getRange() {
		return range;
	}

	/**
	 * Sets the range.
	 *
	 * @param range the new range
	 */
	public void setRange(Integer range) {
		this.range = range;
	}

	/**
	 * Gets the flying.
	 *
	 * @return the flying
	 */
	public Boolean getFlying() {
		return flying;
	}

	/**
	 * Sets the flying.
	 *
	 * @param flying the new flying
	 */
	public void setFlying(Boolean flying) {
		this.flying = flying;
	}

	/**
	 * Gets the dead.
	 *
	 * @return the dead
	 */
	public Boolean getDead() {
		return dead;
	}

	/**
	 * Sets the dead.
	 *
	 * @param dead the new dead
	 */
	public void setDead(Boolean dead) {
		this.dead = dead;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public SummonState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(SummonState state) {
		this.state = state;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(Integer level) {
		this.level = level;
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
	 * Gets the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Gets the additional action.
	 *
	 * @return the additional action
	 */
	public String getAdditionalAction() {
		return additionalAction;
	}

	/**
	 * Sets the additional action.
	 *
	 * @param additionalAction the new additional action
	 */
	public void setAdditionalAction(String additionalAction) {
		this.additionalAction = additionalAction;
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
	 * Gets the thumbnail.
	 *
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * Sets the thumbnail.
	 *
	 * @param thumbnail the new thumbnail
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * Gets the thumbnail url.
	 *
	 * @return the thumbnail url
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	/**
	 * Sets the thumbnail url.
	 *
	 * @param thumbnailUrl the new thumbnail url
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/**
	 * Checks if is no thumbnail.
	 *
	 * @return true, if is no thumbnail
	 */
	public boolean isNoThumbnail() {
		return noThumbnail;
	}

	/**
	 * Sets the no thumbnail.
	 *
	 * @param noThumbnail the new no thumbnail
	 */
	public void setNoThumbnail(boolean noThumbnail) {
		this.noThumbnail = noThumbnail;
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
