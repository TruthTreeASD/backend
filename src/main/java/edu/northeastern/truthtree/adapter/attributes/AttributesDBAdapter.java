package edu.northeastern.truthtree.adapter.attributes;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;

public class AttributesDBAdapter implements IAttributesAdapter{
  private static final String Attributes_URL = "TBD";

  @Override
  public JSONArray getAttributes() {

    return URLUtil.readJSONFromURL(Attributes_URL);
  }
}
