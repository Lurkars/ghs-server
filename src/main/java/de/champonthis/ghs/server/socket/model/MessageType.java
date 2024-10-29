package de.champonthis.ghs.server.socket.model;

import com.google.gson.annotations.SerializedName;

public enum MessageType {

	@SerializedName("game")
	GAME,

	@SerializedName("game-undo")
	GAME_UNDO,

	@SerializedName("game-redo")
	GAME_REDO,

	@SerializedName("game-update")
	GAME_UPDATE,

	@SerializedName("permissions")
	PERMISSIONS,

	@SerializedName("request-game")
	REQUEST_GAME,

	@SerializedName("settings")
	SETTINGS,

	@SerializedName("request-settings")
	REQUEST_SETTINGS,

	@SerializedName("error")
	ERROR,

	@SerializedName("ping")
	PING,

}
