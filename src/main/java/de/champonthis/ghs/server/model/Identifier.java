package de.champonthis.ghs.server.model;

import de.champonthis.ghs.server.util.Required;

public class Identifier {

	@Required
	private String name;
	@Required
	private String edition;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

}
