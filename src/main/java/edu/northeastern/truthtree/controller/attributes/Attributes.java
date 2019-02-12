package edu.northeastern.truthtree.controller.attributes;

import edu.northeastern.truthtree.service.attributes.IAttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value = "/api/attributes", method = RequestMethod.GET)
    public ResponseEntity<Object> getAttributes(@RequestParam(value = "locationIds", required = false) List<Integer> locations,
                                                    @RequestParam(value = "collectionIds", required = false) List<Integer> collections,
                                                    @RequestParam(value = "propertyIds", required = false) List<Integer> properties,
                                                    @RequestParam(value = "attributeIds", required = false) List<Integer> attributes,
                                                    @RequestParam(value = "yearRange", required = false) List<Integer> yearRange,
                                                    @RequestParam(value = "yearList", required = false) List<Integer> yearList) {
        Object response = service.getAttributes(locations, collections, properties, attributes, yearRange, yearList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
