package edu.northeastern.truthtree.controller.advancedsearch;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

public interface ISimilarLocations {

  List<CommonAttributeDTO> getAttributes();

  List<SimilarPlacesDTO> getSimilarLocations(int id,
                                             int placeType,
                                             List<Integer> attributes,
                                             int normalizeBy,
                                             List<Integer> year,
                                             Integer count, HttpServletResponse response) throws Exception;
}
