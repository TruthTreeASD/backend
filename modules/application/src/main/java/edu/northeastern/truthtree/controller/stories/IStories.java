package edu.northeastern.truthtree.controller.stories;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import java.util.List;


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

  /**
   * Approves a given story.
   *
   * @return story DTO
   */
  StoryDTO approveStory(String id);

  /**
   * Upvote a story.
   *
   * @param id corresponding to story id
   * @param type corresponding to action upvote or downvote
   */
 StoryDTO updateVotes(String id, String type);

}
