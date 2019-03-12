package edu.northeastern.truthtree;

import org.json.simple.JSONArray;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static edu.northeastern.truthtree.TestConst.BASIC_INFO_API;
import static edu.northeastern.truthtree.TestConst.RESOURCES_PATH;
import static edu.northeastern.truthtree.Utilities.readJSONFile;
import static edu.northeastern.truthtree.Utilities.readJSONFromURL;
import static org.testng.Assert.assertEquals;


@SpringBootTest
public class BasicInfoApiTests {

    @DataProvider(name = "data")
    public static Object[][] credentials() {
        return new Object[][]{
                {"states", "basicinfo/allStates.json"},
                {"states/80000000", "basicinfo/stateById.json"},
                {"cities", "basicinfo/allCities.json"},
                {"cities/262060004", "basicinfo/cityById.json"},
                {"counties", "basicinfo/allCounties.json"},
                {"counties/391013013", "basicinfo/countyById.json"}};
    }

    @Test(dataProvider = "data")
    public void testResponse(String params, String expectedResponsePath) {
        JSONArray actualResponse = readJSONFromURL(BASIC_INFO_API + params);
        JSONArray expectedResponse = readJSONFile(RESOURCES_PATH + expectedResponsePath);
        assertEquals(actualResponse, expectedResponse);
    }
}
