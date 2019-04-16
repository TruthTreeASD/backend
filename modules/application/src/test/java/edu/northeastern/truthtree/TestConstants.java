package edu.northeastern.truthtree;

public class TestConstants {
  private static final String RESOURCES_PATH = "";
  public static final String ALL_YEARS_GROSS_VALUE = RESOURCES_PATH + "/AttributesForAllYearsForGrossValues.json";
  public static final String YEAR_LIST_GROSS_VALUE = RESOURCES_PATH + "/AttributesForYearListForGrossValues.json";
  public static final String YEAR_RANGE_GROSS_VALUE = RESOURCES_PATH + "/AttributesForYearRangeForGrossValues.json";

  public static final String POPULATION_ERROR = "The supplied parameters were incorrect. " +
          "Please provide exactly two values in the format /api/states?populationRange=minValue," +
          "maxValue (minValue and maxValue) should not have any special characters, ex: ,";

  public static final int[] RANGE1 = { 100000, 50000 };

  public static final int[] RANGE2 = { 1000000 };

  public static final String STATE_ID = "80000000";

  public static final String CITY_ID = "162058002";

  public static final String COUNTY_ID = "41038038";

}
