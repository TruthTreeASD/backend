package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

/**
 * Represents the interface for the Basic Info Adapter.
 */
public interface IBasicInfoAdapter {


  /**
   * Gets the basic States information.
   *
   * @param year The year you want the population details for.
   * @return basic States information as a JSONArray.
   */
  JSONArray getBasicStatesInfo(int year);

  /**
   * Gets the basic States information for states that have a population within startValue and
   * endValue, inclusive.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  JSONArray getBasicStatesInfo(int startValue, int endValue, int year);

  /**
   * Gets the basic Cities information.
   *
   * @param year The year you want the population details for.
   * @return basic Cities information as a JSONArray.
   */
  JSONArray getBasicCitiesInfo(int year);

  /**
   * Gets the basic Cities information for cities that have a population within startValue and
   * endValue, inclusive.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  JSONArray getBasicCitiesInfo(int startValue, int endValue, int year);


  /**
   * Gets the basic Counties information.
   *
   * @param year The year you want the population details for.
   * @return basic Counties information as a JSONArray.
   */
  JSONArray getBasicCountiesInfo(int year);

  /**
   * Gets the basic Counties information for counties that have a population within startValue and
   * endValue, inclusive.
   *
   * @param startValue The value that all wanted values will be greater than or equal to.
   * @param endValue The value that all wanted values will be less than or equal to.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  JSONArray getBasicCountiesInfo(int startValue, int endValue, int year);

}
