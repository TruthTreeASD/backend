package edu.northeastern.truthtree.service.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

import java.util.List;

public interface ISimilarLocationsService {

    List<CommonAttributeDTO> getSupportedAttributes();

    List<SimilarPlacesDTO> getSimilarLocations(String id,
                                               String placeType,
                                               List<Integer> attributes,
                                               String normalizeBy,
                                               List<String> year,
                                               String count);

}
