package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class Permissions {

	@Required
	private boolean characters = false;
	@Required
	private LinkedList<Identifier> character = new LinkedList<>();
	@Required
	private boolean monsters = false;
	@Required
	private LinkedList<Identifier> monster = new LinkedList<>();
	@Required
	private boolean scenario = false;
	@Required
	private boolean elements = false;
	@Required
	private boolean round = false;
	@Required
	private boolean level = false;
	@Required
	private boolean attackModifiers = false;
	@Required
	private boolean lootDeck = false;
	@Required
	private boolean party = false;

}
