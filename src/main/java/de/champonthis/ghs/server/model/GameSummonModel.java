package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
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

}
