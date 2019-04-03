package edu.northeastern.truthtree.adapter.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

import java.util.List;

public class SimilarLocationsMockAdapter implements ISimilarLocationsAdapter {

    @Override
    public List<CommonAttributeDTO> getSupportedAttributes() {
        return null;
    }

    @Override
    public List<SimilarPlacesDTO> getSimilarLocations(String id, String placeType, List<Integer> attributes, String normalizeBy, List<String> year, String count) {
        return null;
    }
}
