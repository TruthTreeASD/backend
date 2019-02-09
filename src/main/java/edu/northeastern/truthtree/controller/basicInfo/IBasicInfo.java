package edu.northeastern.truthtree.controller.basicInfo;

import org.springframework.web.bind.annotation.RequestParam;

import static edu.northeastern.truthtree.controller.basicInfo.BasicInfo.POPULATION_RANGE;

public interface IBasicInfo {

	/**
	 * Gets basic States information.
	 *
	 * @return basic States information as a JSONArray string.
	 */
	String getBasicStatesInfo();

	/**
	 * Gets basic States information for states that have a population within range, inclusive.
	 *
	 * @param range The population range that will be used to filter the states returned. Must be in
	 *              the format =val1,val2
	 * @return JSONArray that contains states that are within the provided range.
	 */
	String getBasicStatesPopulationRange(@RequestParam(POPULATION_RANGE) int[] range);

	/**
	 * Gets basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray string.
	 */
	String getBasicCitiesInfo();

	/**
	 * Gets basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray string.
	 */
	String getBasicCountiesInfo();
}
