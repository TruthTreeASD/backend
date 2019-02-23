package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.adapter.utilities.JoltUtil;
import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.springframework.web.util.UriComponentsBuilder;

import static edu.northeastern.truthtree.AppConst.Attributes_URL3;
import static edu.northeastern.truthtree.AppConst.CITIES_SPEC_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.CITIES_URL;
import static edu.northeastern.truthtree.AppConst.COUNTIES_SPEC_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.COUNTIES_URL;
import static edu.northeastern.truthtree.AppConst.POPULATION_KEY;
import static edu.northeastern.truthtree.AppConst.POPULATION_SPEC_PATH;
import static edu.northeastern.truthtree.AppConst.STATES_SPEC_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.STATES_URL;
import static edu.northeastern.truthtree.adapter.utilities.JoltUtil.joltTransform;
import static edu.northeastern.truthtree.adapter.utilities.URLUtil.readJSONFromURL;

/**
 * Represents the Basic Info Adapter used to communicate with the database API.
 */
public class BasicInfoDBAdapter implements IBasicInfoAdapter {


  /**
   * Transforms the JSON retrieved from STATES_URL into the desired output.
   *
   * @param year The year you want the population details for.
   * @return JSONArray representing the data on STATES_URL
   */
  @Override
  public JSONArray getBasicStatesInfo(int year) {
    JSONArray jsonArray = URLUtil.readJSONFromURL(STATES_URL);

    jsonArray = JoltUtil.joltTransform(jsonArray, STATES_SPEC_FILE_PATH);

    JSONArray transformed = JSONUtil.moveObjectsUpOneLevel(jsonArray);

    return addAbbreviations(transformed);
  }

  /**
   * Gets the basic states info from STATES_URL that have a population between startValue and
   * endValue.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicStatesInfo(int startValue, int endValue, int year) {

    JSONArray jsonArray = URLUtil.readJSONFromURL(STATES_URL);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Attributes_URL3);

    int POPULATION_ATTRIBUTE_NUMBER = 1;
    builder.queryParam("attributes", POPULATION_ATTRIBUTE_NUMBER);
    builder.queryParam("yearList", year);

    JSONArray populationResponse = readJSONFromURL(builder.toUriString());
   // return joltTransform(populationResponse.get(0), POPULATION_SPEC_PATH);

    jsonArray = JoltUtil.joltTransform(jsonArray, POPULATION_SPEC_PATH);

    JSONArray transformed = JSONUtil.moveObjectsUpOneLevel(jsonArray);

    return JSONUtil.filterJSON(transformed, POPULATION_KEY, startValue, endValue);

  }

  /**
   * Gets the basic states info from the CITIES_URL
   *
   * @param year The year you want the population details for.
   * @return JSONArray representing the data on CITIES_URL
   */
  @Override
  public JSONArray getBasicCitiesInfo(int year) {
    JSONArray jsonArray = URLUtil.readJSONFromURL(CITIES_URL);

    jsonArray = JoltUtil.joltTransform(jsonArray, CITIES_SPEC_FILE_PATH);

    return JSONUtil.moveObjectsUpOneLevel(jsonArray);
  }

  /**
   * Gets the basic cities info from CITIES_URL that have a population between startValue and
   * endValue.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicCitiesInfo(int startValue, int endValue, int year) {

    JSONArray jsonArray = URLUtil.readJSONFromURL(CITIES_URL);

    jsonArray = JoltUtil.joltTransform(jsonArray, CITIES_SPEC_FILE_PATH);

    JSONArray transformed = JSONUtil.moveObjectsUpOneLevel(jsonArray);

    return JSONUtil.filterJSON(transformed, POPULATION_KEY, startValue, endValue);

  }

  /**
   * Gets the basic states info from the COUNTIES_URL
   *
   * @param year The year you want the population details for.
   * @return JSONArray representing the data on COUNTIES_URL
   */
  @Override
  public JSONArray getBasicCountiesInfo(int year) {

    JSONArray jsonArray = URLUtil.readJSONFromURL(COUNTIES_URL);

    jsonArray = JoltUtil.joltTransform(jsonArray, COUNTIES_SPEC_FILE_PATH);

    try {
      return JSONUtil.moveObjectsUpOneLevel(jsonArray);
    } catch (NullPointerException e) {
      return new JSONArray();
    }
  }

