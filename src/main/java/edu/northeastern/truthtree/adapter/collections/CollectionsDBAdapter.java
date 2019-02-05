package edu.northeastern.truthtree.adapter.collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class CollectionsDBAdapter extends CollectionsAbstractAdapter {
	private static final String COLLECTIONS_URL = "http://54.241.137.214:8080/api/collection/all";

	@Override
	public JSONArray getCollections() {
		JSONArray collections = null;
		try {
			URL urlObj = new URL(COLLECTIONS_URL);
			URLConnection connection = urlObj.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				response.append(line);
			}
			br.close();
			String jsonString = response.toString();
			JSONParser parser = new JSONParser();
			collections = (JSONArray) parser.parse(jsonString);

		} catch (Exception e) {

		}
		return collections;
	}

}
