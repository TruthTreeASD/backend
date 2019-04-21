package edu.northeastern.truthtree.service.attributes;

import edu.northeastern.truthtree.adapter.attributes.AttributesDBAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.northeastern.truthtree.AppConst;
import edu.northeastern.truthtree.adapter.AttributesMockAdapter;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class AttributesServiceTest {

  private static IAttributesService attributesService;
  private static Map<Integer, Double> grossValuesForAllYears;

  @BeforeClass
  public static void setup() {
    attributesService = new AttributesService(new AttributesMockAdapter());
    initializeGrossValues();
  }

  /**
   * Tests gross values for attribute 5 for all the years for location 182056011. Validates if
   * attributes values are returned correctly for the mentioned years in grossValuesForAllYears
   * hashmap.
   */
  @Test
  public void testGetAttributesForAllYearsForGrossValues() {
    List<Integer> locationIds = Arrays.asList(182056011);
    List<Integer> attributeIds = Arrays.asList(5);
    Object actualOutput = attributesService.getAttributes(locationIds, null,
            null, attributeIds, null, null, null);
    JSONArray output = (JSONArray) actualOutput;
    JSONObject map = (JSONObject) output.get(0);
    List attributesList = (ArrayList) map.get(AppConst.ATTRIBUTES);
    JSONObject attrMap = (JSONObject) attributesList.get(0);
    List dataList = (ArrayList) attrMap.get(AppConst.DATA);
    Long locationId = (Long) map.get(AppConst.LOCATION_ID);
    String attrName = (String) attrMap.get("name");
    Map<Long, Double> valueMap = null;
    assertEquals(dataList.size(), grossValuesForAllYears.size());
    for (Object data : dataList) {
      JSONObject dataMap = (JSONObject) data;
      Double value = (Double) dataMap.get(AppConst.VALUE);
      Long year = (Long) dataMap.get(AppConst.YEAR);
      assertEquals(value, grossValuesForAllYears.get(Math.toIntExact(year)));
    }
    assertEquals(attrName, "Total_Rev_Own_Sources");
    assertEquals(locationId, new Long(182056011));
  }

  /**
   * Tests gross values for attribute 5 for years 2016, 2015, 2013, 2010, 1990 for location
   * 182056011.
   */
  @Test
  public void testGetAttributesForYearListForGrossValues() {
    List<Integer> locationIds = Arrays.asList(182056011);
    List<Integer> attributeIds = Arrays.asList(5);
    List<Integer> yearList = Arrays.asList(2016, 2015, 2013, 2010, 1990);
    Object actualOutput = attributesService.getAttributes(locationIds, null,
            null, attributeIds, null, yearList, null);
    JSONArray output = (JSONArray) actualOutput;
    JSONObject map = (JSONObject) output.get(0);
    List attributesList = (ArrayList) map.get(AppConst.ATTRIBUTES);
    JSONObject attrMap = (JSONObject) attributesList.get(0);
    List dataList = (ArrayList) attrMap.get(AppConst.DATA);
    Long locationId = (Long) map.get(AppConst.LOCATION_ID);
    String attrName = (String) attrMap.get("name");
    Map<Long, Double> valueMap = null;
    assertEquals(yearList.size(), dataList.size());
    for (Object data : dataList) {
      JSONObject dataMap = (JSONObject) data;
      Double value = (Double) dataMap.get(AppConst.VALUE);
      Long year = (Long) dataMap.get(AppConst.YEAR);
      assertEquals(value, grossValuesForAllYears.get(Math.toIntExact(year)));
    }
    assertEquals(attrName, "Total_Rev_Own_Sources");
    assertEquals(locationId, new Long(182056011));
  }

  /**
   * Tests gross values for attribute 5 for year range for location 182056011.
   */
  @Test
  public void testGetAttributesForYearRangeForGrossValues() {
    List<Integer> locationIds = Arrays.asList(182056011);
    List<Integer> attributeIds = Arrays.asList(5);
    List<Integer> yearRange = Arrays.asList(1996, 2016);
    Object actualOutput = attributesService.getAttributes(locationIds, null,
            null, attributeIds, yearRange, null, null);
    JSONArray output = (JSONArray) actualOutput;
    JSONObject map = (JSONObject) output.get(0);
    List attributesList = (ArrayList) map.get(AppConst.ATTRIBUTES);
    JSONObject attrMap = (JSONObject) attributesList.get(0);
    List dataList = (ArrayList) attrMap.get(AppConst.DATA);
    Long locationId = (Long) map.get(AppConst.LOCATION_ID);
    String attrName = (String) attrMap.get("name");
    Map<Long, Double> valueMap = null;
    assertEquals(19, dataList.size());
    for (Object data : dataList) {
      JSONObject dataMap = (JSONObject) data;
      Double value = (Double) dataMap.get(AppConst.VALUE);
      Long year = (Long) dataMap.get(AppConst.YEAR);
      assertEquals(value, grossValuesForAllYears.get(Math.toIntExact(year)));
    }
    assertEquals(attrName, "Total_Rev_Own_Sources");
    assertEquals(locationId, new Long(182056011));
  }


  private static void initializeGrossValues() {
    grossValuesForAllYears = new HashMap<>();
    grossValuesForAllYears.put(2016, 25143.0);
    grossValuesForAllYears.put(2015, 21222.0);
    grossValuesForAllYears.put(2014, 23268.0);
    grossValuesForAllYears.put(2013, 22043.0);
    grossValuesForAllYears.put(2012, 24324.0);
    grossValuesForAllYears.put(2011, 24565.0);
    grossValuesForAllYears.put(2010, 23334.0);
    grossValuesForAllYears.put(2009, 24972.0);
    grossValuesForAllYears.put(2008, 16617.0);
    grossValuesForAllYears.put(2007, 14797.0);
    grossValuesForAllYears.put(2006, 19329.0);
    grossValuesForAllYears.put(2005, 20831.0);
    grossValuesForAllYears.put(2004, 22565.0);
    grossValuesForAllYears.put(2002, 25500.0);
    grossValuesForAllYears.put(2000, 17469.0);
    grossValuesForAllYears.put(1999, 17827.0);
    grossValuesForAllYears.put(1998, 17364.0);
    grossValuesForAllYears.put(1997, 15904.0);
    grossValuesForAllYears.put(1996, 14348.0);
    grossValuesForAllYears.put(1995, 13987.0);
    grossValuesForAllYears.put(1994, 12484.0);
    grossValuesForAllYears.put(1993, 11988.0);
    grossValuesForAllYears.put(1992, 11624.0);
    grossValuesForAllYears.put(1991, 11159.0);
    grossValuesForAllYears.put(1990, 10561.0);
    grossValuesForAllYears.put(1989, 9297.0);
    grossValuesForAllYears.put(1988, 8939.0);
    grossValuesForAllYears.put(1987, 4100.0);
    grossValuesForAllYears.put(1986, 3999.0);
    grossValuesForAllYears.put(1985, 3982.0);
    grossValuesForAllYears.put(1984, 3393.0);
    grossValuesForAllYears.put(1983, 1856.0);
    grossValuesForAllYears.put(1982, 1726.0);
    grossValuesForAllYears.put(1981, 1523.0);
    grossValuesForAllYears.put(1980, 1654.0);
    grossValuesForAllYears.put(1979, 1445.0);
    grossValuesForAllYears.put(1978, 1089.0);
    grossValuesForAllYears.put(1977, 1049.0);
    grossValuesForAllYears.put(1976, 811.0);
    grossValuesForAllYears.put(1975, 468.0);
    grossValuesForAllYears.put(1974, 376.0);
    grossValuesForAllYears.put(1973, 338.0);
    grossValuesForAllYears.put(1972, 287.0);
    grossValuesForAllYears.put(1971, 245.0);
    grossValuesForAllYears.put(1970, 748.0);
    grossValuesForAllYears.put(1967, 406.0);
  }

}
