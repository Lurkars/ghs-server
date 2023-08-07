/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameObjectiveModel.
 */
public class GameObjectiveModel {

	@Required
	private String uuid = "";
	@Required
	private int id;
	private String marker;
	private String title;
	@Required
	private String name;
	private Boolean escort;
	private Integer level;
	private Boolean exhausted;
	private Boolean off;
	private Boolean active;
	@Required
	private int health;
	@Required
	private String maxHealth;
	@Required
	private LinkedList<GameEntityConditionModel> entityConditions = new LinkedList<>();
	private LinkedList<ConditionName> immunities = new LinkedList<>();
	@Required
	private LinkedList<String> markers = new LinkedList<>();
	@Required
	private LinkedList<String> tags = new LinkedList<>();
	private Integer initiative;
	private ScenarioObjectiveIdentifier objectiveId;

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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Gets the escort.
	 *
	 * @return the escort
	 */
	public Boolean getEscort() {
		return escort;
	}

	/**
	 * Sets the escort.
	 *
	 * @param escort the new escort
	 */
	public void setEscort(Boolean escort) {
		this.escort = escort;
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
	 * Gets the exhausted.
	 *
	 * @return the exhausted
	 */
	public Boolean getExhausted() {
		return exhausted;
	}

	/**
	 * Sets the exhausted.
	 *
	 * @param exhausted the new exhausted
	 */
	public void setExhausted(Boolean exhausted) {
		this.exhausted = exhausted;
	}

	/**
	 * Gets the off.
	 *
	 * @return the off
	 */
	public Boolean getOff() {
		return off;
	}

	/**
	 * Sets the off.
	 *
	 * @param off the new off
	 */
	public void setOff(Boolean off) {
		this.off = off;
	}

	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(Boolean active) {
		this.active = active;
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
	public String getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Sets the max health.
	 *
	 * @param maxHealth the new max health
	 */
	public void setMaxHealth(String maxHealth) {
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
	 * Gets the initiative.
	 *
	 * @return the initiative
	 */
	public Integer getInitiative() {
		return initiative;
	}

	/**
	 * Sets the initiative.
	 *
	 * @param initiative the new initiative
	 */
	public void setInitiative(Integer initiative) {
		this.initiative = initiative;
	}

	/**
	 * Gets the objective id.
	 *
	 * @return the objective id
	 */
	public ScenarioObjectiveIdentifier getObjectiveId() {
		return objectiveId;
	}

	/**
	 * Sets the objective id.
	 *
	 * @param objectiveId the new objective id
	 */
	public void setObjectiveId(ScenarioObjectiveIdentifier objectiveId) {
		this.objectiveId = objectiveId;
	}

}
