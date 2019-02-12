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
    private static final String Attributes_URL1 = "http://54.241.137.214:8080/api/attributes/attributeIds";
    private static final String Attributes_URL2 = "http://54.241.137.214:8080/api/attributes/attributeIds&states";
    private static final String Attributes_URL3 = "http://54.241.137.214:8080/api/attributes/attributeIds&states&yearList";
    private static final String Attributes_URL4 = "http://54.241.137.214:8080/api/attributes/attributeIds&states&yearRange";

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
        JSONArray result = URLUtil.readJSONFromURL(builder.toUriString());
        return joltHelper(result);
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
        JSONArray result = URLUtil.readJSONFromURL(builder.toUriString());
        return joltHelper(result);
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
        JSONArray result = URLUtil.readJSONFromURL(builder.toUriString());
        return joltHelper(result);
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
        JSONArray result = URLUtil.readJSONFromURL(builder.toUriString());
        return joltHelper(result);
    }

    private Object joltHelper(JSONArray input) {
        return JoltUtil.joltTransform(input.get(0), ATTRIBUTES_SPEC_PATH);
    }
}
