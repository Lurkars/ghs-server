package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class Loot {

	@Required
	private LootType type;
	private Integer value4P;
	private Integer value3P;
	private Integer value2P;
	private String value;
	@Required
	private int enhancements = 0;
	private Integer cardId;

}
