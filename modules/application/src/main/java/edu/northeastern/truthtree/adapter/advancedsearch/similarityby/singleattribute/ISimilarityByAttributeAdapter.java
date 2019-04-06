package edu.northeastern.truthtree.adapter.advancedsearch.similarityby.singleattribute;

import edu.northeastern.truthtree.dto.SingleAttributePayloadDTO;

public interface ISimilarityByAttributeAdapter {

    Object getSimilarity(SingleAttributePayloadDTO payload);

}
