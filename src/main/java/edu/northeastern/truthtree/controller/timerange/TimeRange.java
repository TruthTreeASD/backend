package edu.northeastern.truthtree.controller.timerange;

import edu.northeastern.truthtree.controller.attributes.IAttributes;
import edu.northeastern.truthtree.controller.collections.ICollections;
import edu.northeastern.truthtree.service.timerange.ITimeRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Represents implementation for {@link ITimeRange}. A time-range is
 * list of collection with it's attributes and
 * startYear + endYear values in TruthTree.
 * To know more about collections and attributes,
 * see {@link ICollections} and {@link IAttributes}
 *
 * @author amitmangotra
 *
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TimeRange implements ITimeRange {

  private ITimeRangeService service;

  @Autowired
  public TimeRange(ITimeRangeService service) {
    this.service = service;
  }

  /**
   * Represents TimeRange interface. With required query parameters of
   * level and attributes
   *
   * @param level
   *            which represents unique level i.e. state, city or county.
   * @param attributes
   *            which represents a list of attribute ids.
   *
   * @author amitmangotra
   *
   */
  @Override
  @RequestMapping(value = "/api/time_range", method = RequestMethod.GET)
  public ResponseEntity<Object> getTimeRange(@RequestParam(name = "level", required = true) String level,
                                             @RequestParam(name = "attributes", required = true)
                                                     List<Integer> attributes) {
      Object response = service.getTimeRange(level, attributes);
      return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
