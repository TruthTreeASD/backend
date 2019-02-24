package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

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
	 * Gets the basic States information for states that have a population within startValue and
	 * endValue, inclusive.
	 *
	 * @param startValue The value that all wanted values will be greater than or equal to.
	 * @param endValue   The value that all wanted values will be less than or equal to.
	 * @return JSONArray that contains states that are within the provided range.
	 */
	JSONArray getBasicStatesInfo (int startValue, int endValue);

	/**
	 * Gets a state's details.
	 *
	 * @return a Map optional that contains the state's details if found.
	 */
	Optional<Map> getStateDetails(String stateId, String year);

	/**
	 * Gets the basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray.
	 */
	JSONArray getBasicCountiesInfo();

	/**
	 * Gets a county's details.
	 *
	 * @param countyId the county id.
	 * @param year year of population data
	 * @return a Map optional that contains the county's details if found.
	 */
	Optional<Map> getCountyDetails(String countyId, String year);

  /**
   * Gets the basic Cities information.
   *
   * @return basic Cities information as a JSONArray.
   */
  JSONArray getBasicCitiesInfo();

	/**
	 * Gets a city's details.
	 *
	 * @param cityId the county id.
	 * @param year year of population data
	 * @return a Map optional that contains the city's details if found.
	 */
	Optional<Map> getCityDetails(String cityId, String year);
}
