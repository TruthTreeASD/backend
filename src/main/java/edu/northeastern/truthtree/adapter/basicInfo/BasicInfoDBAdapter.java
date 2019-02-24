package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.sound.midi.Soundbank;

import edu.northeastern.truthtree.adapter.BaseAdapter;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.adapter.utilities.JoltUtil;
import edu.northeastern.truthtree.adapter.utilities.URLUtil;

import static edu.northeastern.truthtree.AppConst.CITIES_SPEC_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.CITIES_URL;
import static edu.northeastern.truthtree.AppConst.COUNTIES_SPEC_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.COUNTIES_URL;
import static edu.northeastern.truthtree.AppConst.POPULATION_KEY;
import static edu.northeastern.truthtree.AppConst.POPULATION_URL;
import static edu.northeastern.truthtree.AppConst.STATES_SPEC_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.STATES_URL;

/**
 * Represents the Basic Info Adapter used to communicate with the database API.
 */
public class BasicInfoDBAdapter extends BaseAdapter implements IBasicInfoAdapter {

  private Long getLocationPopulation(String locationId, String year) {
    Map response = (Map) this.restTemplate
            .getForObject(String.format(POPULATION_URL, locationId), Map.class)
            .get("data");

    List<Map> populationsByYear = (List) response.get("data");
    Collections.sort(populationsByYear,
            (data1, data2) ->
                    ((Integer) data2.get("year")) - ((Integer) data2.get("year")));

    if (year == null) {
      // Return the most recent data point can find for population if year not specified
      return populationsByYear
              .stream()
              .findFirst()
              .map(data -> ((Double) data.get("value")).longValue())
              // Defaults to 0 if no data point found
              .orElse(0L);
    }

    return populationsByYear
            .stream()
            .filter(data -> data.get("year").toString().equals(year))
            .findAny()
            .map(data -> ((Double) data.get("value")).longValue())
            // Defaults to 0 if no data point found
            .orElse(0L);
  }


  private Optional<Map> getLocationById(List<Map> locations, String id, String year) {
    return locations.stream()
            .filter(location -> location.get("id").toString().equals(id))
            .findAny()
            .map(location -> {
              location.put("population", getLocationPopulation(id, year));
              return location;
            });
  }

  private List getAllStates() {
    List<Map> data = (List) this.restTemplate
            .getForObject(STATES_URL, Map.class).get("data");
    return data;
  }

  private List getAllCounties() {
    List<Map> data = (List) this.restTemplate
            .getForObject(COUNTIES_URL, Map.class).get("data");
    return data;
  }

    private List getAllCities() {
    List<Map> data = (List) this.restTemplate
            .getForObject(CITIES_URL, Map.class).get("data");
    return data;
  }

  /**
   * Transforms the JSON retrieved from STATES_URL into the desired output.
   *
   * @return JSONArray representing the data on STATES_URL
   */
  @Override
  public JSONArray getBasicStatesInfo() {
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
   * @param endValue   The value that all wanted values will be less than or equal to.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicStatesInfo(int startValue, int endValue) {

    JSONArray jsonArray = URLUtil.readJSONFromURL(STATES_URL);

    jsonArray = JoltUtil.joltTransform(jsonArray, STATES_SPEC_FILE_PATH);

    JSONArray transformed = JSONUtil.moveObjectsUpOneLevel(jsonArray);

    return JSONUtil.filterJSON(transformed, POPULATION_KEY, startValue, endValue);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Map> getStateDetails(String stateId, String year) {
    Optional<Map> stateDetailOptional = getLocationById(getAllStates(), stateId, year);
    return stateDetailOptional.map(stateDetail -> {
      stateDetail.put("abbreviation", getStatesMap().get(stateDetail.get("name")));
      return stateDetail;
    });
  }

  /**
   * Gets the basic states info from the CITIES_URL
   *
   * @return JSONArray representing the data on CITIES_URL
   */
  @Override
  public JSONArray getBasicCitiesInfo() {
    JSONArray jsonArray = URLUtil.readJSONFromURL(CITIES_URL);

    jsonArray = JoltUtil.joltTransform(jsonArray, CITIES_SPEC_FILE_PATH);

    return JSONUtil.moveObjectsUpOneLevel(jsonArray);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Map> getCityDetails(String cityId, String year) {
    Optional<Map> cityDetailOptional = getLocationById(getAllCities(), cityId, year);
    return cityDetailOptional;
  }

  /**
   * Gets the basic states info from the COUNTIES_URL
   *
   * @return JSONArray representing the data on COUNTIES_URL
   */
  @Override
  public JSONArray getBasicCountiesInfo() {

    JSONArray jsonArray = URLUtil.readJSONFromURL(COUNTIES_URL);

    jsonArray = JoltUtil.joltTransform(jsonArray, COUNTIES_SPEC_FILE_PATH);

    try {
      return JSONUtil.moveObjectsUpOneLevel(jsonArray);
    } catch (NullPointerException e) {
      return new JSONArray();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Map> getCountyDetails(String countyId, String year) {
    Optional<Map> countyDetailOptional = getLocationById(getAllCounties(), countyId, year);
    return countyDetailOptional;
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
