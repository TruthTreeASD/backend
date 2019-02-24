package edu.northeastern.truthtree.adapter.timerange;

import static edu.northeastern.truthtree.AppConst.TIME_RANGE_FILE_PATH;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import org.json.simple.JSONArray;

public class TimeRangeMockAdapter implements ITimeRangeAdapter {


  @Override
  public JSONArray getTimeRange() {
    return JSONUtil.readJSONFile(TIME_RANGE_FILE_PATH);
  }
}
