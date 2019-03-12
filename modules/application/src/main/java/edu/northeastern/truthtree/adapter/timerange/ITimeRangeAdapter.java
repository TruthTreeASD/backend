package edu.northeastern.truthtree.adapter.timerange;

import java.util.List;

public interface ITimeRangeAdapter {

  /**
   * Get time-range without any parameters.
   * @return time-range response
   */
//  public Object getTimeRange();

  /**
   * Get time-range with level and attribute id list.
   * @param level level value - state, county or city
   * @param attributeIds attribute id list
   * @return time-range response
   */
  public Object getTimeRange(String level, List<Integer> attributeIds);

}