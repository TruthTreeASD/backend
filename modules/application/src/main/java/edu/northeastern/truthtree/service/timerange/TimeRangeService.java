package edu.northeastern.truthtree.service.timerange;

import edu.northeastern.truthtree.adapter.timerange.ITimeRangeAdapter;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeRangeService implements ITimeRangeService {

  private ITimeRangeAdapter adapter;

  @Autowired
  public TimeRangeService(ITimeRangeAdapter adapter) {
    this.adapter = adapter;
  }

  /**
   * Returns the time-range response value
   * using
   * @param level and
   * @param attributes
   * @return TimeRange Response Object
   */
  @Override
  public Object getTimeRange(String level, List<Integer> attributes) {
    return adapter.getTimeRange(level, attributes);
  }
}
