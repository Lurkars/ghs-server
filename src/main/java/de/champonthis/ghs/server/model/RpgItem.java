package de.champonthis.ghs.server.model;

import lombok.Data;

@Data
public class RpgItem {

	private boolean equipped = false;
	private String slot = "";
	private String name = "";
	private String initiative = "";
	private String effect = "";
	private boolean spent = false;

}
