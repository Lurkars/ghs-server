/**
 * 
 */
package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

/**
 * The Class GameObjectiveContainerModel.
 */
public class GameObjectiveContainerModel {

	@Required
	private String uuid = "";
	private String marker;
	private String title;
	@Required
	private String name;
	private Boolean escort;
	private LinkedList<GameObjectiveEntityModel	> entities = new LinkedList<>();
	private Integer level;
	private Boolean off;
	private Boolean active;
	@Required
	private int health;
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
	 * Gets the entities.
	 *
	 * @return the entities
	 */
	public LinkedList<GameObjectiveEntityModel> getEntities() {
		return entities;
	}

	/**
	 * Sets the entities.
	 *
	 * @param entities the new entities
	 */
	public void setEntities(LinkedList<GameObjectiveEntityModel> entities) {
		this.entities = entities;
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
