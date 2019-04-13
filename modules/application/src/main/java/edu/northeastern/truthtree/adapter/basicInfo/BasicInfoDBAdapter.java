package edu.northeastern.truthtree.adapter.basicInfo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import edu.northeastern.truthtree.adapter.BaseAdapter;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.PageDTO;

import static edu.northeastern.truthtree.AppConst.CITIES_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.COUNTIES_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.POPULATION_ID;
import static edu.northeastern.truthtree.AppConst.POPULATION_RANGE_URL;
import static edu.northeastern.truthtree.AppConst.POPULATION_URL;
import static edu.northeastern.truthtree.AppConst.STATES_FILE_PATH;

/**
 * Represents the Basic Info Adapter used to communicate with the database API.
 */
@SuppressWarnings("unchecked")
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
  public PageDTO<LocationDTO> getBasicStatesInfo() {
    return jsonArrayToLocationPage(JSONUtil.readJSONFile(STATES_FILE_PATH));
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
  public PageDTO<LocationDTO> getBasicStatesInfo(int page, int startValue, int endValue)
          throws IOException {
    return getPopulationData(page, startValue, endValue, stateData, 0);
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
  public PageDTO<LocationDTO> getBasicCitiesInfo(int page, int startValue, int endValue)
          throws IOException {
    return getPopulationData(page, startValue, endValue, citiesData, 2);

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
  public PageDTO<LocationDTO> getBasicCountiesInfo(int page, int startValue, int endValue)
          throws IOException {
    return getPopulationData(page, startValue, endValue, countiesData, 1);
  }

  private PageDTO<LocationDTO> getPopulationData(int currentPage, int startValue, int endValue,
                                 Map<Long, Object> basicInfoMap, int typeCode)
          throws IOException {
    String url = UriComponentsBuilder
            .fromHttpUrl(POPULATION_RANGE_URL)
            .queryParam("attributeId", POPULATION_ID)
            .queryParam("year", 2016)
            .queryParam("from", startValue)
            .queryParam("to", endValue)
            .queryParam("currentPage", currentPage)
            .queryParam("typeCode", typeCode)
            .queryParam("pageSize", 50)
            .toUriString();

    ObjectMapper mapper = new ObjectMapper();
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    Map<String, Object> bodyMap = mapper.readValue(response.getBody(),
            new TypeReference<HashMap<String, Object>>(){});
    return mapToLocationPage((Map) bodyMap.get("data"), basicInfoMap);
  }

  @SuppressWarnings("unchecked")
  private PageDTO<LocationDTO> mapToLocationPage(Map<String, Object> dataMap,
                                                 Map<Long, Object> basicInfoMap) {
    List<Map<String, Object>> populationMaps = (List) dataMap.get("data");
    return new PageDTO
            .Builder()
            .withCurrentPage((int) dataMap.get("currentPage"))
            .withTotalPageCount((int) dataMap.get("totalPage"))
            .withTotalItemCount((int) dataMap.get("total"))
            .withItems(populationMaps
                    .stream()
                    .map(populationMap -> this.mapToLocationDTO(populationMap, basicInfoMap))
                    .collect(Collectors.toList()))
            .build();
  }

  private LocationDTO mapToLocationDTO(Map<String, Object> populationMap,
                                       Map<Long, Object> basicInfoMap) {
    long locationId =  ((Number) populationMap.get("location_id")).longValue();
    long population = ((Number) populationMap.get("value")).longValue();
    Map<String, Object> locationMap = (Map) basicInfoMap.get(locationId);
    return new LocationDTO
            .Builder()
            .withId(locationMap.get("id").toString())
            .withName((String) locationMap.get("name"))
            .withTypeCode(((Number) locationMap.get("type_code")).intValue())
            .withPopulation(population)
            .build();
  }

  private PageDTO<LocationDTO> jsonArrayToLocationPage(JSONArray array) {
    return new PageDTO.Builder()
            .withCurrentPage(1)
            .withTotalItemCount(array.size())
            .withTotalPageCount(1)
            .withItems((List) array
                    .stream()
                    .map(location -> {
                      Map locationMap = (Map) location;
                      return new LocationDTO
                              .Builder()
                              .withId(locationMap.get("id").toString())
                              .withTypeCode(((Number)locationMap.get("type_code")).intValue())
                              .withName(locationMap.get("name").toString())
                              .withLatitude((Double) locationMap.get("latitude"))
                              .withLongitude((Double) locationMap.get("longitude"))
                              .build();
                    })
                    .collect(Collectors.toList()))
            .build();
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
  public PageDTO<LocationDTO> getBasicCitiesInfo() {
    return jsonArrayToLocationPage(JSONUtil.readJSONFile(CITIES_FILE_PATH));
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
  public PageDTO<LocationDTO> getBasicCountiesInfo() {
    return jsonArrayToLocationPage(JSONUtil.readJSONFile(COUNTIES_FILE_PATH));
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
