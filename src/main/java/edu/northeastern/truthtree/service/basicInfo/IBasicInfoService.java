package edu.northeastern.truthtree.service.basicInfo;

import org.json.simple.JSONArray;

/**
 * Represents the Basic Info Service interface.
 */
public interface IBasicInfoService {

  /**
   * Gets basic States information for states. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  JSONArray getBasicStatesInfo(int[] range, int year);

  /**
   * Gets basic Cities information for cities. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains cities that are within the provided range.
   */
  JSONArray getBasicCitiesInfo(int[] range, int year);

  /**
   * Gets basic counties information for counties. If a population range is supplied, the results
   * will be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains counties that are within the provided range.
   */
  JSONArray getBasicCountiesInfo(int[] range, int year);
}
