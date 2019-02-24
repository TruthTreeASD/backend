package edu.northeastern.truthtree.adapter.population;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

public class PopulationMockAdapter implements IPopulationAdapter {

    private static final String POPULATION_FILE_PATH = "src/main/resources/Population.json";

    @Override
    public Object getPopulation(Integer locationId, Integer year) {
        return  JSONUtil.readJSONFile(POPULATION_FILE_PATH);
    }
}
