package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

public enum ElementState {

	@SerializedName("strong")
	STRONG,

	@SerializedName("waning")
	WANING,

	@SerializedName("inert")
	INERT,

	@SerializedName("new")
	NEW,

	@SerializedName("consumed")
	CONSUMED,

	@SerializedName("partlyConsumed")
	PARTLY_CONSUMED,

	@SerializedName("always")
	ALWAYS
}
