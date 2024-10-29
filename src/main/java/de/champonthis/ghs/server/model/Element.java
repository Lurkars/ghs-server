package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

public enum Element {

	@SerializedName("wild")
	WILD,

	@SerializedName("fire")
	FIRE,

	@SerializedName("ice")
	ICE,

	@SerializedName("air")
	AIR,

	@SerializedName("earth")
	EARTH,

	@SerializedName("light")
	LIGHT,

	@SerializedName("dark")
	DARK
}
