package edu.northeastern.truthtree.adapter.collections;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;

public class CollectionsDBAdapter implements ICollectionsAdapter {
	private static final String COLLECTIONS_URL = "http://54.241.137.214:8080/api/collection/all";

	@Override
	public JSONArray getCollections() {

		return URLUtil.readJSONFromURL(COLLECTIONS_URL);
	}

}
