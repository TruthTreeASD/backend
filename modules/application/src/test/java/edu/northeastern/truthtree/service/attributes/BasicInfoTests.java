package edu.northeastern.truthtree.service.attributes;

import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.service.basicInfo.BasicInfoService;
import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;
import org.json.simple.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static edu.northeastern.truthtree.TestConstants.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BasicInfoTests {

    @Mock
    private IBasicInfoAdapter basicInfoAdapter;

    private IBasicInfoService basicInfoService;

    @Before
    public void setup() {
        basicInfoService = new BasicInfoService(basicInfoAdapter);
    }

    @Test
    public void testGetStateInfoWithNullRange() {
        JSONArray actualResponse = basicInfoAdapter.getBasicStatesInfo();
        assertEquals(actualResponse, basicInfoService.getBasicStatesInfo(null));
    }

    @Test
    public void testGetCityInfoWithNullRange() {
        JSONArray actualResponse = basicInfoAdapter.getBasicCitiesInfo();
        assertEquals(actualResponse, basicInfoService.getBasicCitiesInfo(null));
    }

    @Test
    public void testGetCountyInfoWithNullRange() {
        JSONArray actualResponse = basicInfoAdapter.getBasicCountiesInfo();
        assertEquals(actualResponse, basicInfoService.getBasicCountiesInfo(null));
    }


    @Test
    public void testStatePopulationError() {
        assertEquals(JSONUtil.createErrorMessage(POPULATION_ERROR), basicInfoService.getBasicStatesInfo(RANGE1));
        assertEquals(JSONUtil.createErrorMessage(POPULATION_ERROR), basicInfoService.getBasicStatesInfo(RANGE2));

    }

    @Test
    public void testCityPopulationError() {
        assertEquals(JSONUtil.createErrorMessage(POPULATION_ERROR), basicInfoService.getBasicCitiesInfo(RANGE1));
        assertEquals(JSONUtil.createErrorMessage(POPULATION_ERROR), basicInfoService.getBasicCitiesInfo(RANGE2));
    }

    @Test
    public void testCountyPopulationError() {
        assertEquals(JSONUtil.createErrorMessage(POPULATION_ERROR), basicInfoService.getBasicCountiesInfo(RANGE1));
        assertEquals(JSONUtil.createErrorMessage(POPULATION_ERROR), basicInfoService.getBasicCountiesInfo(RANGE2));
    }

    @Test
    public void testStateDetails() {
        assertEquals(basicInfoAdapter.getStateDetails(STATE_ID, null),
                    basicInfoService.getStateDetails(STATE_ID, null));
    }

    @Test
    public void testCityDetails() {
        assertEquals(basicInfoAdapter.getCityDetails(CITY_ID, null),
                    basicInfoService.getCityDetails(CITY_ID, null));
    }

    @Test
    public void testCountyDetails() {
        assertEquals(basicInfoAdapter.getCountyDetails(COUNTY_ID, null),
                basicInfoService.getCountyDetails(COUNTY_ID, null));
    }
}
