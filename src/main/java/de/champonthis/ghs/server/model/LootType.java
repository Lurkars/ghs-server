/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum LootType.
 */
public enum LootType {

	@SerializedName("money")
	MONEY,

	@SerializedName("lumber")
	LUMBER,

	@SerializedName("metal")
	METAL,

	@SerializedName("hide")
	HIDE,

	@SerializedName("arrowvine")
	ARROWVINE,

	@SerializedName("axenut")
	AXENUT,

	@SerializedName("corpsecap")
	CORPSECAP,

	@SerializedName("flamefruit")
	FLAMEFRUIT,

	@SerializedName("rockroot")
	ROCKROOT,

	@SerializedName("snowthistle")
	SNOWTHISTLE,

	@SerializedName("random_item")
	RANDOM_ITEM,

	@SerializedName("special1")
	SPECIAL1,

	@SerializedName("special2")
	SPECIAL2
}
