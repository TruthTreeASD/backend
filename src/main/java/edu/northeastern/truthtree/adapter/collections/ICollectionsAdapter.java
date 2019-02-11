package edu.northeastern.truthtree.adapter.collections;

import org.json.simple.JSONArray;

public interface ICollectionsAdapter {
	public JSONArray getCollections();

	public JSONArray getCollectionsByLocationId(Integer locationId);
}
