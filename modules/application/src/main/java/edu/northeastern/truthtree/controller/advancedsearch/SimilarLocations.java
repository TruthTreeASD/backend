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
  public List<LocationDTO> getSimilarLocations(@RequestParam(name = "id") int locationId,
                                               @RequestParam(name = "place_type")
                                                       int placeType,
                                               @RequestParam(name = "attribute")
                                                       List<Integer> attributes,
                                               @RequestParam(name = "normalize_by")
                                                       NormalizationType normalizeBy,
                                               @RequestParam(name = "year", required = false) List<Integer> year,
                                               @RequestParam(name = "count", required = false) Integer count,
                                               HttpServletResponse response) throws Exception {

    List<LocationDTO> serviceResponse = null;
    try {
      serviceResponse = service.getSimilarLocations(locationId, placeType, attributes, normalizeBy, year, count);
    } catch (Exception e) {
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
    }
    return serviceResponse;
  }
}
