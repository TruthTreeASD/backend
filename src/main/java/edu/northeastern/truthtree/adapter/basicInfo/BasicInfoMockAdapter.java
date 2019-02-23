package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

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
   * @param year The year you want the population details for.
   * @return JSON array that was parsed from the states JSON file.
   */
  @Override
  public JSONArray getBasicStatesInfo(int year) {

    return JSONUtil.readJSONFile(STATES_FILE_PATH);
  }

  /**
   * Gets the basic states info from STATES_FILE_PATH that have a population between startValue and
   * endValue.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicStatesInfo(int startValue, int endValue, int year) {
    JSONArray jsonArray = JSONUtil.readJSONFile(STATES_FILE_PATH);

    return JSONUtil.filterJSON(jsonArray, POPULATION_KEY, startValue, endValue);
  }

  /**
   * Reads a JSON file containing basic city information.
   *
   * @param year The year you want the population details for.
   * @return JSON array that was parsed from the cities JSON file.
   */
  @Override
  public JSONArray getBasicCitiesInfo(int year) {

    return JSONUtil.readJSONFile(CITIES_FILE_PATH);
  }

  /**
   * Gets the basic cities info from CITIES_FILE_PATH that have a population between startValue and
   * endValue.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicCitiesInfo(int startValue, int endValue, int year) {
    JSONArray jsonArray = JSONUtil.readJSONFile(CITIES_FILE_PATH);
    return JSONUtil.filterJSON(jsonArray, POPULATION_KEY, startValue, endValue);
  }

  /**
   * Reads a JSON file containing basic counties information.
   *
   * @param year The year you want the population details for.
   * @return JSON array that was parsed from the counties JSON file.
   */
  @Override
  public JSONArray getBasicCountiesInfo(int year) {

    return JSONUtil.readJSONFile(COUNTIES_FILE_PATH);
  }

  /**
   * Gets the basic counties info from COUNTIES_FILE_PATH that have a population between startValue
   * and endValue.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicCountiesInfo(int startValue, int endValue, int year) {
    JSONArray jsonArray = JSONUtil.readJSONFile(COUNTIES_FILE_PATH);
    return JSONUtil.filterJSON(jsonArray, POPULATION_KEY, startValue, endValue);
  }
}
