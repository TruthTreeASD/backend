package edu.northeastern.truthtree.adapter.advancedsearch;

import edu.northeastern.truthtree.enums.NormalizationType;
import org.springframework.stereotype.Component;

import java.util.List;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;

@Component("similarLocationsMockAdapter")
public class SimilarLocationsMockAdapter implements ISimilarLocationsAdapter {

  @Override
  public List<CommonAttributeDTO> getSupportedAttributes() {
    return null;
  }

  @Override
  public List<LocationDTO> getSimilarLocations(int id, int placeType, List<Integer> attributes,
                                               NormalizationType normalizeBy, List<Integer> year, Integer count) {
    return null;
  }
}
