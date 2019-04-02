package edu.northeastern.truthtree.controller.advancedsearch.similarityby.singleattribute;

import edu.northeastern.truthtree.dto.SingleAttributePayloadDTO;
import edu.northeastern.truthtree.service.advancedsearch.similarityby.singleattribute.ISimilarityByAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SimilarityByAttribute implements ISimilarityByAttribute {

    private ISimilarityByAttributeService service;

    @Autowired
    public SimilarityByAttribute(ISimilarityByAttributeService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/api/similar/single", method = RequestMethod.POST)
    public Object getSimilarity(@RequestBody SingleAttributePayloadDTO payload) {
        return service.getSimilarity(payload);
    }
}
