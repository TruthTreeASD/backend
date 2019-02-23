package edu.northeastern.truthtree.controller.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;

import static edu.northeastern.truthtree.AppConst.POPULATION_RANGE;

/**
 * Represents the Basic Info methods used create a REST controller.
 */
@RestController
@Component
@CrossOrigin(origins = "*", maxAge = 3600)
public class BasicInfo implements IBasicInfo {

  private IBasicInfoService service;

  /**
   * Creates a new instance of BasicInfo when given an IBasicInfoService.
   *
   * @param service the instance service.
   */
  @Autowired
  public BasicInfo(IBasicInfoService service) {
    this.service = service;
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
  @RequestMapping(value = "/api/states", method = RequestMethod.GET)
  public JSONArray getBasicStatesInfo(
      @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
      @RequestParam(value = "year", required = false) int year) {
    return this.service.getBasicStatesInfo(range, year);
  }

  /**
   * Gets basic cities information for cities. If a population range is supplied, the results will
   * be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains cities that are within the provided range.
   */
  @Override
  @RequestMapping(value = "/api/cities", method = RequestMethod.GET)
  public JSONArray getBasicCitiesInfo(
      @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
      @RequestParam(value = "year", required = false) int year) {
    return this.service.getBasicCitiesInfo(range, year);
  }

  /**
   * Gets basic counties information for counties. If a population range is supplied, the results
   * will be filtered to those that have a population within startValue and endValue, inclusive.
   *
   * @param range The start and end values that will be used to filter the states returned.
   * @param year The year you want the population details for.
   * @return JSONArray that contains counties that are within the provided range.
   */
  @Override
  @RequestMapping(value = "/api/counties", method = RequestMethod.GET)
  public JSONArray getBasicCountiesInfo(
      @RequestParam(value = POPULATION_RANGE, required = false) int[] range,
      @RequestParam(value = "year", required = false) int year) {
    return this.service.getBasicCountiesInfo(range, year);
  }
}
