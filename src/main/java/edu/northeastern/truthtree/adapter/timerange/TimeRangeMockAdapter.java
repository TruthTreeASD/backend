package edu.northeastern.truthtree.adapter.timerange;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.json.simple.JSONArray;
import static edu.northeastern.truthtree.AppConst.TIME_RANGE_FILE_PATH;
import java.util.List;

public class TimeRangeMockAdapter implements ITimeRangeAdapter {

    @Override
    public Object getTimeRange() {
        return URLUtil.readJSONFromURL(TIME_RANGE_FILE_PATH);
    }

    @Override
    public Object getTimeRange(String level, List<Integer> attributes) {
        return null;
    }
}
