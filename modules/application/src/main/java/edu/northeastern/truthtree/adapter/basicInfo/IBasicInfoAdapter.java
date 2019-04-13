package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.PageDTO;

/**
 * Represents the interface for the Basic Info Adapter.
 */
public interface IBasicInfoAdapter {

  /**
   * Gets the basic States information.
   *
   * @return basic States information as a JSONArray.
   */
  PageDTO<LocationDTO> getBasicStatesInfo();

  /**
   * Gets the basic States information for states that have a population within startValue and
   * endValue, inclusive.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue   The value that all wanted values will be less than or equal to.
   * @return JSONArray that contains states that are within the provided range.
   */
  PageDTO<LocationDTO> getBasicStatesInfo(int page, int startValue, int endValue) throws IOException;

  /**
   * Gets a state's details.
   *
   * @return a Map optional that contains the state's details if found.
   */
  Optional<Map> getStateDetails(String stateId, String year);

  /**
   * Gets the basic Cities information.
   *
   * @return basic Cities information as a JSONArray.
   */
  PageDTO<LocationDTO> getBasicCountiesInfo();
  PageDTO<LocationDTO> getBasicCountiesInfo(int page, int startValue, int endValue) throws IOException;

  /**
   * Gets a county's details.
   *
   * @param countyId the county id.
   * @param year year of population data
   * @return a Map optional that contains the county's details if found.
   */
  Optional<Map> getCountyDetails(String countyId, String year);

  /**
   * Gets the basic Cities information.
   *
   * @return basic Cities information as a JSONArray.
   */
  PageDTO<LocationDTO> getBasicCitiesInfo();

  PageDTO<LocationDTO> getBasicCitiesInfo(int page, int startValue, int endValue) throws IOException;

  /**
   * Gets a city's details.
   *
   * @param cityId the county id.
   * @param year year of population data
   * @return a Map optional that contains the city's details if found.
   */
  Optional<Map> getCityDetails(String cityId, String year);
}