  /**
   * Gets the basic cities info from CITIES_URL that have a population between startValue and
   * endValue.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicCountiesInfo(int startValue, int endValue, int year) {

    JSONArray jsonArray = URLUtil.readJSONFromURL(COUNTIES_URL);

    jsonArray = JoltUtil.joltTransform(jsonArray, COUNTIES_SPEC_FILE_PATH);

    JSONArray transformed = JSONUtil.moveObjectsUpOneLevel(jsonArray);

    return JSONUtil.filterJSON(transformed, POPULATION_KEY, startValue, endValue);

  }

  /**
   * Adds each states abbreviation to the given JSONArray.
   *
   * @param withoutAbvs The JSONArray that will have abbreviations added to it.
   * @return Copy of withoutAbvs that now includes the states abbreviation
   */
  private JSONArray addAbbreviations(JSONArray withoutAbvs) {
    JSONArray withAbvs = new JSONArray();
    Map<String, String> statesMap = this.getStatesMap();

    for (Object state : withoutAbvs) {
      JSONObject currentState = (JSONObject) state;
      if (statesMap.containsKey(currentState.get("name").toString())) {
        currentState.put("abbreviation", statesMap.get(currentState.get("name").toString()));
        withAbvs.add(currentState);
      }
    }

    return withAbvs;
  }

  /**
   * Adds each locations population to the given JSONArray.
   *
   * @param year The year you want the population for.
   * @return Copy of withoutAbvs that now includes the states abbreviation
   */
  private JSONArray addPopulation(JSONArray withoutAbvs) {
    JSONArray withAbvs = new JSONArray();
    Map<String, String> statesMap = this.getStatesMap();

    for (Object state : withoutAbvs) {
      JSONObject currentState = (JSONObject) state;
      if (statesMap.containsKey(currentState.get("name").toString())) {
        currentState.put("abbreviation", statesMap.get(currentState.get("name").toString()));
        withAbvs.add(currentState);
      }
    }

    return withAbvs;
  }

  /**
   * Creates a HashMap that contains each states (key) and its abbreviation (value).
   *
   * @return HashMap<String   ,       String></> of states (key) and their abbreviations (value)
   */
  private Map<String, String> getStatesMap() {
    Map<String, String> statesMap = new HashMap<>();

    statesMap.put("ALABAMA", "AL");
    statesMap.put("ALASKA", "AK");
    statesMap.put("ARIZONA", "AZ");
    statesMap.put("ARKANSAS", "AR");
    statesMap.put("CALIFORNIA", "CA");
    statesMap.put("COLORADO", "CO");
    statesMap.put("CONNECTICUT", "CT");
    statesMap.put("DELAWARE", "DE");
    statesMap.put("WASHINGTON DC", "DC");
    statesMap.put("FLORIDA", "FL");
    statesMap.put("GEORGIA", "GA");
    statesMap.put("HAWAII", "HI");
    statesMap.put("IDAHO", "ID");
    statesMap.put("ILLINOIS", "IL");
    statesMap.put("INDIANA", "IN");
    statesMap.put("IOWA", "IA");
    statesMap.put("KANSAS", "KS");
    statesMap.put("KENTUCKY", "KY");
    statesMap.put("LOUISIANA", "LA");
    statesMap.put("MAINE", "ME");
    statesMap.put("MARYLAND", "MD");
    statesMap.put("MASSACHUSETTS", "MA");
    statesMap.put("MICHIGAN", "MI");
    statesMap.put("MINNESOTA", "MN");
    statesMap.put("MISSISSIPPI", "MS");
    statesMap.put("MISSOURI", "MO");
    statesMap.put("MONTANA", "MT");
    statesMap.put("NEBRASKA", "NE");
    statesMap.put("NEVADA", "NV");
    statesMap.put("NEW HAMPSHIRE", "NH");
    statesMap.put("NEW JERSEY", "NJ");
    statesMap.put("NEW MEXICO", "NM");
    statesMap.put("NEW YORK", "NY");
    statesMap.put("NORTH CAROLINA", "NC");
    statesMap.put("NORTH DAKOTA", "ND");
    statesMap.put("OHIO", "OH");
    statesMap.put("OKLAHOMA", "OK");
    statesMap.put("OREGON", "OR");
    statesMap.put("PENNSYLVANIA", "PA");
    statesMap.put("RHODE ISLAND", "RI");
    statesMap.put("SOUTH CAROLINA", "SC");
    statesMap.put("SOUTH DAKOTA", "SD");
    statesMap.put("TENNESSEE", "TN");
    statesMap.put("TEXAS", "TX");
    statesMap.put("UTAH", "UT");
    statesMap.put("VERMONT", "VT");
    statesMap.put("VIRGINIA", "VA");
    statesMap.put("WASHINGTON", "WA");
    statesMap.put("WEST VIRGINIA", "WV");
    statesMap.put("WISCONSIN", "WI");
    statesMap.put("WYOMING", "WY");

    return statesMap;
  }
}
