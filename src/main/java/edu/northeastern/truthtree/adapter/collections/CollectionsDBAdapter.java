package edu.northeastern.truthtree.adapter.collections;

import static edu.northeastern.truthtree.AppConst.COLLECTIONS_URL;

import org.json.simple.JSONArray;
import org.springframework.web.util.UriComponentsBuilder;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;

public class CollectionsDBAdapter implements ICollectionsAdapter {

	@Override
	public Object getCollections() {
		JSONArray response = URLUtil.readJSONFromURL(COLLECTIONS_URL);
		Object collectionsResponse = (Object) response.get(0);
		return (Object) collectionsResponse;
	}

	@Override
	public Object getCollectionsByLocationId(Integer locationId) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(COLLECTIONS_URL);
		builder.queryParam("id", locationId);
		JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
		Object collectionsResponse = (Object) response.get(0);
		return collectionsResponse;
	}

}
