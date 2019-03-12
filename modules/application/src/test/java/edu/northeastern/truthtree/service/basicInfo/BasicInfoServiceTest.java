package edu.northeastern.truthtree.service.basicInfo;

import edu.northeastern.truthtree.adapter.basicInfo.BasicInfoDBAdapter;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicInfoServiceTest {

    private static IBasicInfoService basicInfoService = new BasicInfoService(new BasicInfoDBAdapter());

    @Test
    public void getBasicStatesInfo() {
//        Object response = basicInfoService.getBasicStatesInfo(new BasicInfoD);
    }

    @Test
    public void getStateDetails() {
    }

    @Test
    public void getBasicCitiesInfo() {
    }

    @Test
    public void getCityDetails() {
    }

    @Test
    public void getBasicCountiesInfo() {
    }

    @Test
    public void getCountyDetails() {
    }
}