package edu.northeastern.truthtree.adapter.attributes;

import org.json.simple.JSONArray;

import java.util.List;

public interface IAttributesAdapter {
    JSONArray getAttributes();

    Object getAttributes(List<Integer> attributes);

    Object getAttributesWithLocations(List<Integer> attributes, List<Integer> locations);

    Object getAttributesWithLocationsYearList(List<Integer> attributes, List<Integer> locations, List<Integer> timeList);

    Object getAttributesWithLocationsYearRange(List<Integer> attributes, List<Integer> locations, List<Integer> timeRange);
}