package edu.northeastern.truthtree.controller.collections;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.collections.ICollectionsService;

@RestController
public class Collections implements ICollections {
	private ICollectionsService service;

	@Autowired
	public Collections(ICollectionsService service) {
		this.service = service;
	}

	@Override
	@RequestMapping("/api/collections")
	public String getCollections() {
		JSONArray response = service.getCollections();
		return response.toJSONString();
	}
}
