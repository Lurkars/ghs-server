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
	BLESS,

	@SerializedName("regenerate")
	REGENERATE,

	@SerializedName("chill")
	CHILL,

	@SerializedName("infect")
	INFECT,

	@SerializedName("ward")
	WARD,

	@SerializedName("bane")
	BANE,

	@SerializedName("brittle")
	BRITTLE,

	@SerializedName("impair")
	IMPAIR,

	@SerializedName("poison_upgrade")
	POISON_UPGRADE,

	@SerializedName("wound_upgrade")
	WOUND_UPGRADE
}
