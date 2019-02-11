package edu.northeastern.truthtree.service.attributes;

import org.json.simple.JSONArray;

import java.util.List;

public interface IAttributesService {
    Object getAttributes(List<Integer> locations, List<Integer> collections, List<Integer> properties,
                            List<Integer> attributes, List<Integer> yearRange, List<Integer> yearList);
}
