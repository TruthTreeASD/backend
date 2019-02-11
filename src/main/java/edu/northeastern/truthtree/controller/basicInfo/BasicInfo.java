package edu.northeastern.truthtree.controller.basicInfo;

import static edu.northeastern.truthtree.ErrorMessages.POPULATION_ERROR;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;

@RestController
@Component
@CrossOrigin(origins = "*", maxAge = 3600)
public class BasicInfo implements IBasicInfo {
	private IBasicInfoService service;

	static final String POPULATION_RANGE = "populationRange";

	@Autowired
	public BasicInfo(IBasicInfoService service) {
		this.service = service;
	}

	/**
	 * Gets basic States information for states that have a population within
	 * startValue and endValue, inclusive.
	 *
	 * @param range
	 *            The start and end values that will be used to filter the states
	 *            returned.
	 * @return JSONArray that contains states that are within the provided range.
	 */
	@Override
	@RequestMapping(value = "/api/states", params = POPULATION_RANGE, method = RequestMethod.GET)
	public String getBasicStatesPopulationRange(@RequestParam(POPULATION_RANGE) int[] range) {

		if (range.length == 2 && range[0] <= range[1]) {
			JSONArray response = this.service.getBasicStatesPopulationRange(range[0], range[1]);
			return response.toJSONString();
		}

		return POPULATION_ERROR;
	}

	/**
	 * Gets basic States information.
	 *
	 * @return basic States information as a JSONArray string.
	 */
	@Override
	@RequestMapping(value = "/api/states", method = RequestMethod.GET)
	public String getBasicStatesInfo() {
		JSONArray response = this.service.getBasicStatesInfo();
		return response.toJSONString();
	}

	/**
	 * Gets basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray string.
	 */
	@Override
	@RequestMapping(value = "/api/cities", method = RequestMethod.GET)
	public String getBasicCitiesInfo() {
		JSONArray response = this.service.getBasicCitiesInfo();
		return response.toJSONString();
	}

	/**
	 * Gets basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray string.
	 */
	@Override
	@RequestMapping(value = "/api/counties", method = RequestMethod.GET)
	public String getBasicCountiesInfo() {
		JSONArray response = this.service.getBasicCountiesInfo();
		return response.toJSONString();
	}
}
