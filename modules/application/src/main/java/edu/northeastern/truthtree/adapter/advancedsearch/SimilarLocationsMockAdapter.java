package edu.northeastern.truthtree.adapter.advancedsearch;

import org.springframework.stereotype.Component;

import java.util.List;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

@Component("similarLocationsMockAdapter")
public class SimilarLocationsMockAdapter implements ISimilarLocationsAdapter {

  @Override
  public List<CommonAttributeDTO> getSupportedAttributes() {
    return null;
  }

  @Override
  public List<SimilarPlacesDTO> getSimilarLocations(int id, int placeType, List<Integer> attributes,
                                                    int normalizeBy, List<Integer> year, Integer count) {
    return null;
  }
}
