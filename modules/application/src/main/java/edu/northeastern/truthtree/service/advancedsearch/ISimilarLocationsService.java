package edu.northeastern.truthtree.service.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

import java.util.List;

public interface ISimilarLocationsService {

    List<CommonAttributeDTO> getSupportedAttributes();

    List<LocationDTO> getSimilarLocations(int id,
                                          int placeType,
                                          List<Integer> attributes,
                                          int normalizeBy,
                                          List<Integer> year,
                                          Integer count) throws Exception ;

}
