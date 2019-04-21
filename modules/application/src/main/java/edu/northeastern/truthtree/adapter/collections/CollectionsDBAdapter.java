package edu.northeastern.truthtree.adapter.collections;

import static edu.northeastern.truthtree.AppConst.COLLECTIONS_SPEC_PATH;
import static edu.northeastern.truthtree.AppConst.COLLECTIONS_URL;
import static edu.northeastern.truthtree.adapter.utilities.JoltUtil.joltTransform;
import static edu.northeastern.truthtree.adapter.utilities.URLUtil.readJSONFromURL;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CollectionsDBAdapter implements ICollectionsAdapter {

  @Value("${databaseUrl}")
  private String db_endpoint;

  @Override
  public Object getCollections() {
    JSONArray response = URLUtil.readJSONFromURL(db_endpoint + COLLECTIONS_URL);
    return joltTransform(response.get(0), COLLECTIONS_SPEC_PATH);
  }

  @Override
  public Object getCollectionsByLocationId(Integer locationId) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(db_endpoint + COLLECTIONS_URL);
    builder.queryParam("id", locationId);

    JSONArray response = readJSONFromURL(builder.toUriString());
    return joltTransform(response.get(0), COLLECTIONS_SPEC_PATH);
  }

}
