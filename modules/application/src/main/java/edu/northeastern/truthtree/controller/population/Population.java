package edu.northeastern.truthtree.controller.population;

import edu.northeastern.truthtree.service.population.IPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@CrossOrigin(origins = "*", maxAge = 3600)
public class Population implements IPopulation {

  private IPopulationService service;

  @Autowired
  public Population(IPopulationService service) {
    this.service = service;
  }

  @Override
  @RequestMapping(value = "/api/population", method = RequestMethod.GET)
  public ResponseEntity<Object> getPopulation(
      @RequestParam(value = "locationId") Integer locationId,
      @RequestParam(value = "year") Integer year) {
    Object response = service.getPopulation(locationId, year);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
