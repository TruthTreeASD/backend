package edu.northeastern.truthtree.adapter.basicInfo;

import org.json.simple.JSONArray;

public interface IBasicInfoAdapter {

	JSONArray getBasicStatesInfo();

	JSONArray getBasicCitiesInfo();

	JSONArray getBasicCountiesInfo();
}
