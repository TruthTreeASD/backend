package edu.northeastern.truthtree.controller.basicInfo;

import org.json.simple.JSONArray;
<<<<<<< HEAD
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
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.basicInfo.BasicInfoService;
import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;
import edu.northeastern.truthtree.service.collections.CollectionsService;
import edu.northeastern.truthtree.service.collections.ICollectionsService;

@RestController
public class BasicInfo implements IBasicInfo {
>>>>>>> 78f6e71659a0ee4fb6442d3f1da10b1d6bb1d20f

	@Override
	@RequestMapping("/api/states")
	public String getBasicStatesInfo() {
<<<<<<< HEAD
=======
		IBasicInfoService service = new BasicInfoService();
>>>>>>> 78f6e71659a0ee4fb6442d3f1da10b1d6bb1d20f
		JSONArray response = service.getBasicStatesInfo();
		return response.toJSONString();
	}

	@Override
	@RequestMapping("/api/cities")
	public String getBasicCitiesInfo() {
<<<<<<< HEAD
=======
		IBasicInfoService service = new BasicInfoService();
>>>>>>> 78f6e71659a0ee4fb6442d3f1da10b1d6bb1d20f
		JSONArray response = service.getBasicCitiesInfo();
		return response.toJSONString();
	}

	@Override
	@RequestMapping("/api/counties")
	public String getBasicCountiesInfo() {
<<<<<<< HEAD
=======
		IBasicInfoService service = new BasicInfoService();
>>>>>>> 78f6e71659a0ee4fb6442d3f1da10b1d6bb1d20f
		JSONArray response = service.getBasicCountiesInfo();
		return response.toJSONString();
	}
}
