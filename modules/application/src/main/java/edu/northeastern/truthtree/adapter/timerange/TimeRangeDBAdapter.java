package edu.northeastern.truthtree.adapter.timerange;

import static edu.northeastern.truthtree.AppConst.TIME_RANGE_URL;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.json.simple.JSONArray;

public class TimeRangeDBAdapter implements ITimeRangeAdapter {


  @Override
  public JSONArray getTimeRange() {
    return URLUtil.readJSONFromURL(TIME_RANGE_URL);
  }
}
