package edu.northeastern.truthtree.service.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;

@Component
public class BasicInfoService implements IBasicInfoService {
	private IBasicInfoAdapter adapter;

	@Autowired
	public BasicInfoService(IBasicInfoAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public JSONArray getBasicStatesInfo() {
		return this.adapter.getBasicStatesInfo();
	}

	@Override
	public JSONArray getBasicStatesPopulationRange(int startValue, int endValue) {
		return this.adapter.getBasicStatesPopulationRange(startValue, endValue);
	}

	@Override
	public JSONArray getBasicCitiesInfo() {
		return this.adapter.getBasicCitiesInfo();
	}

	@Override
	public JSONArray getBasicCountiesInfo() {
		return this.adapter.getBasicCountiesInfo();
	}
}
