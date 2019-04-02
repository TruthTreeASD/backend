package edu.northeastern.truthtree.controller.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.service.advancedsearch.commonattributes.ISupportedAttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
public class SimilarLocations implements ISimilarLocations {

    private ISupportedAttributesService service;

    @Autowired
    public SimilarLocations(ISupportedAttributesService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/api/similarlocations/attributes", method = RequestMethod.GET)
    public List<CommonAttributeDTO> getAttributes() {
        return service.getSupportedAttributes();
    }
}
