package edu.northeastern.truthtree.service.basicInfo;

import org.json.simple.JSONArray;

import edu.northeastern.truthtree.adapter.basicInfo.BasicInfoDBAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.BasicInfoMockAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.adapter.collections.CollectionsMockAdapter;
import edu.northeastern.truthtree.adapter.collections.ICollectionAdapter;

public class BasicInfoService implements IBasicInfoService {

	@Override
	public JSONArray getBasicStatesInfo() {
		IBasicInfoAdapter adapter = new BasicInfoMockAdapter();
		return adapter.getBasicStatesInfo();
	}

	@Override
	public JSONArray getBasicCitiesInfo() {
		IBasicInfoAdapter adapter = new BasicInfoMockAdapter();
		return adapter.getBasicCitiesInfo();
	}

	@Override
	public JSONArray getBasicCountiesInfo() {
		IBasicInfoAdapter adapter = new BasicInfoMockAdapter();
		return adapter.getBasicCountiesInfo();
	}
}
