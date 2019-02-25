package edu.northeastern.truthtree.adapter.attributes;

import java.util.List;
import org.json.simple.JSONArray;

public interface IAttributesAdapter {

  /**
   * Get attributes without any parameters.
   *
   * @return attributes
   */
  JSONArray getAttributes();

  /**
   * Get attributes with attribute id list.
   *
   * @param attributes attribute id list
   * @return attributes
   */
  Object getAttributes(List<Integer> attributes);

  /**
   * Get attributes with attribute id list and location id list.
   *
   * @param attributes attribute id list
   * @param locations location id list
   * @return attributes
   */
  Object getAttributesWithLocations(List<Integer> attributes, List<Integer> locations);

  /**
   * Get attributes with attribute id list, location id list and year list.
   *
   * @param attributes attribute id list
   * @param locations location id list
   * @param yearList year list
   * @return attributes
   */
  Object getAttributesWithLocationsYearList(List<Integer> attributes, List<Integer> locations,
      List<Integer> yearList);

  /**
   * Get attributes with attribute id list, location id list and year range.
   *
   * @param attributes attribute id list
   * @param locations location id list
   * @param yearRange year range
   * @return attributes
   */
  Object getAttributesWithLocationsYearRange(List<Integer> attributes, List<Integer> locations,
      List<Integer> yearRange);

  /**
   * Get attribute id list with collectionIds and propertyIds.
   *
   * @param collections collection id list
   * @param properties property id list
   * @return attribute id list
   */
  List<Integer> getAttributeIdWithCollectionProperty(List<Integer> collections,
      List<Integer> properties);
}