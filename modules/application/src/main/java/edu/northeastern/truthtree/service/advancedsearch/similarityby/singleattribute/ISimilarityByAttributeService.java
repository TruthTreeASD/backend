package edu.northeastern.truthtree.service.advancedsearch.similarityby.singleattribute;

import edu.northeastern.truthtree.dto.SingleAttributePayloadDTO;

public interface ISimilarityByAttributeService {

    Object getSimilarity(SingleAttributePayloadDTO payload);

}
