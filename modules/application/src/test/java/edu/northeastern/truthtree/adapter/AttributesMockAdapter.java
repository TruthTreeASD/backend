package edu.northeastern.truthtree.adapter;

import static edu.northeastern.truthtree.TestConstants.ALL_YEARS_GROSS_VALUE;
import static edu.northeastern.truthtree.TestConstants.YEAR_LIST_GROSS_VALUE;
import static edu.northeastern.truthtree.TestConstants.YEAR_RANGE_GROSS_VALUE;

import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import java.util.List;
import org.json.simple.JSONArray;

public class AttributesMockAdapter implements IAttributesAdapter {
  @Override
  public JSONArray getAttributes() {
    return null;
  }

  @Override
  public Object getAttributes(List<Integer> attributes) {
    return null;
  }

  @Override
  public Object getAttributesWithLocations(List<Integer> attributes, List<Integer> locations) {
    return JSONUtil.readJSONFile(ALL_YEARS_GROSS_VALUE);
  }

  @Override
  public Object getAttributesWithLocationsYearList(List<Integer> attributes, List<Integer> locations, List<Integer> yearList) {
    return JSONUtil.readJSONFile(YEAR_LIST_GROSS_VALUE);
  }

  @Override
  public Object getAttributesWithLocationsYearRange(List<Integer> attributes, List<Integer> locations, List<Integer> yearRange) {
    return JSONUtil.readJSONFile(YEAR_RANGE_GROSS_VALUE);
  }

  @Override
  public List<Integer> getAttributeIdWithCollectionProperty(List<Integer> collections, List<Integer> properties) {
    return null;
  }
}
