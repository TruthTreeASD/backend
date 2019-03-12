package edu.northeastern.truthtree.service.population;

import edu.northeastern.truthtree.adapter.population.IPopulationAdapter;
import edu.northeastern.truthtree.adapter.population.PopulationDBAdapter;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


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

  public static void main(String[] args) {
    IPopulationService populationService = new PopulationService(new PopulationDBAdapter());
    Object response1 = populationService.getPopulation(182056011, 2000);
    Object response2 = populationService.getPopulation(182056011, 1967);
//    System.out.println(((Map)response2).get("population"));
    System.out.println((double) ((Map) response1).get("population") == 26633.0);
  }
}
