package edu.northeastern.truthtree.service.collections;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.collections.CollectionsAbstractAdapter;
import edu.northeastern.truthtree.adapter.collections.ICollectionsAdapter;

public class CollectionsService implements ICollectionsService {

	@Override
	public JSONArray getCollections() {
		ICollectionsAdapter adapter = new CollectionsAbstractAdapter();
		return adapter.getCollections();
	}

}
