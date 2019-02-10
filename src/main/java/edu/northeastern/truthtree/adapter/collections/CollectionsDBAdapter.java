package edu.northeastern.truthtree.adapter.collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;

public class CollectionsDBAdapter implements ICollectionsAdapter {
	private static final String COLLECTIONS_URL = "http://54.241.137.214:8080/api/collections";

	@Override
	public JSONArray getCollections() {
		JSONArray response = URLUtil.readJSONFromURL(COLLECTIONS_URL);
		JSONObject collectionsResponse = (JSONObject) response.get(0);
		return (JSONArray) collectionsResponse.get("data");
	}

}
