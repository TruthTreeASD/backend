package edu.northeastern.truthtree.adapter.collections;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CollectionsMockAdapter implements ICollectionsAdapter {

	private static final String COLLECTIONS_FILE_PATH = "src/main/resources/Collections.json";

	@Override
	public JSONArray getCollections() {
		JSONParser parser = new JSONParser();
		JSONArray collections = new JSONArray();
		try {
			collections = (JSONArray) parser.parse(new FileReader(COLLECTIONS_FILE_PATH));

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return collections;
	}

}
