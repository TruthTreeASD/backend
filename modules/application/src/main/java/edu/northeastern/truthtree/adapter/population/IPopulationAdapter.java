package edu.northeastern.truthtree.adapter.population;

public interface IPopulationAdapter {
    /**
     * Get population with location id and year.
     * @param locationId Integer
     * @param year Integer
     * @return attributes
     */
    Object getPopulation(Integer locationId, Integer year);

}