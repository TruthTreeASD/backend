package edu.northeastern.truthtree.service.basicInfo;

import edu.northeastern.truthtree.ErrorMessages;
import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.PageDTO;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
  public PageDTO<LocationDTO> getBasicStatesInfo(int page, int[] range)
          throws IOException, IllegalArgumentException {
    if (range != null) {
      if (range.length == 2 && range[0] <= range[1]) {
        return this.adapter.getBasicStatesInfo(page, range[0], range[1]);
      }
      throw new IllegalArgumentException(ErrorMessages.POPULATION_ERROR);
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
  public PageDTO<LocationDTO> getBasicCitiesInfo(int page, int[] range) throws IOException {
    if (range != null) {
      if (range.length == 2 && range[0] <= range[1]) {
        return this.adapter.getBasicCitiesInfo(page, range[0], range[1]);
      }
      throw new IllegalArgumentException(ErrorMessages.POPULATION_ERROR);
    }

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
  public PageDTO<LocationDTO> getBasicCountiesInfo(int page, int[] range) throws IOException {
    if (range != null) {
      if (range.length == 2 && range[0] <= range[1]) {
        return this.adapter.getBasicCountiesInfo(page, range[0], range[1]);
      }
      throw new IllegalArgumentException(ErrorMessages.POPULATION_ERROR);
    }

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
