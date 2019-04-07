package edu.northeastern.truthtree.controller.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
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
  public List<StoryDTO> getStories() {
    return service.getStories();
  }

  @RequestMapping(value = "/api/stories/search", method = RequestMethod.GET)
 public List<StoryDTO> search(@RequestParam(value = "keyword", required = true) String keyword,
                                  @RequestParam(value = "pageSize", required = false) int pageSize) {
   return service.search(keyword, pageSize);
 }
}
