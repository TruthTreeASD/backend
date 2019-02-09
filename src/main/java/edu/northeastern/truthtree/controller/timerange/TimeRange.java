package edu.northeastern.truthtree.controller.timerange;

import edu.northeastern.truthtree.service.timerange.ITimeRangeService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeRange implements ITimeRange {
    private ITimeRangeService service;

    @Autowired
    public TimeRange(ITimeRangeService service) {
        this.service = service;
    }

    @Override
    @RequestMapping("/api/time_range")
    public String getTimeRange() {
        JSONArray response =  service.getTimeRange();
        return response.toJSONString();
    }
}
