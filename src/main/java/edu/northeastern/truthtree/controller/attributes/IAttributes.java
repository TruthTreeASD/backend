package edu.northeastern.truthtree.controller.attributes;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAttributes {

  /**
   * Returns attributes for attribute API.
   *
   * @param locations location id list
   * @param collections collection id list
   * @param properties property id list
   * @param attributes attribute id list
   * @param yearRange year range
   * @param yearList year list
   * @return attributes
   */
  ResponseEntity getAttributes(
      @RequestParam(value = "locations", required = false) List<Integer> locations,
      @RequestParam(value = "collection", required = false) List<Integer> collections,
      @RequestParam(value = "property", required = false) List<Integer> properties,
      @RequestParam(value = "attributes", required = false) List<Integer> attributes,
      @RequestParam(value = "yearRange", required = false) List<Integer> yearRange,
      @RequestParam(value = "yearList", required = false) List<Integer> yearList);
}
