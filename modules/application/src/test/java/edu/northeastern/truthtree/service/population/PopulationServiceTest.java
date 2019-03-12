package edu.northeastern.truthtree.service.population;

import edu.northeastern.truthtree.adapter.population.PopulationDBAdapter;
import edu.northeastern.truthtree.controller.population.IPopulation;
import org.json.simple.JSONArray;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class PopulationServiceTest {

    private static IPopulationService populationService = new PopulationService(new PopulationDBAdapter());

    @Test
    public void getPopulation() {
        Object response1 = populationService.getPopulation(182056011, 2000);
        Object response2 = populationService.getPopulation(182056011, 1967);

        double populationOne = (double) ((Map) response1).get("population");
        assertTrue(populationOne == 26633.0);

    }
}