package de.champonthis.ghs.server.model;

import lombok.Data;

@Data
public class EntityCounter {

	private AdditionalIdentifier identifier;
	private int total;
	private int killed;

}
