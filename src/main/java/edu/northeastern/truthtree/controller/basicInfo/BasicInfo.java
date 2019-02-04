package edu.northeastern.truthtree.controller.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.basicInfo.BasicInfoService;
import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;
import edu.northeastern.truthtree.service.collections.CollectionsService;
import edu.northeastern.truthtree.service.collections.ICollectionsService;

@RestController
public class BasicInfo implements IBasicInfo {

	@Override
	@RequestMapping("/api/states")
	public String getBasicStatesInfo() {
		IBasicInfoService service = new BasicInfoService();
		JSONArray response = service.getBasicStatesInfo();
		return response.toJSONString();
	}

	@Override
	@RequestMapping("/api/cities")
	public String getBasicCitiesInfo() {
		IBasicInfoService service = new BasicInfoService();
		JSONArray response = service.getBasicCitiesInfo();
		return response.toJSONString();
	}

	@Override
	@RequestMapping("/api/counties")
	public String getBasicCountiesInfo() {
		IBasicInfoService service = new BasicInfoService();
		JSONArray response = service.getBasicCountiesInfo();
		return response.toJSONString();
	}
}
