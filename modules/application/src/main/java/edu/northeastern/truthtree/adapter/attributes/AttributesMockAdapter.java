package edu.northeastern.truthtree.adapter.attributes;

import org.json.simple.JSONArray;

import java.util.List;

import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_MOCK_SPEC_PATH;
import static edu.northeastern.truthtree.adapter.utilities.JSONUtil.readJSONFile;
import static edu.northeastern.truthtree.adapter.utilities.JoltUtil.joltTransform;

public class AttributesMockAdapter implements IAttributesAdapter {

  @Override
  public JSONArray getAttributes() {
    JSONArray attributesList = readJSONFile(ATTRIBUTES_FILE_PATH);
    return joltTransform(attributesList, ATTRIBUTES_MOCK_SPEC_PATH);
  }

  @Override
  public JSONArray getAttributes(List<Integer> dummy) {
    return null;
  }

  @Override
  public JSONArray getAttributesWithLocations(List<Integer> attributes, List<Integer> locations) {
    return null;
  }

  @Override
  public JSONArray getAttributesWithLocationsYearList(List<Integer> attributes,
                                                      List<Integer> locations, List<Integer> yearList) {
    return null;
  }

  @Override
  public JSONArray getAttributesWithLocationsYearRange(List<Integer> attributes,
                                                       List<Integer> locations, List<Integer> yearRange) {
    return null;
  }

  @Override
  public List<Integer> getAttributeIdWithCollectionProperty(List<Integer> collections,
                                                            List<Integer> properties) {
    return null;
  }
}
