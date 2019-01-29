package edu.northeastern.truthtree.service.collections;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.collections.CollectionsMockAdapter;
import edu.northeastern.truthtree.adapter.collections.ICollectionAdapter;

public class CollectionsService implements ICollectionsService {

	@Override
	public JSONArray getCollections() {
		ICollectionAdapter adapter = new CollectionsMockAdapter();
		return adapter.getCollections();
	}

}
