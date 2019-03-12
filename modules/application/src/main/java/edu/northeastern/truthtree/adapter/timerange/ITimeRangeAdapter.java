package edu.northeastern.truthtree.adapter.timerange;

import java.util.List;

public interface ITimeRangeAdapter {

  /**
   * Returns the time-range response value
   * using
   * @param level and
   * @param attributes
   * @return TimeRange Response Object
   */
  public Object getTimeRange(String level, List<Integer> attributes);
}