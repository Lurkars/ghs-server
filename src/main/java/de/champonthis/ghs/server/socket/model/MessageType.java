/**
 * 
 */
package de.champonthis.ghs.server.socket.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum MessageType.
 */
public enum MessageType {

	@SerializedName("request")
	REQUEST,

	@SerializedName("game")
	GAME

}
