package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import edu.northeastern.truthtree.adapter.BaseAdapter;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

import static edu.northeastern.truthtree.AppConst.CITIES_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.COUNTIES_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.POPULATION_ID;
import static edu.northeastern.truthtree.AppConst.POPULATION_RANGE_URL;
import static edu.northeastern.truthtree.AppConst.POPULATION_URL;
import static edu.northeastern.truthtree.AppConst.STATES_FILE_PATH;
import static edu.northeastern.truthtree.adapter.utilities.URLUtil.readJSONFromURL;

/**
 * Represents the Basic Info Adapter used to communicate with the database API.
 */
public class BasicInfoDBAdapter extends BaseAdapter implements IBasicInfoAdapter {
  private static Map<Long, Object> stateData = new HashMap<>();
  private static Map<Long, Object> citiesData = new HashMap<>();
  private static Map<Long, Object> countiesData = new HashMap<>();

  static {
    List stData = JSONUtil.readJSONFile(STATES_FILE_PATH);
    for (Object val : stData) {
      Map map = (HashMap) val;
      Long id = (Long) map.get("id");
      stateData.put(id, val);
    }

    List coData = JSONUtil.readJSONFile(COUNTIES_FILE_PATH);
    for (Object val : coData) {
      Map map = (HashMap) val;
      Long id = (Long) map.get("id");
      countiesData.put(id, val);
    }

    List ciData = JSONUtil.readJSONFile(CITIES_FILE_PATH);
    for (Object val : ciData) {
      Map map = (HashMap) val;
      Long id = (Long) map.get("id");
      citiesData.put(id, val);
    }
  }

  private Long getLocationPopulation(String locationId, String year) {
    Map response = (Map) this.restTemplate
            .getForObject(String.format(POPULATION_URL, locationId), Map.class)
            .get("data");

    List<Map> populationsByYear = (List) response.get("data");

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
    return JSONUtil.readJSONFile(STATES_FILE_PATH);
  }

  private List getAllCounties() {
    return JSONUtil.readJSONFile(COUNTIES_FILE_PATH);
  }

  private List getAllCities() {
    return JSONUtil.readJSONFile(CITIES_FILE_PATH);
  }

  /**
   * Transforms the JSON retrieved from STATES_URL into the desired output.
   *
   * @return JSONArray representing the data on STATES_URL
   */
  @Override
  public JSONArray getBasicStatesInfo() {
    return JSONUtil.readJSONFile(STATES_FILE_PATH);
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
  public JSONArray getBasicStatesInfo(int startValue, int endValue, int year) {
    JSONArray response = getPopulationData(startValue, endValue, 0, year);
    return addPopulationToBasicInfo(stateData, response);
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
  public JSONArray getBasicCitiesInfo(int startValue, int endValue, int year) {
    JSONArray response = getPopulationData(startValue, endValue, 2, year);
    return addPopulationToBasicInfo(citiesData, response);

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
  public JSONArray getBasicCountiesInfo(int startValue, int endValue, int year) {
    JSONArray response = getPopulationData(startValue, endValue, 1, year);
    return addPopulationToBasicInfo(countiesData, response);
  }

  private JSONArray getPopulationData(int startValue, int endValue, int typeCode, int year) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(POPULATION_RANGE_URL);
    builder.queryParam("attributeId", POPULATION_ID);
    builder.queryParam("year", year);
    builder.queryParam("from", startValue);
    builder.queryParam("to", endValue);
    builder.queryParam("typeCode", typeCode);
    String url = builder.toUriString();
    JSONArray response = readJSONFromURL(url);
    return response;
  }

  private JSONArray addPopulationToBasicInfo(Map basicInfoData, JSONArray response) {
    JSONArray respArray = new JSONArray();
    Map object = (HashMap) response.get(0);
    Map dataMap = (HashMap) object.get("data");
    JSONArray valueMap = (JSONArray) dataMap.get("data");
    for (Object val : valueMap) {
      Map data = (HashMap) val;
      Long key = (Long) data.get("location_id");
      Map countiesInfo = (HashMap) basicInfoData.get(key);
      countiesInfo.put("population", data.get("value"));
      respArray.add(countiesInfo);
    }
    return respArray;
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
    return JSONUtil.readJSONFile(CITIES_FILE_PATH);
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
    return JSONUtil.readJSONFile(COUNTIES_FILE_PATH);
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
   * Creates a HashMap that contains each states (key) and its abbreviation (value).
   *
   * @return HashMap<String                                                                                                                               ,
               *       String></> of states (key) and their abbreviations (value)
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
