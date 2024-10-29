package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

public enum GameState {

	@SerializedName("draw")
	DRAW,

	@SerializedName("next")
	NEXT
}
