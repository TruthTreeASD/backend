package edu.northeastern.truthtree.controller.attributes;

import edu.northeastern.truthtree.service.attributes.IAttributesService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class Attributes implements IAttributes{
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
