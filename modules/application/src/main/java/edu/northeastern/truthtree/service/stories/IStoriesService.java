package edu.northeastern.truthtree.service.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;

public interface IStoriesService {
  StoryDTO createStory(StoryDTO storyDTO);

  List<StoryDTO> getStories();

  public List<StoryDTO> search(String keyword, int pageSize);
}
