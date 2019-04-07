package edu.northeastern.truthtree.adapter.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;

public interface IStoriesAdapter {

  /**
   * Calls external services to create a story.
   *
   * @param storyDTO containing details of the story.
   * @return containing details of the story.
   */
  StoryDTO createStory(StoryDTO storyDTO);

  /**
   * Returns stories specified in the order {@link OrderType}
   *
   * @param order containing specified order.
   * @return list of stories.
   */
  List<StoryDTO> getStories(OrderType order, StoryStatus storyStatus);

  /**
   * Change status of a given story.
   *
   */
  void changeStatus(StoryStatus status, String id);

  /**
   * Update votes of a story.
   *
   * @param storyDTO containing details of the story
   * @param type containing type of update
   * @return storyDTO
   */
  StoryDTO updateVotes(StoryDTO storyDTO, String type);

  /**
   * Deletes story.
   *
   * @param id corresponding to story id
   */
  void deleteStory(String id);
}
