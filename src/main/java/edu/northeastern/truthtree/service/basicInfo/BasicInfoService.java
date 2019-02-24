package edu.northeastern.truthtree.service.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static edu.northeastern.truthtree.ErrorMessages.POPULATION_ERROR;

import java.util.Map;
import java.util.Optional;

import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

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
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  public JSONArray getBasicStatesInfo(int[] range) {

    if (range != null) {
      if (range.length == 2 && range[0] <= range[1]) {
        return this.adapter.getBasicStatesInfo(range[0], range[1]);
      }
      return JSONUtil.createErrorMessage(POPULATION_ERROR);
    }

    return this.adapter.getBasicStatesInfo();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Map> getStateDetails(String stateId, String year) {
    return this.adapter.getStateDetails(stateId, year);
  }

  /**
   * Gets the basic Cities information.
   *
   * @return basic Cities information as a JSONArray.
   */
  @Override
  public JSONArray getBasicCitiesInfo() {
    return this.adapter.getBasicCitiesInfo();
  }

  /**
   *  {@inheritDoc}
   */
  @Override
  public Optional<Map> getCityDetails(String cityId, String year) {
    return this.adapter.getCityDetails(cityId, year);
  }


  /**
   * Gets the basic Cities information.
   *
   * @return basic Cities information as a JSONArray.
   */
  @Override
  public JSONArray getBasicCountiesInfo() {
    return this.adapter.getBasicCountiesInfo();
  }

  /**
   *  {@inheritDoc}
   */
  @Override
  public Optional<Map> getCountyDetails(String countyId, String year) {
    return this.adapter.getCountyDetails(countyId, year);
  }
}
