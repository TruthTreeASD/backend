package edu.northeastern.truthtree.service.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.StoryOrder;

public interface IStoriesService {
  StoryDTO createStory(StoryDTO storyDTO);

  List<StoryDTO> getStories(StoryOrder storyOrder);
}
