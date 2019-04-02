package edu.northeastern.truthtree.service.advancedsearch.commonattributes;

import edu.northeastern.truthtree.adapter.advancedsearch.commonattributes.ISupportedAttributesAdapter;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupportedAttributesService implements ISupportedAttributesService {

    private ISupportedAttributesAdapter adapter;

    @Autowired
    public SupportedAttributesService(ISupportedAttributesAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public List<CommonAttributeDTO> getSupportedAttributes() {
        return adapter.getSupportedAttributes();
    }
}
