package edu.northeastern.truthtree.controller.normalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.truthtree.service.normalization.INormalizationService;

@RestController
public class Normalization implements INormalization {

  private INormalizationService service;

  @Autowired
  public Normalization(INormalizationService service) {
    this.service = service;
  }

  @Override
  @RequestMapping(value = "/api/normalization_types", method = RequestMethod.GET)
  public ResponseEntity<Object> getNormalizationTypes() {
    Object response = service.getNormalizationTypes();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
