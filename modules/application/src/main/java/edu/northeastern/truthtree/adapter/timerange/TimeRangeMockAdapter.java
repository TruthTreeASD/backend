package edu.northeastern.truthtree.adapter.timerange;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import org.json.simple.JSONArray;

import static edu.northeastern.truthtree.AppConst.TIME_RANGE_FILE_PATH;

public class TimeRangeMockAdapter implements ITimeRangeAdapter {


    @Override
    public JSONArray getTimeRange() {
        return JSONUtil.readJSONFile(TIME_RANGE_FILE_PATH);
    }
}
