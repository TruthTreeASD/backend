package edu.northeastern.truthtree.adapter.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.StoryOrder;

public interface IStoriesAdapter {
  StoryDTO createStory(StoryDTO storyDTO);
  List<StoryDTO> getStories(StoryOrder order);

}
