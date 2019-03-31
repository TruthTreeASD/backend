package edu.northeastern.truthtree.service.advancedsearch.commonattributes;

import edu.northeastern.truthtree.adapter.advancedsearch.commonattributes.ISupportedAttributesAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupportedAttributesService implements ISupportedAttributesService {

    private ISupportedAttributesAdapter adapter;

    @Autowired
    public SupportedAttributesService(ISupportedAttributesAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Object getSupportedAttributes(String placeType) {
        return adapter.getSupportedAttributes(placeType);
    }
}
