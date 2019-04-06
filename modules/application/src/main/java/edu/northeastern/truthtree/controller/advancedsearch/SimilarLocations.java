package edu.northeastern.truthtree.controller.advancedsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;
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
  public List<SimilarPlacesDTO> getSimilarLocations(@RequestParam(name = "id", required = true) int id,
                                                    @RequestParam(name = "place_type", required = true)
                                                            int placeType,
                                                    @RequestParam(name = "attribute", required = true)
                                                            List<Integer> attributes,
                                                    @RequestParam(name = "normalize_by", required = true)
                                                            int normalizeBy,
                                                    @RequestParam(name = "year", required = false) List<Integer> year,
                                                    @RequestParam(name = "count", required = false) Integer count,
                                                    HttpServletResponse response) throws Exception {

    List<SimilarPlacesDTO> serviceResponse = null;
    try{
      serviceResponse = service.getSimilarLocations(id, placeType, attributes, normalizeBy, year, count);
    } catch (Exception e){
      response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
    }
    return serviceResponse;
  }

}
