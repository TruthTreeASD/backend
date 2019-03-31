package edu.northeastern.truthtree.service.advancedsearch.similarityby.multipleattributes;

import edu.northeastern.truthtree.dto.MultipleAttributesPayloadDTO;

public interface ISimilarityByAttributesService {

    Object getSimilarity(MultipleAttributesPayloadDTO payload);

}
