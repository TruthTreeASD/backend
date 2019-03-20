package edu.northeastern.truthtree.adapter.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;

public interface IStoriesAdapter {
  StoryDTO createStory(StoryDTO storyDTO);
  List<StoryDTO> getStories();
}
