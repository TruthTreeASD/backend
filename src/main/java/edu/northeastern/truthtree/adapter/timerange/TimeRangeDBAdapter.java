package edu.northeastern.truthtree.adapter.timerange;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.json.simple.JSONArray;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import static edu.northeastern.truthtree.AppConst.TIME_RANGE_FILE_PATH;
import static edu.northeastern.truthtree.AppConst.TIME_RANGE_URL;

public class TimeRangeDBAdapter implements ITimeRangeAdapter {

  @Override
  public Object getTimeRange() {
        return JSONUtil.readJSONFile(TIME_RANGE_FILE_PATH);
    }

  @Override
  public Object getTimeRange(String locationId, List<Integer> attributeIds) {
      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TIME_RANGE_URL);
      builder.queryParam("level", locationId);
      for(Integer attributeId : attributeIds) {
          builder.queryParam("attributes", attributeId);
      }
      JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
      Object timerangeResponse = (Object) response.get(0);
      return timerangeResponse;
  }
}
