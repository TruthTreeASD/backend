package edu.northeastern.truthtree.service.advancedsearch;

import edu.northeastern.truthtree.adapter.advancedsearch.ISimilarLocationsAdapter;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimilarLocationsService implements ISimilarLocationsService {

    private ISimilarLocationsAdapter adapter;

    @Autowired
    public SimilarLocationsService(ISimilarLocationsAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public List<CommonAttributeDTO> getSupportedAttributes() {
        return adapter.getSupportedAttributes();
    }

    @Override
    public List<SimilarPlacesDTO> getSimilarLocations(String id,
                                                      String placeType,
                                                      List<Integer> attributes,
                                                      String normalizeBy,
                                                      List<String> year,
                                                      String count) {
        return adapter.getSimilarLocations(id, placeType, attributes, normalizeBy, year, count);
    }
}
