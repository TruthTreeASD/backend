package edu.northeastern.truthtree.controller.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;


public interface IStories {
  /**
   * Posts a user story.
   *
   * @param storyDTO containing details of the story
   * @return storyDTO
   */
  StoryDTO createStory(StoryDTO storyDTO);

  /**
   * Returns all the posted stories. If storyState is not provided, it returns all by default to an
   * admin, approved to a non-admin user. If orderType is not provided, it returns story with max
   * upvotes (more popular story).
   *
   * @return list of stories
   */
  List<StoryDTO> getStories(OrderType orderType, StoryStatus storyStatus);

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

  /**
   * Approves a given story.
   *
   * @return story DTO
   */
  StoryDTO approveStory(String id);

  /**
   * Upvote a story.
   *
   * @param id   corresponding to story id
   * @param type corresponding to action upvote or downvote
   */
  StoryDTO updateVotes(String id, String type);

  /**
   * Deletes story from the system.
   *
   * @param id corresponding to the story id in String.
   */
  void deleteStory(String id);

}
