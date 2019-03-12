package edu.northeastern.truthtree.service.timerange;

import edu.northeastern.truthtree.adapter.timerange.TimeRangeDBAdapter;
import edu.northeastern.truthtree.adapter.timerange.TimeRangeMockAdapter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TimeRangeServiceTest {

    private ITimeRangeService trs = new TimeRangeService(new TimeRangeDBAdapter());

    @Test
    public void getTimeRange() {
        List<Integer> attributes = new ArrayList<>();
        attributes.add(1);
        Object response = trs.getTimeRange("state", attributes);
        assertEquals(true, response);
    }

}
