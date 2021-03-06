package edu.northeastern.truthtree;

import static edu.northeastern.truthtree.TestConst.COLLECTIONS_API;
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
public class CollectionApiTests {

  @DataProvider(name = "data")
  public static Object[][] credentials() {
    return new Object[][]{
        {"", "collection/allCollections.json"},
        {"?locationId=182056011", "collection/collectionByLocationId1.json"},
        {"?locationId=320000000", "collection/collectionByLocationId2.json"}};
  }

  @Test(dataProvider = "data")
  public void testResponse(String params, String expectedResponsePath) throws JSONException {
    JSONArray actualResponse = readJSONFromURL(COLLECTIONS_API + params);
    JSONArray expectedResponse = readJSONFile(RESOURCES_PATH + expectedResponsePath);
    JSONAssert.assertEquals(expectedResponse.toJSONString(), actualResponse.toJSONString(), false);
  }
}

