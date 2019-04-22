package edu.northeastern.truthtree.adapter.timerange;

import static edu.northeastern.truthtree.AppConst.TIME_RANGE_URL;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import java.util.List;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class TimeRangeDBAdapter implements ITimeRangeAdapter {

  @Value("${databaseUrl}")
  private String dbEndpoint;

  /**
   * Returns the time-range response value
   * using
   * @param level and
   * @param attributes
   * @return TimeRange Response Object
   */
  @Override
  public Object getTimeRange(String level, List<Integer> attributes) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(dbEndpoint + TIME_RANGE_URL);
    builder.queryParam("level", level);
    for(Integer attributeId : attributes) {
      builder.queryParam("attributes", attributeId);
    }
    JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
    Object timerangeResponse = (Object) response.get(0);
    return timerangeResponse;
  }
}
