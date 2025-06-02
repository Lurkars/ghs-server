package de.champonthis.ghs.server.model;

import java.util.LinkedList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdditionalIdentifier extends Identifier {

	private String type;
	private String marker;
	private LinkedList<String> tags = new LinkedList<>();

}
