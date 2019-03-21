package edu.northeastern.truthtree.service.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import edu.northeastern.truthtree.adapter.stories.IStoriesAdapter;
import edu.northeastern.truthtree.dto.StoryDTO;

@Component
public class StoriesService implements IStoriesService {
  private IStoriesAdapter adapter;

  @Autowired
  public StoriesService(IStoriesAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public StoryDTO createStory(StoryDTO storyDTO) {
    return adapter.createStory(storyDTO);
  }

  @Override
  public List<StoryDTO> getStories() {
    return adapter.getStories();
  }
}
