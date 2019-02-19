package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

/**
 * Represents the interface for the Basic Info Adapter.
 */
public interface IBasicInfoAdapter {


	/**
	 * Gets the basic States information.
	 *
	 * @return basic States information as a JSONArray.
	 */
	JSONArray getBasicStatesInfo();

	/**
	 * Gets the basic States information for states that have a population within startValue and
	 * endValue, inclusive.
	 *
	 * @param startValue The value that all wanted values will be greater than or equal to.
	 * @param endValue   The value that all wanted values will be less than or equal to.
	 * @return JSONArray that contains states that are within the provided range.
	 */
	JSONArray getBasicStatesInfo (int startValue, int endValue);

	/**
	 * Gets the basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray.
	 */
	JSONArray getBasicCitiesInfo();

	/**
	 * Gets the basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray.
	 */
	JSONArray getBasicCountiesInfo();
}
