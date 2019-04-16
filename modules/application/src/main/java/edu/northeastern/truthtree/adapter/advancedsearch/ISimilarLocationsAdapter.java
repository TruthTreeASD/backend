package edu.northeastern.truthtree.adapter.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;
import edu.northeastern.truthtree.enums.NormalizationType;

import java.util.List;

public interface ISimilarLocationsAdapter {

    List<CommonAttributeDTO> getSupportedAttributes();

    List<LocationDTO> getSimilarLocations(int id,
                                          int placeType,
                                          List<Integer> attributes,
                                          NormalizationType normalizeBy,
                                          List<Integer> year,
                                          Integer count);
    List<LocationDTO> getLocations(List<LocationDTO> locationDTOList);

}
