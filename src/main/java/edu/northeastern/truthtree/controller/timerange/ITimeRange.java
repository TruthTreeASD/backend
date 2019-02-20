package edu.northeastern.truthtree.controller.timerange;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITimeRange {

    /**
     * Returns time-range for TimeRange API.
     *
     * @param level
     *            level value - state, city or county
     * @param attributes
     *            attribute id list
     * @return time-range response
     */
    ResponseEntity getTimeRange(String level, List<Integer> attributes);

}
