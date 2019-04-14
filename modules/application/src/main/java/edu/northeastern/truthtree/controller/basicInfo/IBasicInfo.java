package edu.northeastern.truthtree.controller.basicInfo;

import static edu.northeastern.truthtree.AppConst.POPULATION_RANGE;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.PageDTO;

/**
 * Represents the Basic Info interface used to implement the REST controller.
 */
public interface IBasicInfo {

  /**
   * Gets basic States information for states. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @return JSONArray that contains states that are within the provided range.
   */
  ResponseEntity<PageDTO<LocationDTO>> getBasicStatesInfo(
          @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
          @RequestParam(name = "currentPage", defaultValue = "1") int page) throws IOException;

  /**
   * Gets basic Cities information.
   *
   * @return basic Cities information as a JSONArray string.
   */
  ResponseEntity<PageDTO<LocationDTO>> getBasicCitiesInfo(
          @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
          @RequestParam(name = "currentPage", defaultValue = "1") int page) throws IOException;

  /**
   * Gets basic Cities information.
   *
   * @return basic Cities information as a JSONArray string.
   */
  ResponseEntity<PageDTO<LocationDTO>> getBasicCountiesInfo(
          @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
          @RequestParam(name = "currentPage", defaultValue = "1") int page) throws IOException;
}
