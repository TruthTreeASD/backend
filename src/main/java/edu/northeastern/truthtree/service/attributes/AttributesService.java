package edu.northeastern.truthtree.service.attributes;

import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttributesService implements IAttributesService {

    private IAttributesAdapter adapter;

    @Autowired
    public AttributesService(IAttributesAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Object getAttributes(List<Integer> locations, List<Integer> collections, List<Integer> properties,
                                   List<Integer> attributes, List<Integer> yearRange, List<Integer> yearList) {
        if (locations != null && attributes != null) {
            if (yearList != null) {
                return adapter.getAttributesWithLocationsYearList(attributes, locations, yearList);
            } else if (yearRange != null) {
                return adapter.getAttributesWithLocationsYearRange(attributes, locations, yearRange);
            } else {
                return adapter.getAttributesWithLocations(attributes, locations);
            }
        } else if (attributes != null) {
            return adapter.getAttributes(attributes);
        }
        return null;
    }
}
