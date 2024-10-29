package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;

public class GameObjectiveContainerModel {

	@Required
	private String uuid = "";
	private String marker;
	private String title;
	@Required
	private String name;
	private Boolean escort;
	private LinkedList<GameObjectiveEntityModel> entities = new LinkedList<>();
	private Integer level;
	private Boolean off;
	private Boolean active;
	@Required
	private int health;
	private Integer initiative;
	private ScenarioObjectiveIdentifier objectiveId;
	private AdditionalIdentifier additionalObjectiveId;
	private String amDeck;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEscort() {
		return escort;
	}

	public void setEscort(Boolean escort) {
		this.escort = escort;
	}

	public LinkedList<GameObjectiveEntityModel> getEntities() {
		return entities;
	}

	public void setEntities(LinkedList<GameObjectiveEntityModel> entities) {
		this.entities = entities;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getOff() {
		return off;
	}

	public void setOff(Boolean off) {
		this.off = off;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Integer getInitiative() {
		return initiative;
	}

	public void setInitiative(Integer initiative) {
		this.initiative = initiative;
	}

	public ScenarioObjectiveIdentifier getObjectiveId() {
		return objectiveId;
	}

	public void setObjectiveId(ScenarioObjectiveIdentifier objectiveId) {
		this.objectiveId = objectiveId;
	}

	public AdditionalIdentifier getAdditionalObjectiveId() {
		return additionalObjectiveId;
	}

	public void setAdditionalObjectiveId(AdditionalIdentifier additionalObjectiveId) {
		this.additionalObjectiveId = additionalObjectiveId;
	}

	public String getAmDeck() {
		return amDeck;
	}

	public void setAmDeck(String amDeck) {
		this.amDeck = amDeck;
	}

}
