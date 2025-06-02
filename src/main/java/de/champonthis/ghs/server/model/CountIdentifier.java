package de.champonthis.ghs.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CountIdentifier extends Identifier {

	private Integer count = -1;

}
