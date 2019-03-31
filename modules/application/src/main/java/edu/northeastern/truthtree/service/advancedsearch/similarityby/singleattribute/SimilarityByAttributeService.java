package edu.northeastern.truthtree.service.advancedsearch.similarityby.singleattribute;

import edu.northeastern.truthtree.adapter.advancedsearch.similarityby.singleattribute.ISimilarityByAttributeAdapter;
import edu.northeastern.truthtree.dto.SingleAttributePayloadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimilarityByAttributeService implements ISimilarityByAttributeService {

    private ISimilarityByAttributeAdapter adapter;

    @Autowired
    public SimilarityByAttributeService(ISimilarityByAttributeAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Object getSimilarity(SingleAttributePayloadDTO payload) {
        return adapter.getSimilarity(payload);
    }
}
