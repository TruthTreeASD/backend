package edu.northeastern.truthtree;

import org.json.simple.JSONArray;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static edu.northeastern.truthtree.TestConst.RESOURCES_PATH;
import static edu.northeastern.truthtree.TestConst.SIMILAR_LOCATIONS_API;
import static edu.northeastern.truthtree.Utilities.readJSONFile;
import static edu.northeastern.truthtree.Utilities.readJSONFromURL;
import static org.testng.Assert.assertEquals;

@SpringBootTest
public class SimilarLocationsApiTests {

    @DataProvider(name = "data")
    public static Object[][] credentials() {
        return new Object[][]{
                {"/attributes", "similarlocations/commonattributes.json"},
                {"?locationId=220000000&place_type=0&attribute=132&normalize_by=PER_CAPITA&year=2014,2016",
                        "similarlocations/singleAttribute.json"},
                {"?locationId=220000000&place_type=0&attribute=1,132&normalize_by=BY_REVENUE&year=2014",
                        "similarlocations/multipleAttribute.json"}};
    }

    @Test(dataProvider = "data")
    public void testResponse(String params, String expectedResponsePath) {
        JSONArray actualResponse = readJSONFromURL(SIMILAR_LOCATIONS_API + params);
        JSONArray expectedResponse = readJSONFile(RESOURCES_PATH + expectedResponsePath);
        assertEquals(actualResponse, expectedResponse);
    }
}
