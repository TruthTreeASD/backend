package edu.northeastern.truthtree.service.timerange;

import edu.northeastern.truthtree.adapter.timerange.ITimeRangeAdapter;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimeRangeService implements ITimeRangeService {
    private ITimeRangeAdapter adapter;

    @Autowired
    public TimeRangeService(ITimeRangeAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public JSONArray getTimeRange() {
        return adapter.getTimeRange();
    }
}
