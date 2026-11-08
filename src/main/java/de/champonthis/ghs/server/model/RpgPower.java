package de.champonthis.ghs.server.model;

import lombok.Data;

@Data
public class RpgPower {

	private boolean gained = false;
	private boolean prepared = false;
	private String name = "";
	private String initiative = "";
	private String bonus = "";
	private String primary = "";
	private String secondary = "";
	private RpgPowerState state;

}
