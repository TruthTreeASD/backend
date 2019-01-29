package edu.northeastern.truthtree.controller.collections;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.collections.CollectionsService;
import edu.northeastern.truthtree.service.collections.ICollectionsService;

@RestController
public class Collections implements ICollections {

	@Override
	@RequestMapping("/api/collections")
	public String getCollections() {
		ICollectionsService service = new CollectionsService();
		JSONArray response = service.getCollections();
		return response.toJSONString();
	}
}
