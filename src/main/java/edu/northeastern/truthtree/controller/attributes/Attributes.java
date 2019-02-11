package edu.northeastern.truthtree.controller.attributes;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.attributes.IAttributesService;

import java.util.List;

@RestController
@Component
public class Attributes implements IAttributes{
    private IAttributesService service;

    @Autowired
    public Attributes(IAttributesService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/api/attributes", method = RequestMethod.GET)
    public ResponseEntity<Object> getAttributes(@RequestParam(value = "locations", required = false) List<Integer> locations,
                                                    @RequestParam(value = "collection", required = false) List<Integer> collections,
                                                    @RequestParam(value = "property", required = false) List<Integer> properties,
                                                    @RequestParam(value = "attributes", required = false) List<Integer> attributes,
                                                    @RequestParam(value = "yearRange", required = false) List<Integer> yearRange,
                                                    @RequestParam(value = "yearList", required = false) List<Integer> yearList) {
        Object response = service.getAttributes(locations, collections, properties, attributes, yearRange, yearList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
