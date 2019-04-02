package edu.northeastern.truthtree.controller.advancedsearch.similarityby.singleattribute;

import edu.northeastern.truthtree.dto.SingleAttributePayloadDTO;

public interface ISimilarityByAttribute {

    Object getSimilarity(SingleAttributePayloadDTO payload);

}
