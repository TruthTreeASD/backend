package edu.northeastern.truthtree.adapter.attributes;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.adapter.utilities.JoltUtil;

import java.util.List;

public class AttributesMockAdapter implements IAttributesAdapter{
    private static final String ATTRIBUTES_FILE_PATH = "src/main/resources/Attributes.json";
    private static final String ATTRIBUTES_SPEC_PATH = "src/main/resources/AttributesMockSpec.json";

    public JSONArray getAttributes() {
        JSONArray attributesList = JSONUtil.readJSONFile(ATTRIBUTES_FILE_PATH);
        return JoltUtil.joltTransform(attributesList, ATTRIBUTES_SPEC_PATH);
    }

    public JSONArray getAttributes(List<Integer> dummy) {
        return null;
    }

    public JSONArray getAttributesWithLocations(List<Integer> attributes, List<Integer> locations) {
        return null;
    }

    public JSONArray getAttributesWithLocationsYearList(List<Integer> attributes, List<Integer> locations, List<Integer> timeList) {
        return null;
    }

    public JSONArray getAttributesWithLocationsYearRange(List<Integer> attributes, List<Integer> locations, List<Integer> timeRange) {
        return null;
    }
}
