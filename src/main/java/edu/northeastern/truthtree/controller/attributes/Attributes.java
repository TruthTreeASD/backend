package edu.northeastern.truthtree.controller.attributes;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.attributes.IAttributesService;

@RestController
@Component
@CrossOrigin(origins = "*", maxAge = 3600)
public class Attributes implements IAttributes {
	private IAttributesService service;

	@Autowired
	public Attributes(IAttributesService service) {
		this.service = service;
	}

	@Override
	@RequestMapping("/api/attributes")
	public String getAttributes() {
		JSONArray response = service.getAttributes();
		return response.toJSONString();
	}
}
