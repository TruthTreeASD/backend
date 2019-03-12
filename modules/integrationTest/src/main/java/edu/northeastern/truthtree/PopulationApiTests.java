package edu.northeastern.truthtree;

import org.json.simple.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static edu.northeastern.truthtree.TestConst.POPULATION_API;
import static edu.northeastern.truthtree.TestConst.RESOURCES_PATH;
import static edu.northeastern.truthtree.Utilities.readJSONFile;
import static edu.northeastern.truthtree.Utilities.readJSONFromURL;
import static org.testng.Assert.assertEquals;

@SpringBootTest
public class PopulationApiTests {

    @DataProvider(name = "data")
    public static Object[][] credentials() {
        return new Object[][]{
                {"locationId=182056011&year=2000", "population/populationByLocationIdAndYear1.json"},
                {"locationId=320000000&year=2000", "population/populationByLocationIdAndYear2.json"}};
    }

    @Test(dataProvider = "data")
    public void testResponse(String params, String expectedResponsePath) {
        JSONObject actualResponse = (JSONObject) readJSONFromURL(POPULATION_API + params).get(0);
        JSONObject expectedResponse = (JSONObject) readJSONFile(RESOURCES_PATH + expectedResponsePath).get(0);
        assertEquals(actualResponse, expectedResponse);
    }
}

