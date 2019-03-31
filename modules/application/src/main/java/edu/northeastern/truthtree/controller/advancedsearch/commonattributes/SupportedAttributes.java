package edu.northeastern.truthtree.controller.advancedsearch.commonattributes;

import edu.northeastern.truthtree.service.advancedsearch.commonattributes.ISupportedAttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SupportedAttributes implements ISupportedAttributes {

    private ISupportedAttributesService service;

    @Autowired
    public SupportedAttributes(ISupportedAttributesService service) {
        this.service = service;
    }

    @RequestMapping(value = "/api/similar/supported", method = RequestMethod.GET)
    public Object getSupportedAttributes() {
        return service.getSupportedAttributes("");
    }

    @RequestMapping(value = "/api/similar/supported/{place_type}", method = RequestMethod.GET)
    public Object getSupportedAttributes(@PathVariable("place_type") String placeType) {
        return service.getSupportedAttributes(placeType);
    }
}
