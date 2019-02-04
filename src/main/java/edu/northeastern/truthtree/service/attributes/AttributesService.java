package edu.northeastern.truthtree.service.attributes;

import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributesService implements IAttributesService {

    private IAttributesAdapter adapter;

    @Autowired
    public AttributesService(IAttributesAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public JSONArray getAttributes() {
        return adapter.getAttributes();
    }
}
