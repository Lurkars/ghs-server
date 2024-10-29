package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public SummonColor getColor() {
		return color;
	}

	public void setColor(SummonColor color) {
		this.color = color;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public Integer getMovement() {
		return movement;
	}

	public void setMovement(Integer movement) {
		this.movement = movement;
	}

	public Integer getRange() {
		return range;
	}

	public void setRange(Integer range) {
		this.range = range;
	}

	public Boolean getFlying() {
		return flying;
	}

	public void setFlying(Boolean flying) {
		this.flying = flying;
	}

	public Boolean getDead() {
		return dead;
	}

	public void setDead(Boolean dead) {
		this.dead = dead;
	}

	public SummonState getState() {
		return state;
	}

	public void setState(SummonState state) {
		this.state = state;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAdditionalAction() {
		return additionalAction;
	}

	public void setAdditionalAction(String additionalAction) {
		this.additionalAction = additionalAction;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public boolean isNoThumbnail() {
		return noThumbnail;
	}

	public void setNoThumbnail(boolean noThumbnail) {
		this.noThumbnail = noThumbnail;
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
