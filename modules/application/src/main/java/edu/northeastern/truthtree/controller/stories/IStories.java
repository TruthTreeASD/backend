package edu.northeastern.truthtree.controller.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;


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
  List<StoryDTO> getStories(OrderType orderType);

  /**
   * Returns the approved stories.
   *
   * @return list of approved stories
   */
  List<StoryDTO> getApprovedStories();

  /**
   * Returns the pending stories.
   *
   * @return list of pending stories
   */
  List<StoryDTO> getPendingStories();
}
