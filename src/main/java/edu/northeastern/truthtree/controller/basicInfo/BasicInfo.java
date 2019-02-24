package edu.northeastern.truthtree.controller.basicInfo;

import static edu.northeastern.truthtree.AppConst.POPULATION_RANGE;

import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

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
   * @return JSONArray that contains states that are within the provided range.
   */
  @Override
  @RequestMapping(value = "/api/states", method = RequestMethod.GET)
  public JSONArray getBasicStatesInfo(@RequestParam
      (value = POPULATION_RANGE, required = false)
      int[] range) {

    return this.service.getBasicStatesInfo(range);
  }

  /**
   * Gets basic Cities information.
   *
   * @return basic Cities information as a JSONArray string.
   */
  @Override
  @RequestMapping(value = "/api/cities", method = RequestMethod.GET)
  public JSONArray getBasicCitiesInfo() {
    JSONArray response = this.service.getBasicCitiesInfo();
    return response;
  }

	/**
	 * Gets a state information
   *
	 * @param stateId the state's Id.
	 * @return the state's info in JSON object format with 200 status code, 404 if not found.
	 */
	@GetMapping(value = "/api/states/{stateId}")
	public ResponseEntity<Map> getStateDetails(
					@PathVariable String stateId,
					@RequestParam(value = "year", required = false) String year) {
		Optional<Map> stateDetailsOptional = this.service.getStateDetails(stateId, year);
		return stateDetailsOptional
						.map(stateDetails -> new ResponseEntity<>(stateDetails, HttpStatus.OK))
						.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Gets basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray string.
	 */
	@Override
	@RequestMapping(value = "/api/counties", method = RequestMethod.GET)
	public JSONArray getBasicCountiesInfo() {
		JSONArray response = this.service.getBasicCountiesInfo();
		return response;
	}

	/**
	 * Gets a county information
	 *
	 * @param countyId the state's Id.
	 * @return the state's info in JSON object format with 200 status code, 404 if not found.
	 */
	@GetMapping(value = "/api/counties/{countyId}")
	public ResponseEntity<Map> getCountyDetails(
					@PathVariable String countyId,
					@RequestParam(value = "year", required = false) String year) {
		Optional<Map> stateDetailsOptional = this.service.getCountyDetails(countyId, year);
		return stateDetailsOptional
						.map(countyDetails -> new ResponseEntity<>(countyDetails, HttpStatus.OK))
						.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Gets a city information
	 *
	 * @param cityId the state's Id.
	 * @param year the year for population data
	 * @return the state's info in JSON object format with 200 status code, 404 if not found.
	 */
	@GetMapping(value = "/api/cities/{cityId}")
	public ResponseEntity<Map> getCityDetails(
					@PathVariable String cityId,
					@RequestParam(value = "year", required = false) String year) {

		Optional<Map> cityDetailsOptional = this.service.getCityDetails(cityId, year);
		return cityDetailsOptional
						.map(cityDetails -> new ResponseEntity<>(cityDetails, HttpStatus.OK))
						.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
