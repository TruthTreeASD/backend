package edu.northeastern.truthtree.controller.basicInfo;

import java.util.List;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

import static edu.northeastern.truthtree.AppConst.POPULATION_RANGE;

/**
 * Represents the Basic Info interface used to implement the REST controller.
 */
public interface IBasicInfo {

  /**
   * Gets basic States information for states. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  JSONArray getBasicStatesInfo(
      @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
      @RequestParam(value = "year", required = false) int year);

  /**
   * Gets basic cities information for cities. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains cities that are within the provided range.
   */
  JSONArray getBasicCitiesInfo(
      @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
      @RequestParam(value = "year", required = false) int year);

  /**
   * Gets basic counties information for counties. If a population range is supplied, the results
   * will be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains counties that are within the provided range.
   */
  JSONArray getBasicCountiesInfo(
      @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
      @RequestParam(value = "year", required = false) int year);
}
