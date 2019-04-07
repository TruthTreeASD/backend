package edu.northeastern.truthtree.controller.stories;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import edu.northeastern.truthtree.dto.NameValueDTO;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;
import edu.northeastern.truthtree.service.stories.IStoriesService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Stories implements IStories {
  private IStoriesService service;

  @Autowired
  public Stories(IStoriesService service) {
    this.service = service;
  }

  @RequestMapping(value = "/api/stories", method = RequestMethod.POST)
  public StoryDTO createStory(@RequestBody StoryDTO storyDTO) {
    return service.createStory(storyDTO);
  }

  @RequestMapping(value = "/api/stories", method = RequestMethod.GET)
  public List<StoryDTO> getStories(@RequestParam(value = "orderType", required = false) OrderType orderType,
                                   @RequestParam(value = "storyStatus", required = false) StoryStatus storyStatus
  ) {
    return service.getStories(orderType, storyStatus);
  }

  @RequestMapping(value = "/api/stories/story/{status}/{id}", method = RequestMethod.PUT)
  public String changeStatusStory(@PathVariable String status, @PathVariable String id) {
    return service.changeStatusStory(status.toUpperCase(), id);
  }

  @RequestMapping(value = "/api/stories/{id}", method = RequestMethod.PUT)
  public StoryDTO updateVotes(@PathVariable String id,
                              @RequestParam(value = "type", required = true) String type) {
    return service.updateVotes(id, type.toUpperCase());
  }

  @Override
  @RequestMapping(value = "/api/stories/{id}", method = RequestMethod.DELETE)
  public void deleteStory(@PathVariable String id) {
    service.deleteStory(id);
  }

  @RequestMapping(value = "/api/stories/order", method = RequestMethod.GET)
  public List<NameValueDTO> getOrderType() {
    return service.getOrderType();
  }

}
