package edu.northeastern.truthtree.adapter.timerange;

//import static edu.northeastern.truthtree.AppConst.TIME_RANGE_FILE_PATH;
import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import java.util.List;

public class TimeRangeMockAdapter implements ITimeRangeAdapter {

//  @Override
//  public Object getTimeRange() {
//      return JSONUtil.readJSONFile(TIME_RANGE_FILE_PATH);
//  }
  @Override
  public Object getTimeRange(String level, List<Integer> attributes) {
//      return JSONUtil.readJSONFile(TIME_RANGE_FILE_PATH);
      return null;
  }
}
