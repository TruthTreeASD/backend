package edu.northeastern.truthtree.service.population;

public interface IPopulationService {

  /**
   * Returns population in formatted json.
   *
   * @param locationId location id Integer
   * @param year year Integer
   * @return attributes in formatted json
   */
  Object getPopulation(Integer locationId, Integer year);
}
