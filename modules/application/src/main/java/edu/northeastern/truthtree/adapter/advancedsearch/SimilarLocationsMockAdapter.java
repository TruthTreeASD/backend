package edu.northeastern.truthtree.adapter.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.enums.NormalizationType;
import java.util.List;
import org.springframework.stereotype.Component;

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

  @Override
  public List<LocationDTO> getLocations(List<LocationDTO> locationDTOList) {
    return null;
  }
}
