package edu.northeastern.truthtree.adapter;

import edu.northeastern.truthtree.adapter.population.PopulationDBAdapter;
import org.junit.Before;
import org.junit.Test;

public class PopulationDBAdapterTests {
  private PopulationDBAdapter populationDBAdapter;

  @Before
  public void setup() {
    populationDBAdapter = new PopulationDBAdapter();
  }

  @Test
  public void test() {
    populationDBAdapter.getPopulation(420000000,2012);
  }

}
