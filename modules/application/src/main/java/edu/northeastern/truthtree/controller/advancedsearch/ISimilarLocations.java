package edu.northeastern.truthtree.controller.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

import java.util.List;

public interface ISimilarLocations {

    List<CommonAttributeDTO> getAttributes();

    List<SimilarPlacesDTO> getSimilarLocations(String id,
                                               String placeType,
                                               List<Integer> attributes,
                                               String normalizeBy,
                                               List<String> year,
                                               String count);
}