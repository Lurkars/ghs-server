package de.champonthis.ghs.server.model;

import com.google.gson.JsonElement;

import lombok.Data;

@Data
public class OutpostAttackResource {

	private JsonElement effect;
	private boolean enabled = true;

}
