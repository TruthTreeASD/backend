package edu.northeastern.truthtree.service.advancedsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

import edu.northeastern.truthtree.adapter.advancedsearch.ISimilarLocationsAdapter;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;

import static edu.northeastern.truthtree.ErrorMessages.SIMILAR_LOCATIONS_ERROR;

@Component
public class SimilarLocationsService implements ISimilarLocationsService {

  private ISimilarLocationsAdapter adapter;

  @Autowired
  public SimilarLocationsService(@Qualifier("similarLocationsDBAdapter")
                                         ISimilarLocationsAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public List<CommonAttributeDTO> getSupportedAttributes() {
    return adapter.getSupportedAttributes();
  }

  @Override
  public List<LocationDTO> getSimilarLocations(int id,
                                               int placeType,
                                               List<Integer> attributes,
                                               int normalizeBy,
                                               List<Integer> year,
                                               Integer count) throws Exception {
    if (attributes.size() == 1) {
      if (year == null || year.size() < 2) {
        throw new Exception(SIMILAR_LOCATIONS_ERROR);
      }
    }
    return adapter.getSimilarLocations(id, placeType, attributes, normalizeBy, year, count);
  }
}
