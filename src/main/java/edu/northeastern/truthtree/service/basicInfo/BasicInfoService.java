package edu.northeastern.truthtree.service.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

import static edu.northeastern.truthtree.ErrorMessages.POPULATION_ERROR;

@Component
public class BasicInfoService implements IBasicInfoService {
	private IBasicInfoAdapter adapter;

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
	 * Gets the basic Cities information.
	 *
	 * @return basic Cities information as a JSONArray.
	 */
	@Override
	public JSONArray getBasicCitiesInfo() {
		return this.adapter.getBasicCitiesInfo();
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
}
