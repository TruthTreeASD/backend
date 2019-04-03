package edu.northeastern.truthtree.controller.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;
import edu.northeastern.truthtree.service.advancedsearch.ISimilarLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
public class SimilarLocations implements ISimilarLocations {

    private ISimilarLocationsService service;

    @Autowired
    public SimilarLocations(ISimilarLocationsService service) {
        this.service = service;
    }

    @Override
    @RequestMapping(value = "/api/similarlocations/attributes", method = RequestMethod.GET)
    public List<CommonAttributeDTO> getAttributes() {
        return service.getSupportedAttributes();
    }

    @Override
    @RequestMapping(value = "/api/similarlocations", method = RequestMethod.GET)
    public List<SimilarPlacesDTO> getSimilarLocations(@RequestParam(name = "id", required = true) String id,
                                                      @RequestParam(name = "place_type", required = true)
                                                              String placeType,
                                                      @RequestParam(name = "attribute", required = true)
                                                              List<Integer> attributes,
                                                      @RequestParam(name = "normalize_by", required = true)
                                                              String normalizeBy,
                                                      @RequestParam List<String> year,
                                                      @RequestParam(name = "count", required = false) String count) {
        return service.getSimilarLocations(id, placeType, attributes, normalizeBy, year, count);
    }

}
