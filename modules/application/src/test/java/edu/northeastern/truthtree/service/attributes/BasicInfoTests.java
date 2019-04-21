package edu.northeastern.truthtree.service.attributes;

import static edu.northeastern.truthtree.TestConstants.CITY_ID;
import static edu.northeastern.truthtree.TestConstants.COUNTY_ID;
import static edu.northeastern.truthtree.TestConstants.RANGE1;
import static edu.northeastern.truthtree.TestConstants.RANGE2;
import static edu.northeastern.truthtree.TestConstants.STATE_ID;
import static org.junit.Assert.assertEquals;

import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.PageDTO;
import edu.northeastern.truthtree.service.basicInfo.BasicInfoService;
import edu.northeastern.truthtree.service.basicInfo.IBasicInfoService;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
    public void testGetStateInfoWithNullRange() throws IOException {
        PageDTO<LocationDTO> actualResponse = basicInfoAdapter.getBasicStatesInfo();
        assertEquals(actualResponse, basicInfoService.getBasicStatesInfo(1, null));
    }

    @Test
    public void testGetCityInfoWithNullRange() throws IOException {
        PageDTO<LocationDTO> actualResponse = basicInfoAdapter.getBasicCitiesInfo();
        assertEquals(actualResponse, basicInfoService.getBasicCitiesInfo(1, null));
    }

    @Test
    public void testGetCountyInfoWithNullRange() throws IOException {
        PageDTO<LocationDTO> actualResponse = basicInfoAdapter.getBasicCountiesInfo();
        assertEquals(actualResponse, basicInfoService.getBasicCountiesInfo(1, null));
    }


    @Test
    public void testStatePopulationError() throws IOException {
        try {
            basicInfoService.getBasicStatesInfo(1, RANGE1);
        } catch (IllegalArgumentException e) {
            // test passed
        }
        try {
            basicInfoService.getBasicStatesInfo(1, RANGE2);
        } catch (IllegalArgumentException e) {
            // test passed
        }
    }

    @Test
    public void testCityPopulationError() throws IOException {
        try {
            basicInfoService.getBasicCitiesInfo(1, RANGE1);
        } catch (IllegalArgumentException e) {
            // test passed
        }
        try {
            basicInfoService.getBasicCitiesInfo(1, RANGE2);
        } catch (IllegalArgumentException e) {
            // test passed
        }
    }

    @Test
    public void testCountyPopulationError() throws IOException {
        try {
            basicInfoService.getBasicCountiesInfo(1, RANGE1);
        } catch (IllegalArgumentException e) {
            // test passed
        }
        try {
            basicInfoService.getBasicCountiesInfo(1, RANGE2);
        } catch (IllegalArgumentException e) {
            // test passed
        }
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
