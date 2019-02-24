package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

import java.util.Map;
import java.util.Optional;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

import static edu.northeastern.truthtree.AppConst.CITIES_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.COUNTIES_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.POPULATION_KEY;
import static edu.northeastern.truthtree.AppConst.STATES_FILE_PATH;

/**
 * Represents the Basic Info Adapter used to read mock data created to simulate the data that is
 * received from the database.
 */
public class BasicInfoMockAdapter implements IBasicInfoAdapter {

  /**
   * Reads a JSON file containing basic state information.
   *
   * @return JSON array that was parsed from the states JSON file.
   */
  @Override
  public JSONArray getBasicStatesInfo() {

    return JSONUtil.readJSONFile(STATES_FILE_PATH);
  }

  @Override
  public Optional<Map> getStateDetails(String stateId, String year) {
    return null;
  }

  @Override
  public Optional<Map> getCountyDetails(String countyId, String year) {
    return null;
  }

  @Override
  public Optional<Map> getCityDetails(String countyId, String year) {
    return null;
  }

  /**
   * Gets the basic states info from STATES_FILE_PATH that have a population between startValue and
   * endValue.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue   The value that all wanted values will be less than or equal to.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicStatesInfo(int startValue, int endValue) {
    JSONArray jsonArray = JSONUtil.readJSONFile(STATES_FILE_PATH);

    return JSONUtil.filterJSON(jsonArray, POPULATION_KEY, startValue, endValue);
  }

  /**
   * Reads a JSON file containing basic city information.
   *
   * @return JSON array that was parsed from the cities JSON file.
   */
  @Override
  public JSONArray getBasicCitiesInfo() {

    return JSONUtil.readJSONFile(CITIES_FILE_PATH);
  }

  /**
   * Reads a JSON file containing basic counties information.
   *
   * @return JSON array that was parsed from the counties JSON file.
   */
  @Override
  public JSONArray getBasicCountiesInfo() {

    return JSONUtil.readJSONFile(COUNTIES_FILE_PATH);
  }
}
