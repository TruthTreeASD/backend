package edu.northeastern.truthtree.service.advancedsearch;

import static edu.northeastern.truthtree.ErrorMessages.SIMILAR_LOCATIONS_ERROR;

import edu.northeastern.truthtree.adapter.advancedsearch.ISimilarLocationsAdapter;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.enums.NormalizationType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SimilarLocationsService implements ISimilarLocationsService {

  private ISimilarLocationsAdapter adapter;

  @Autowired
  public SimilarLocationsService(@Qualifier("similarLocationsDBAdapter")
                                         ISimilarLocationsAdapter adapter) {
    this.adapter = adapter;
  }

  /**
   * Returns the list of common attributes
   * for States, Cities and Counties
   * @return {@link List<CommonAttributeDTO>}
   */
  @Override
  public List<CommonAttributeDTO> getSupportedAttributes() {
    return adapter.getSupportedAttributes();
  }

  /**
   * Returns the similar location(s)
   * based on given params
   * @param id - a location Id
   * @param placeType - a state(0), a city(1) or a county (2)
   * @param attributes - a list of single or multiple attribute Ids
   * @param normalizationType - {@link NormalizationType - Population or Revenue}
   * @param year - a single year or year range
   * @param count - by default, 10
   * @return {@link List<LocationDTO>}
   * @throws Exception
   */
  @Override
  public List<LocationDTO> getSimilarLocations(int id,
                                               int placeType,
                                               List<Integer> attributes,
                                               NormalizationType normalizationType,
                                               List<Integer> year,
                                               Integer count) throws Exception {
    if (attributes.size() == 1) {
      if (year == null || year.size() < 2) {
        throw new Exception(SIMILAR_LOCATIONS_ERROR);
      }
    }
    List<LocationDTO> response = adapter.getSimilarLocations(id, placeType, attributes, normalizationType, year, count);
    return adapter.getLocations(response);
  }
}
