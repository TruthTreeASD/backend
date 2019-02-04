package edu.northeastern.truthtree.service.basicInfo;

import org.json.simple.JSONArray;

public interface IBasicInfoService {
	JSONArray getBasicStatesInfo();

	JSONArray getBasicCitiesInfo();

	JSONArray getBasicCountiesInfo();
}
