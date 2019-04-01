package edu.northeastern.truthtree.controller.stories;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.service.stories.IStoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
  public List<StoryDTO> getStories(@RequestParam(value = "orderType", required = false) OrderType orderType) {
    return service.getStories(orderType);
  }

  @RequestMapping(value = "/api/stories/{id}", method = RequestMethod.PUT)
  public StoryDTO updateVotes( @PathVariable String id,
      @RequestParam(value = "type", required = true) String type) {
    return service.updateVotes(id, type);
  }

}
