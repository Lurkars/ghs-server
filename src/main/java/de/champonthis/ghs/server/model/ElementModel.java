/**
 * 
 */
package de.champonthis.ghs.server.model;

/**
 * The Class ElementModel.
 */
public class ElementModel {

	private Element type;
	private ElementState state;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Element getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Element type) {
		this.type = type;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public ElementState getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(ElementState state) {
		this.state = state;
	}

}
