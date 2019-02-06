package edu.northeastern.truthtree.service.collections;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.truthtree.adapter.collections.ICollectionsAdapter;

@Component
public class CollectionsService implements ICollectionsService {
	private ICollectionsAdapter adapter;

	@Autowired
	public CollectionsService(ICollectionsAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public JSONArray getCollections() {
		return adapter.getCollections();
	}

}
