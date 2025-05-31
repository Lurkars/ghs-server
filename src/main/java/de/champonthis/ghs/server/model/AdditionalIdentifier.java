package de.champonthis.ghs.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdditionalIdentifier extends Identifier {

	private String type;
	private String marker;
	private LinkedList<String> tags = new LinkedList<>();

}
