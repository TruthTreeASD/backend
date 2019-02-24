package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Map;
import java.util.Optional;

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
	 * Gets a state's details.
	 *
	 * @return
	 */
	Optional<Map> getStateDetails(String stateId, String year);

	/**
	 * Gets a county's details.
	 *
	 * @return
	 */
	Optional<Map> getCountyDetails(String countyId, String year);

	/**
	 * Gets a city's details.
	 *
	 * @return
	 */
	Optional<Map> getCityDetails(String countyId, String year);

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
