package edu.northeastern.truthtree.service.basicInfo;

import org.json.simple.JSONArray;

public interface IBasicInfoService {

	/**
	 * Gets basic States information for states. If a population range is supplied, the results will
	 * be filtered to those that have a population within startValue and endValue, inclusive.
	 *
	 * @param range The start and end values that will be used to filter the states returned.
	 * @return JSONArray that contains states that are within the provided range.
	 */
	JSONArray getBasicStatesInfo(int[] range);

	/**
	 * Gets the basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray.
	 */
	JSONArray getBasicCitiesInfo();

	/**
	 * Gets the basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray.
	 */
	JSONArray getBasicCountiesInfo();
}
