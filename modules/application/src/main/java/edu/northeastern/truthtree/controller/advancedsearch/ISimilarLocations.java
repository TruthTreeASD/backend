package edu.northeastern.truthtree.controller.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.enums.NormalizationType;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ISimilarLocations {

  List<CommonAttributeDTO> getAttributes();

  List<LocationDTO> getSimilarLocations(int locationId,
                                        int placeType,
                                        List<Integer> attributes,
                                        NormalizationType normalizeBy,
                                        List<Integer> year,
                                        Integer count, HttpServletResponse response) throws Exception;
}
