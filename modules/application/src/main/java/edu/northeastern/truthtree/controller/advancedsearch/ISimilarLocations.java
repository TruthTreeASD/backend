package edu.northeastern.truthtree.controller.advancedsearch;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
<<<<<<< HEAD
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public interface ISimilarLocations {

    List<CommonAttributeDTO> getAttributes();

    List<SimilarPlacesDTO> getSimilarLocations(int id,
                                               int placeType,
                                               List<Integer> attributes,
                                               int normalizeBy,
                                               List<Integer> year,
                                               Integer count, HttpServletResponse response) throws Exception;
=======

import java.util.List;

public interface ISimilarLocations {

    List<CommonAttributeDTO> getAttributes();
>>>>>>> 41daaf689657d57e715e06997abfc043380cb549
}
