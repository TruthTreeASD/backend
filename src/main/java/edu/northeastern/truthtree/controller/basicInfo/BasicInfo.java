package edu.northeastern.truthtree.controller.basicInfo;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;

@RestController
@Component
public class BasicInfo implements IBasicInfo {
	private IBasicInfoService service;

	@Autowired
	public BasicInfo(IBasicInfoService service) {
		this.service = service;
	}

	@Override
	@RequestMapping("/api/states")
	public String getBasicStatesInfo() {
		JSONArray response = service.getBasicStatesInfo();
		return response.toJSONString();
	}

	@Override
	@RequestMapping("/api/cities")
	public String getBasicCitiesInfo() {
		JSONArray response = service.getBasicCitiesInfo();
		return response.toJSONString();
	}

	@Override
	@RequestMapping("/api/counties")
	public String getBasicCountiesInfo() {
		JSONArray response = service.getBasicCountiesInfo();
		return response.toJSONString();
	}
}
