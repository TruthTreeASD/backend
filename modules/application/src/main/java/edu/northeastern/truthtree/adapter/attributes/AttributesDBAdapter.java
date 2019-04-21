package edu.northeastern.truthtree.adapter.attributes;

import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_SPEC_PATH;
import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_URL1;
import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_URL2;
import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_URL3;
import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_URL4;
import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_URL5;
import static edu.northeastern.truthtree.AppConst.ATTRIBUTE_ID_SPEC_PATH;
import static edu.northeastern.truthtree.adapter.utilities.JoltUtil.joltTransform;
import static edu.northeastern.truthtree.adapter.utilities.URLUtil.readJSONFromURL;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AttributesDBAdapter implements IAttributesAdapter {

  @Value("${databaseUrl}")
  private String db_endpoint;

  @Override
  public JSONArray getAttributes() {
    return null;
  }

  @Override
  public Object getAttributes(List<Integer> attributes) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(db_endpoint + ATTRIBUTES_URL1);
    for (Integer attributeId : attributes) {
      builder.queryParam("attributes", attributeId);
    }
    JSONArray response = readJSONFromURL(builder.toUriString());
    return joltHelper(response);
  }

  @Override
  public Object getAttributesWithLocations(List<Integer> attributes, List<Integer> locations) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(db_endpoint + ATTRIBUTES_URL2);
    for (Integer attributeId : attributes) {
      builder.queryParam("attributes", attributeId);
    }
    for (Integer locationId : locations) {
      builder.queryParam("state", locationId);
    }
    JSONArray response = readJSONFromURL(builder.toUriString());
    return joltHelper(response);
  }

  @Override
  public Object getAttributesWithLocationsYearList(List<Integer> attributes,
      List<Integer> locations, List<Integer> yearList) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(db_endpoint + ATTRIBUTES_URL3);
    for (Integer attributeId : attributes) {
      builder.queryParam("attributes", attributeId);
    }
    for (Integer locationId : locations) {
      builder.queryParam("state", locationId);
    }
    for (Integer year : yearList) {
      builder.queryParam("yearList", year);
    }
    JSONArray response = readJSONFromURL(builder.toUriString());
    return joltHelper(response);
  }

  @Override
  public Object getAttributesWithLocationsYearRange(List<Integer> attributes,
      List<Integer> locations, List<Integer> yearRange) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(db_endpoint + ATTRIBUTES_URL4);
    for (Integer attributeId : attributes) {
      builder.queryParam("attributes", attributeId);
    }
    for (Integer locationId : locations) {
      builder.queryParam("state", locationId);
    }
    for (Integer year : yearRange) {
      builder.queryParam("yearRange", year);
    }
    JSONArray response = readJSONFromURL(builder.toUriString());
    return joltHelper(response);
  }

  @Override
  public List<Integer> getAttributeIdWithCollectionProperty(List<Integer> collections,
      List<Integer> properties) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(db_endpoint + ATTRIBUTES_URL5);
    for (Integer collectionId : collections) {
      builder.queryParam("collection_ids", collectionId);
    }
    for (Integer propertyId : properties) {
      builder.queryParam("property_ids", propertyId);
    }
    JSONArray response = readJSONFromURL(builder.toUriString());
    String transformed = joltTransform(response.get(0), ATTRIBUTE_ID_SPEC_PATH).toString();
    String arr = transformed.split("[\\[\\]]")[1].trim();
    List<Integer> result = new ArrayList<>();
    for (String attributeId : arr.split(",")) {
      result.add(Integer.parseInt(attributeId.trim()));
    }
    return result;
  }

  private Object joltHelper(JSONArray input) {
    return joltTransform(input.get(0), ATTRIBUTES_SPEC_PATH);
  }
}
