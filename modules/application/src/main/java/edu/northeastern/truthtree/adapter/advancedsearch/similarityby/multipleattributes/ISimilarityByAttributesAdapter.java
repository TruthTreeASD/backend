package edu.northeastern.truthtree.adapter.advancedsearch.similarityby.multipleattributes;

import edu.northeastern.truthtree.dto.MultipleAttributesPayloadDTO;

public interface ISimilarityByAttributesAdapter {

    Object getSimilarity(MultipleAttributesPayloadDTO payload);

}
