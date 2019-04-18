package edu.northeastern.truthtree.adapter.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;
import edu.northeastern.truthtree.enums.NormalizationType;

import java.util.List;

public interface ISimilarLocationsAdapter {

    /**
     * Returns the list of common attributes
     * for States, Cities and Counties
     * @return {@link List<CommonAttributeDTO>}
     */
    List<CommonAttributeDTO> getSupportedAttributes();

    /**
     * Returns the similar location(s)
     * based on given params
     * @param id - a location Id
     * @param placeType - a state(0), a city(1) or a county (2)
     * @param attributes - a list of single or multiple attribute Ids
     * @param normalizeBy - Population or Revenue
     * @param year - a single year or year range
     * @param count - by default, 10
     * @return {@link List<LocationDTO>}
     * @throws Exception
     */
    List<LocationDTO> getSimilarLocations(int id,
                                          int placeType,
                                          List<Integer> attributes,
                                          NormalizationType normalizeBy,
                                          List<Integer> year,
                                          Integer count);

    /**
     * Converts into a {@link List<LocationDTO>}
     * with lat/long values for each {@link LocationDTO}
     * for given param
     * @param locationDTOList
     * @return {@link List<LocationDTO>}
     */
    List<LocationDTO> getLocations(List<LocationDTO> locationDTOList);

}
