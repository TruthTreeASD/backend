package edu.northeastern.truthtree.service.collections;

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
	public Object getCollections(Integer locationId) {
		if (locationId != null) {
			return adapter.getCollectionsByLocationId(locationId);
		}
		return adapter.getCollections();
	}

}
