package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class Identifier {

	@Required
	private String name;
	@Required
	private String edition;

}
