package edu.northeastern.truthtree.controller.population;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IPopulation {
	/**
	 * Returns population for Populations API.
	 * 
	 * @param locationId
	 *            location id Integer
	 * @param year
	 *            year Integer
	 * @return population
	 */
	ResponseEntity getPopulation(@RequestParam(value = "locationId") Integer locationId,
                                 @RequestParam(value = "year") Integer year);
}
