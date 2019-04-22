package edu.northeastern.truthtree.service.population;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import edu.northeastern.truthtree.adapter.population.PopulationDBAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PopulationServiceTests {

  @Mock
  private PopulationDBAdapter populationAdapter;

  private PopulationService populationService;

  @Before
  public void setup() {
    populationService = new PopulationService(populationAdapter);
  }

  @Test
  public void getPopulationNullTest() {
    assertNull(populationService.getPopulation(null, null));
    assertNull(populationService.getPopulation(420000000, null));
    assertNull(populationService.getPopulation(null, 2016));
  }

  @Test
  public void getPopulationTest() {
    Object object = new Object();
    when(populationAdapter.getPopulation(420000000, 2016)).thenReturn(object);
    assertEquals(object, populationService.getPopulation(420000000, 2016));
  }
}
