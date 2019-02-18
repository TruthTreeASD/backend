package edu.northeastern.truthtree.adapter.population;

public interface IPopulationAdapter {
    /**
     * Get attributes with location id list and year.
     * @param locationId Integer
     * @param year Integer
     * @return attributes
     */
    Object getPopulation(Integer locationId, Integer year);

}