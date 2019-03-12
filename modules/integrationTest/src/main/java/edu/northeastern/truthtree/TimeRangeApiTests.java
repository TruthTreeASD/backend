package edu.northeastern.truthtree;

import org.json.simple.JSONArray;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static edu.northeastern.truthtree.TestConst.RESOURCES_PATH;
import static edu.northeastern.truthtree.TestConst.TIME_RANGE_API;
import static edu.northeastern.truthtree.Utilities.readJSONFile;
import static edu.northeastern.truthtree.Utilities.readJSONFromURL;
import static org.testng.Assert.assertEquals;

public class TimeRangeApiTests {

    @DataProvider(name = "data")
    public static Object[][] credentials() {
        return new Object[][]{
                {"level=state&attributes=74", "timerange/timeRangeByLevelAndAttribute1.json"}};
    }

    @Test(dataProvider = "data")
    public void testResponse(String params, String expectedResponsePath) {
        JSONArray actualResponse = readJSONFromURL(TIME_RANGE_API + params);
        JSONArray expectedResponse = readJSONFile(RESOURCES_PATH + expectedResponsePath);
        assertEquals(actualResponse, expectedResponse);
    }
}
