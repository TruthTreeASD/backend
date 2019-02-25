package edu.northeastern.truthtree.service.population;

import edu.northeastern.truthtree.adapter.population.IPopulationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PopulationService implements IPopulationService {

  private IPopulationAdapter adapter;

  @Autowired
  public PopulationService(IPopulationAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public Object getPopulation(Integer locationId, Integer year) {
    if (locationId != null && year != null) {
      Object population = adapter.getPopulation(locationId, year);
      return population;
    }
    return null;
  }
}
