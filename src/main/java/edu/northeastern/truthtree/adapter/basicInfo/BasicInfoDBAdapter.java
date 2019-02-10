package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;

public class BasicInfoDBAdapter implements IBasicInfoAdapter {
  private static final String STATES_URL = "http://54.241.137.214:8080/api/location/state";
  private static final String COUNTIES_URL = "http://54.241.137.214:8080/api/location/county";
  private static final String CITIES_URL = "http://54.241.137.214:8080/api/location/city";

  /**
   * Gets the basic states info from the STATES_URL
   *
   * @return JSONArray representing the data on STATES_URL
   */
  @Override
  public JSONArray getBasicStatesInfo() {

    return URLUtil.readJSONFromURL(STATES_URL);
  }

  /**
   * Gets the basic states info from STATES_URL that have a population betwee startValue and
   * endValue.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue   The value that all wanted values will be less than or equal to.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicStatesPopulationRange(int startValue, int endValue) {
    return null;
  }

  /**
   * Gets the basic states info from the CITIES_URL
   *
   * @return JSONArray representing the data on CITIES_URL
   */
  @Override
  public JSONArray getBasicCitiesInfo() {

    return URLUtil.readJSONFromURL(CITIES_URL);
  }

  /**
   * Gets the basic states info from the COUNTIES_URL
   *
   * @return JSONArray representing the data on COUNTIES_URL
   */
  @Override
  public JSONArray getBasicCountiesInfo() {

    return URLUtil.readJSONFromURL(COUNTIES_URL);
  }
}
