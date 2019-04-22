package edu.northeastern.truthtree.service.basicInfo;

import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.PageDTO;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * Represents the Basic Info Service interface.
 */
public interface IBasicInfoService {

  /**
   * Gets basic States information for states. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @return JSONArray that contains states that are within the provided range.
   */
  PageDTO<LocationDTO> getBasicStatesInfo(int currentPage, int[] range) throws IOException;

  /**
   * Gets a state information.
   *
   * @param stateId the state's Id
   * @param year the year for population data
   * @return a Map optional that contains the state's info if found, otherwise empty optional
   */
  Optional<Map> getStateDetails(String stateId, String year);

  /**
   * Gets the basic Cities information.
   *
   * @return basic Cities information as a JSONArray.
   */
  PageDTO<LocationDTO> getBasicCitiesInfo(int page, int[] range) throws IOException;

  /**
   * Gets a state information.
   *
   * @param cityId the city's Id
   * @param year the year for population data
   * @return a Map optional that contains the state's info if found, otherwise empty optional
   */
  Optional<Map> getCityDetails(String cityId, String year);

  /**
   * Gets the basic Cities information.
   *
   * @return basic Cities information as a JSONArray.
   */
  PageDTO<LocationDTO> getBasicCountiesInfo(int page, int[] range) throws IOException;

  /**
   * Gets a state information.
   *
   * @param countyId the county's Id
   * @param year the year for population data
   * @return a Map optional that contains the state's info if found, otherwise empty optional
   */
  Optional<Map> getCountyDetails(String countyId, String year);
}
