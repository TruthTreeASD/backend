package edu.northeastern.truthtree.service.advancedsearch.similarityby.multipleattributes;

import edu.northeastern.truthtree.adapter.advancedsearch.similarityby.multipleattributes.ISimilarityByAttributesAdapter;
import edu.northeastern.truthtree.dto.MultipleAttributesPayloadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimilarityByAttributesService implements ISimilarityByAttributesService {

    private ISimilarityByAttributesAdapter adapter;

    @Autowired
    private SimilarityByAttributesService(ISimilarityByAttributesAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Object getSimilarity(MultipleAttributesPayloadDTO payload) {
        return adapter.getSimilarity(payload);
    }
}
