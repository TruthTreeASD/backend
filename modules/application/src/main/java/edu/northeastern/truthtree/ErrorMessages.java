package edu.northeastern.truthtree;

/**
 * Represents the error messages used throughout the application.
 */
public class ErrorMessages {

  public static final String POPULATION_ERROR = "The supplied parameters were incorrect. " +
      "Please provide exactly two values in the format /api/states?populationRange=minValue," +
      "maxValue (minValue and maxValue) should not have any special characters, ex: ,";

  public static final String SIMILAR_LOCATIONS_ERROR = "Please provide start as well as end year " +
          "for Single attribute search";
}
