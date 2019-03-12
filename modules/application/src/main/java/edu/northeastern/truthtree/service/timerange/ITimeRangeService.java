package edu.northeastern.truthtree.service.timerange;

import java.util.List;

public interface ITimeRangeService {

  /**
   * Returns the time-range response value
   * using
   * @param level and
   * @param attributes
   * @return TimeRange Response Object
   */
  Object getTimeRange(String level, List<Integer> attributes);

}
