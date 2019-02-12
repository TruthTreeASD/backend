package edu.northeastern.truthtree.adapter.attributes;

import edu.northeastern.truthtree.adapter.utilities.JoltUtil;
import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class AttributesDBAdapter implements IAttributesAdapter {
    private static final String ATTRIBUTES_SPEC_PATH = "src/main/resources/AttributesSpec.json";
    private static final String ATTRIBUTE_ID_SPEC_PATH = "src/main/resources/AttributeIdSpec.json";
    private static final String Attributes_URL1 = "http://54.241.137.214:8080/api/attributes/attributeIds";
    private static final String Attributes_URL2 = "http://54.241.137.214:8080/api/attributes/attributeIds&states";
    private static final String Attributes_URL3 = "http://54.241.137.214:8080/api/attributes/attributeIds&states&yearList";
    private static final String Attributes_URL4 = "http://54.241.137.214:8080/api/attributes/attributeIds&states&yearRange";
    private static final String Attributes_URL5 = "http://54.241.137.214:8080/api/queryAttriIdByCombineation";

    @Override
    public JSONArray getAttributes() {
        return null;
    }

    @Override
    public Object getAttributes(List<Integer> attributes) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Attributes_URL1);
        for (Integer attributeId : attributes) {
            builder.queryParam("attributes", attributeId);
        }
        JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
        return joltHelper(response);
    }

    @Override
    public Object getAttributesWithLocations(List<Integer> attributes, List<Integer> locations) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Attributes_URL2);
        for (Integer attributeId : attributes) {
            builder.queryParam("attributes", attributeId);
        }
        for (Integer locationId : locations) {
            builder.queryParam("state", locationId);
        }
        JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
        return joltHelper(response);
    }

    @Override
    public Object getAttributesWithLocationsYearList(List<Integer> attributes, List<Integer> locations, List<Integer> yearList) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Attributes_URL3);
        for (Integer attributeId : attributes) {
            builder.queryParam("attributes", attributeId);
        }
        for (Integer locationId : locations) {
            builder.queryParam("state", locationId);
        }
        for (Integer year : yearList) {
            builder.queryParam("yearList", year);
        }
        JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
        return joltHelper(response);
    }

    @Override
    public Object getAttributesWithLocationsYearRange(List<Integer> attributes, List<Integer> locations, List<Integer> yearRange) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Attributes_URL4);
        for (Integer attributeId : attributes) {
            builder.queryParam("attributes", attributeId);
        }
        for (Integer locationId : locations) {
            builder.queryParam("state", locationId);
        }
        for (Integer year : yearRange) {
            builder.queryParam("yearRange", year);
        }
        JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
        return joltHelper(response);
    }

    @Override
    public List<Integer> getAttributeIdWithCollectionProperty(List<Integer> collections, List<Integer> properties) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Attributes_URL5);
        for (Integer collectionId : collections) {
            builder.queryParam("collection_ids", collectionId);
        }
        for (Integer propertyId : properties) {
            builder.queryParam("property_ids", propertyId);
        }
        JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
        String transformed = JoltUtil.joltTransform(response.get(0), ATTRIBUTE_ID_SPEC_PATH).toString();
        String arr =  transformed.split("[\\[\\]]")[1].trim();
        List<Integer> result = new ArrayList<>();
        for (String attributeId : arr.split(",")) {
            result.add(Integer.parseInt(attributeId.trim()));
        }
        return result;
    }

    private Object joltHelper(JSONArray input) {
        return JoltUtil.joltTransform(input.get(0), ATTRIBUTES_SPEC_PATH);
    }
}
