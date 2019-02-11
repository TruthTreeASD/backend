package edu.northeastern.truthtree.controller.attributes;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IAttributes {
    ResponseEntity getAttributes(@RequestParam(value = "locations", required = false) List<Integer> locations,
                                 @RequestParam(value = "collection", required = false) List<Integer> collections,
                                 @RequestParam(value = "property", required = false) List<Integer> properties,
                                 @RequestParam(value = "attributes", required = false) List<Integer> attributes,
                                 @RequestParam(value = "yearRange", required = false) List<Integer> yearRange,
                                 @RequestParam(value = "yearList", required = false) List<Integer> yearList);
}
