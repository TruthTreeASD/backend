package edu.northeastern.truthtree.service.stories;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

import edu.northeastern.truthtree.adapter.stories.IStoriesAdapter;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;

@Component
public class StoriesService implements IStoriesService {
  private IStoriesAdapter adapter;

  @Autowired
  public StoriesService(@Qualifier("storiesDBAdapter") IStoriesAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public StoryDTO createStory(StoryDTO storyDTO) {
    return adapter.createStory(storyDTO);
  }

  @Override
  public List<StoryDTO> getStories(OrderType orderType) {
    return adapter.getStories(orderType);
  }

  @Override
  public StoryDTO updateVotes(String id, String type) {
    return adapter.updateVotes(id, type);
  }

}
