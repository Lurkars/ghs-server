package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;
import lombok.Data;

@Data
public class Sound {

	@Required
	private String id;
	private String src;

}
