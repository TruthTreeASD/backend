package edu.northeastern.truthtree.adapter.timerange;

import static edu.northeastern.truthtree.AppConst.TIME_RANGE_FILE_PATH;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import org.json.simple.JSONArray;

import java.util.List;

public class TimeRangeMockAdapter implements ITimeRangeAdapter {

  /**
   * Returns the time-range response value
   * using
   * @param level and
   * @param attributes
   * @return TimeRange Response Object
   */
  @Override
  public Object getTimeRange(String level, List<Integer> attributes) {
    return JSONUtil.readJSONFile(TIME_RANGE_FILE_PATH);
  }
}
