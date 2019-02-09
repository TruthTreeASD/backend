package edu.northeastern.truthtree.adapter.timerange;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.json.simple.JSONArray;

public class TimeRangeDBAdapter implements ITimeRangeAdapter {

    private static final String TIME_RANGE_URL = "http://54.241.137.214:8080/api/time_range";

    @Override
    public JSONArray getTimeRange() {
        return URLUtil.readJSONFromURL(TIME_RANGE_URL);
    }
}
