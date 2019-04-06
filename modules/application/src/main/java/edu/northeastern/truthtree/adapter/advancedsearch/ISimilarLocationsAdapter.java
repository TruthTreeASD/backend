package edu.northeastern.truthtree.adapter.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

import java.util.List;

public interface ISimilarLocationsAdapter {

    List<CommonAttributeDTO> getSupportedAttributes();

    List<SimilarPlacesDTO> getSimilarLocations(int id,
                                               int placeType,
                                               List<Integer> attributes,
                                               int normalizeBy,
                                               List<Integer> year,
                                               Integer count);

}
