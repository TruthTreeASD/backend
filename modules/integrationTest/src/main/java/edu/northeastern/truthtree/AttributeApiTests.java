package edu.northeastern.truthtree;

import static edu.northeastern.truthtree.TestConst.ATTRIBUTES_API;
import static edu.northeastern.truthtree.TestConst.RESOURCES_PATH;
import static edu.northeastern.truthtree.Utilities.readJSONFile;
import static edu.northeastern.truthtree.Utilities.readJSONFromURL;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONArray;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SpringBootTest
public class AttributeApiTests {

  @DataProvider(name = "data")
  public static Object[][] credentials() {
    return new Object[][]{
        {"locationIds=320000000&attributeIds=4&yearList=2000", "attributeResponse1.json"},
        {"locationIds=420000000&attributeIds=4%2C5&yearList=2001", "attributeResponse2.json"}};
  }

  @Test(dataProvider = "data")
  public void testResponse(String params, String expectedResponsePath) {
    JSONArray actualResponse = readJSONFromURL(ATTRIBUTES_API + params);
    JSONArray expectedResponse = readJSONFile(RESOURCES_PATH + expectedResponsePath);
    assertEquals(actualResponse, expectedResponse);
  }
}

