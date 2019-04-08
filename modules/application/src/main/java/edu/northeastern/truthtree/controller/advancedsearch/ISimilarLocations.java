package edu.northeastern.truthtree.controller.advancedsearch;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.enums.LocationType;
import edu.northeastern.truthtree.enums.NormalizationType;

public interface ISimilarLocations {

  List<CommonAttributeDTO> getAttributes();

  List<LocationDTO> getSimilarLocations(int locationId,
                                        int placeType,
                                        List<Integer> attributes,
                                        NormalizationType normalizeBy,
                                        List<Integer> year,
                                        Integer count, HttpServletResponse response) throws Exception;
}
