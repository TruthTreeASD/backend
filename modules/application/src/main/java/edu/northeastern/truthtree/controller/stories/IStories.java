package edu.northeastern.truthtree.controller.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;

public interface IStories {
  /**
   * Posts a user story.
   *
   * @param storyDTO containing details of the story
   * @return storyDTO
   */
  StoryDTO createStory(StoryDTO storyDTO);

  /**
   * Returns all the posted stories.
   *
   * @return list of stories
   */
  List<StoryDTO> getStories();
    /**
   * Returns searched stories.
   *
   * @param List<StoryDTO> containing stories
   * @return storyDTO
   */
  public List<StoryDTO> search(String keyword, int pageSize);
}
