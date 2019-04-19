package edu.northeastern.truthtree;

import static edu.northeastern.truthtree.TestConst.POPULATION_API;
import static edu.northeastern.truthtree.TestConst.RESOURCES_PATH;
import static edu.northeastern.truthtree.Utilities.readJSONFile;
import static edu.northeastern.truthtree.Utilities.readJSONFromURL;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SpringBootTest
public class PopulationApiTests {

  @DataProvider(name = "data")
  public static Object[][] credentials() {
    return new Object[][]{
        {"locationId=182056011&year=2000", "population/populationByLocationIdAndYear1.json"},
        {"locationId=320000000&year=2000", "population/populationByLocationIdAndYear2.json"}};
  }

  @Test(dataProvider = "data")
  public void testResponse(String params, String expectedResponsePath) throws JSONException {
    JSONArray actualResponse = readJSONFromURL(POPULATION_API + params);
    JSONArray expectedResponse = readJSONFile(RESOURCES_PATH + expectedResponsePath);
    JSONAssert.assertEquals(expectedResponse.toJSONString(), actualResponse.toJSONString(), false);
  }
}

