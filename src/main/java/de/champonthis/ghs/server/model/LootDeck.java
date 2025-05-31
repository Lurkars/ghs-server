package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class LootDeck {

	@Required
	private int current = -1;
	@Required
	private LinkedList<Loot> cards = new LinkedList<>();
	@Required
	private boolean active = false;

}
