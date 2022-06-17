/**
 * 
 */
package de.champonthis.ghs.server.model;

import com.google.gson.annotations.SerializedName;

/**
 * The Enum Condition.
 */
public enum Condition {
	@SerializedName("stun")
	STUN,

	@SerializedName("immobilize")
	IMMOBILIZE,

	@SerializedName("disarm")
	DISARM,

	@SerializedName("wound")
	WOUND,

	@SerializedName("muddle")
	MUDDLE,

	@SerializedName("poison")
	POISON,

	@SerializedName("invisible")
	INVISIBLE,

	@SerializedName("strengthen")
	STRENGTHEN,

	@SerializedName("curse")
	CURSE,

	@SerializedName("bless")
	BLESS
}
