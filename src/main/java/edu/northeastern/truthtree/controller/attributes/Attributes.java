package edu.northeastern.truthtree.controller.attributes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import edu.northeastern.truthtree.enums.NormalizationType;
import edu.northeastern.truthtree.service.attributes.IAttributesService;

@RestController
@Component
@CrossOrigin(origins = "*", maxAge = 3600)
public class Attributes implements IAttributes {
  private IAttributesService service;

  @Autowired
  public Attributes(IAttributesService service) {
    this.service = service;
  }

  @Override
  @RequestMapping(value = "/api/attributes", method = RequestMethod.GET)
  public ResponseEntity<Object> getAttributes(@RequestParam(value = "locationIds") List<Integer> locations,
                                              @RequestParam(value = "collectionIds", required = false) List<Integer> collections,
                                              @RequestParam(value = "propertyIds", required = false) List<Integer> properties,
                                              @RequestParam(value = "attributeIds") List<Integer> attributes,
                                              @RequestParam(value = "yearRange", required = false) List<Integer> yearRange,
                                              @RequestParam(value = "yearList", required = false) List<Integer> yearList,
                                              @RequestParam(value = "normalizationType", required = false) List<NormalizationType> normalizationType) {
    Object response = service.getAttributes(locations, collections, properties, attributes, yearRange, yearList, normalizationType);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
