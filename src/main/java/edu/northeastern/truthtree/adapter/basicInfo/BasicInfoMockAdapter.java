package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

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

		return readJSONFile(STATES_FILE_PATH);
	}

	/**
	 * Reads a JSON file containing basic city information.
	 *
	 * @return JSON array that was parsed from the cities JSON file.
	 */
	@Override
	public JSONArray getBasicCitiesInfo() {

		return readJSONFile(CITIES_FILE_PATH);
	}

	/**
	 * Reads a JSON file containing basic counties information.
	 *
	 * @return JSON array that was parsed from the counties JSON file.
	 */
	@Override
	public JSONArray getBasicCountiesInfo() {

		return readJSONFile(COUNTIES_FILE_PATH);
	}

	/**
	 * Loads and parses a JSON file into a JSON array.
	 *
	 * @param filePath location of the JSON file that will be parsed.
	 *
	 * @return JSON array that represents the loaded file at filePath
	 */
	private JSONArray readJSONFile(String filePath) {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray = new JSONArray();

		try {
			jsonArray = (JSONArray) parser.parse(new FileReader(filePath));

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return jsonArray;
	}
}
