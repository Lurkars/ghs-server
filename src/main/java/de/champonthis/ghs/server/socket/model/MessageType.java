/**
 * 
 */
package de.champonthis.ghs.server.socket.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum MessageType.
 */
public enum MessageType {

	@SerializedName("game")
	GAME,

	@SerializedName("request-game")
	REQUEST_GAME,

	@SerializedName("settings")
	SETTINGS,

	@SerializedName("request-settings")
	REQUEST_SETTINGS,
	
	@SerializedName("error")
	ERROR,

}
