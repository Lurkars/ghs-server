package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

public enum RpgPowerState {

	@SerializedName("expended")
	EXPENDED,

	@SerializedName("lost")
	LOST
}
