package edu.northeastern.truthtree.controller.basicInfo;

import static edu.northeastern.truthtree.AppConst.POPULATION_RANGE;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

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
  JSONArray getBasicStatesInfo(@RequestParam
      (value = POPULATION_RANGE, required = false)
      int[] range);

  /**
   * Gets basic Cities information.
   *
   * @return basic Cities information as a JSONArray string.
   */
  JSONArray getBasicCitiesInfo();

  /**
   * Gets basic Cities information.
   *
   * @return basic Cities information as a JSONArray string.
   */
  JSONArray getBasicCountiesInfo();
}
