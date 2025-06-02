package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
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

}
