package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

/**
 * Represents the Basic Info Adapter used to read mock data created to simulate the data that is
 * received from the database.
 */
public class BasicInfoMockAdapter implements IBasicInfoAdapter {
	private static final String STATES_FILE_PATH = "src/main/resources/States.json";
	private static final String CITIES_FILE_PATH = "src/main/resources/Cities.json";
	private static final String COUNTIES_FILE_PATH = "src/main/resources/Counties.json";

	/**
	 * Reads a JSON file containing basic state information.
	 *
	 * @return JSON array that was parsed from the states JSON file.
	 */
	@Override
	public JSONArray getBasicStatesInfo() {

		return JSONUtil.readJSONFile(STATES_FILE_PATH);
	}

	/**
	 * Gets the basic states info from STATES_FILE_PATH that have a population between startValue and
	 * endValue.
	 *
	 * @param startValue The value that all wanted values will be greater than or equal to.
	 * @param endValue   The value that all wanted values will be less than or equal to.
	 * @return JSONArray that contains states that are within the provided range.
	 */
	@Override
	public JSONArray getBasicStatesInfo(int startValue, int endValue) {
		JSONArray jsonArray = JSONUtil.readJSONFile(STATES_FILE_PATH);

		return JSONUtil.filterJSON(jsonArray, POPULATION_KEY, startValue, endValue);
	}

	/**
	 * Reads a JSON file containing basic city information.
	 *
	 * @return JSON array that was parsed from the cities JSON file.
	 */
	@Override
	public JSONArray getBasicCitiesInfo() {

		return JSONUtil.readJSONFile(CITIES_FILE_PATH);
	}

	/**
	 * Reads a JSON file containing basic counties information.
	 *
	 * @return JSON array that was parsed from the counties JSON file.
	 */
	@Override
	public JSONArray getBasicCountiesInfo() {

		return JSONUtil.readJSONFile(COUNTIES_FILE_PATH);
	}
}
