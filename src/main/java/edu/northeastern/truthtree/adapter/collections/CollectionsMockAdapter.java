package edu.northeastern.truthtree.adapter.collections;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

public class CollectionsMockAdapter implements ICollectionsAdapter {

	private static final String COLLECTIONS_FILE_PATH = "src/main/resources/Collections.json";

	@Override
	public JSONArray getCollections() {
		return JSONUtil.readJSONFile(COLLECTIONS_FILE_PATH);
	}

	@Override
	public JSONArray getCollectionsByLocationId(Integer locationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
