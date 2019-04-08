package edu.northeastern.truthtree.controller.advancedsearch;

import edu.northeastern.truthtree.enums.LocationType;
import edu.northeastern.truthtree.enums.NormalizationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.service.advancedsearch.ISimilarLocationsService;

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
  public List<LocationDTO> getSimilarLocations(@RequestParam(name = "id") int id,
                                               @RequestParam(name = "place_type")
                                                       int placeType,
                                               @RequestParam(name = "attribute")
                                                       List<Integer> attributes,
                                               @RequestParam(name = "normalize_by")
                                                       String normalizeBy,
                                               @RequestParam(name = "year", required = false) List<Integer> year,
                                               @RequestParam(name = "count", required = false) Integer count,
                                               HttpServletResponse response) throws Exception {

    List<LocationDTO> serviceResponse = null;
    try {
      NormalizationType normalizationType = setNormalizationType(normalizeBy);
      serviceResponse = service.getSimilarLocations(id, placeType, attributes, normalizationType, year, count);
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
    }
    return serviceResponse;
  }

  private NormalizationType setNormalizationType(String normalizeBy) {
    NormalizationType normalizationType = null;
    switch(normalizeBy.toLowerCase()) {
      case "gross":
        normalizationType.setType("Gross");
        normalizationType.setValue(0);
        break;
      case "per_capita":
        normalizationType.setType("Per Capita");
        normalizationType.setValue(1);
        break;
      case "by_revenue":
        normalizationType.setType("By Revenue");
        normalizationType.setValue(2);
        break;
      default:
        break;
    }
    return normalizationType;
  }

//  private LocationType setPlaceType(String placeType) {
//    LocationType locationType = null;
//    switch (placeType) {
//      case "state":
//
//    }
//  }
}
