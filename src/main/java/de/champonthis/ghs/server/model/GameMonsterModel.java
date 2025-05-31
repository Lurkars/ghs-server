package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
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
}
