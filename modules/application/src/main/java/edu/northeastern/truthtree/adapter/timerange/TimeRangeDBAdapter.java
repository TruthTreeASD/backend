package edu.northeastern.truthtree.adapter.timerange;

import static edu.northeastern.truthtree.AppConst.TIME_RANGE_URL;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.json.simple.JSONArray;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class TimeRangeDBAdapter implements ITimeRangeAdapter {

  /**
   * Returns the time-range response value
   * using
   * @param level and
   * @param attributes
   * @return TimeRange Response Object
   */
  @Override
  public Object getTimeRange(String level, List<Integer> attributes) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TIME_RANGE_URL);
    builder.queryParam("level", level);
    for(Integer attributeId : attributes) {
      builder.queryParam("attributes", attributeId);
    }
    JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
    Object timerangeResponse = (Object) response.get(0);
    return timerangeResponse;
  }
}
