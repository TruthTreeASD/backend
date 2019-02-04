package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.utilities.JSONFileReader;

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

		return JSONFileReader.readJSONFile(STATES_FILE_PATH);
	}

	/**
	 * Reads a JSON file containing basic city information.
	 *
	 * @return JSON array that was parsed from the cities JSON file.
	 */
	@Override
	public JSONArray getBasicCitiesInfo() {

		return JSONFileReader.readJSONFile(CITIES_FILE_PATH);
	}

	/**
	 * Reads a JSON file containing basic counties information.
	 *
	 * @return JSON array that was parsed from the counties JSON file.
	 */
	@Override
	public JSONArray getBasicCountiesInfo() {

		return JSONFileReader.readJSONFile(COUNTIES_FILE_PATH);
	}
}
