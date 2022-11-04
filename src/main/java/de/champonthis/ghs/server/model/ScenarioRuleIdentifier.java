/**
 * 
 */
package de.champonthis.ghs.server.model;

/**
 * The Class ScenarioRuleIdentifier.
 */
public class ScenarioRuleIdentifier {

	private String edition;
	private String scenario;
	private String group;
	private int index;
	private boolean section;

	/**
	 * Gets the edition.
	 *
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * Sets the edition.
	 *
	 * @param edition the new edition
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * Gets the scenario.
	 *
	 * @return the scenario
	 */
	public String getScenario() {
		return scenario;
	}

	/**
	 * Sets the scenario.
	 *
	 * @param scenario the new scenario
	 */
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	/**
	 * Gets the group.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Sets the group.
	 *
	 * @param group the new group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Checks if is section.
	 *
	 * @return true, if is section
	 */
	public boolean isSection() {
		return section;
	}

	/**
	 * Sets the section.
	 *
	 * @param section the new section
	 */
	public void setSection(boolean section) {
		this.section = section;
	}

}
