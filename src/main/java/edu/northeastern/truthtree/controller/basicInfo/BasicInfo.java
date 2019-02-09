package edu.northeastern.truthtree.controller.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;

@RestController
@Component
public class BasicInfo implements IBasicInfo {
	private IBasicInfoService service;

	private static final String POPULATION_ERROR = "ERROR: The supplied parameters were incorrect. " +
			"Please provide exactly two values in the format /api/states?populationRange=startValue," +
			"endValue";
	static final String POPULATION_RANGE = "populationRange";

	@Autowired
	public BasicInfo(IBasicInfoService service) {
		this.service = service;
	}

	/**
	 * Gets basic States information.
	 *
	 * @return basic States information as a JSONArray string.
	 */
	@Override
	@RequestMapping("/api/states")
	public String getBasicStatesInfo() {
		JSONArray response = this.service.getBasicStatesInfo();
		return response.toJSONString();
	}

	/**
	 * Gets basic States information for states that have a population within startValue and
	 * endValue, inclusive.
	 *
	 * @param range The start and end values that will be used to filter the states returned.
	 * @return JSONArray that contains states that are within the provided range.
	 */
	@Override
	@RequestMapping(value = "/api/states", params = POPULATION_RANGE)
	public String getBasicStatesPopulationRange(@RequestParam(POPULATION_RANGE) int[] range) {

		if (range.length == 2) {
			JSONArray response = this.service.getBasicStatesPopulationRange(range[0], range[1]);
			return response.toJSONString();
		}

		return POPULATION_ERROR;
	}

	/**
	 * Gets basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray string.
	 */
	@Override
	@RequestMapping("/api/cities")
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
	@RequestMapping("/api/counties")
	public String getBasicCountiesInfo() {
		JSONArray response = this.service.getBasicCountiesInfo();
		return response.toJSONString();
	}
}
