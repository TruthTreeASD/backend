package edu.northeastern.truthtree.adapter.timerange;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import org.json.simple.JSONArray;

public class TimeRangeMockAdapter implements ITimeRangeAdapter {

    private static final String TIME_RANGE_FILE_PATH = "src/main/resources/TimeRange.json";

    @Override
    public JSONArray getTimeRange() {
        return JSONUtil.readJSONFile(TIME_RANGE_FILE_PATH);
    }
}
