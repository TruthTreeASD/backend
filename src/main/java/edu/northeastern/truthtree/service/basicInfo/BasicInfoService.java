package edu.northeastern.truthtree.service.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

import static edu.northeastern.truthtree.ErrorMessages.POPULATION_ERROR;

/**
 * Represents the Basic Info Service.
 */
@Component
public class BasicInfoService implements IBasicInfoService {

  private IBasicInfoAdapter adapter;

  /**
   * Creates a new instance of BasicInfoService when given an IBasicInfoAdapter.
   *
   * @param adapter the instance adapter.
   */
  @Autowired
  public BasicInfoService(IBasicInfoAdapter adapter) {
    this.adapter = adapter;
  }

  /**
   * Gets basic States information for states. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicStatesInfo(int[] range, int year) {

    if (range != null) {
      if (range.length == 2 && range[0] <= range[1]) {
        return this.adapter.getBasicStatesInfo(range[0], range[1], year);
      }
      return JSONUtil.createErrorMessage(POPULATION_ERROR);
    }

    return this.adapter.getBasicStatesInfo(year);
  }

  /**
   * Gets basic Cities information for cities. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains cities that are within the provided range.
   */
  @Override
  public JSONArray getBasicCitiesInfo(int[] range, int year) {
    if (range != null) {
      if (range.length == 2 && range[0] <= range[1]) {
        return this.adapter.getBasicStatesInfo(range[0], range[1], year);
      }
      return JSONUtil.createErrorMessage(POPULATION_ERROR);
    }
    return this.adapter.getBasicCitiesInfo(year);
  }

  /**
   * Gets basic counties information for counties. If a population range is supplied, the results
   * will be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the counties returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains counties that are within the provided range.
   */
  @Override
  public JSONArray getBasicCountiesInfo(int[] range, int year) {
    if (range != null) {
      if (range.length == 2 && range[0] <= range[1]) {
        return this.adapter.getBasicStatesInfo(range[0], range[1], year);
      }
      return JSONUtil.createErrorMessage(POPULATION_ERROR);
    }
    return this.adapter.getBasicCountiesInfo(year);
  }
}
