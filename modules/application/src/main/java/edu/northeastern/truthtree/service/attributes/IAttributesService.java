package edu.northeastern.truthtree.service.attributes;

import edu.northeastern.truthtree.enums.NormalizationType;
import java.util.List;

public interface IAttributesService {
  /**
   * Returns attributes in formatted json.
   *
   * @param locations   location id list
   * @param collections collection id list
   * @param properties  property id list
   * @param attributes  attribute id list
   * @param yearRange   year range
   * @param yearList    year list
   * @return attributes in formatted json
   */
  Object getAttributes(List<Integer> locations, List<Integer> collections, List<Integer> properties,
                       List<Integer> attributes, List<Integer> yearRange, List<Integer> yearList, List<NormalizationType> normalizationType);
}
