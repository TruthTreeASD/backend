package edu.northeastern.truthtree.adapter.collections;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.northeastern.truthtree.adapter.utilities.JSONFileReader;

public class CollectionsMockAdapter implements ICollectionsAdapter {

	private static final String COLLECTIONS_FILE_PATH = "src/main/resources/Collections.json";

	@Override
	public JSONArray getCollections() {
		return JSONFileReader.readJSONFile(COLLECTIONS_FILE_PATH);
	}

}
