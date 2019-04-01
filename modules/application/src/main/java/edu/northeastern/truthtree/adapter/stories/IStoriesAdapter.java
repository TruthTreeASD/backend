package edu.northeastern.truthtree.adapter.stories;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import java.util.List;

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
  List<StoryDTO> getStories(OrderType order);

  /**
   * Returns list of approved stories.
   *
   * @return list of approved stories.
   */
  List<StoryDTO> getApprovedStories();

  /**
   * Returns list of pending stories.
   *
   * @return list of pending stories.
   */
  List<StoryDTO> getPendingStories();

  /**
   * Approves a given story.
   *
   * @return story DTO
   */
  StoryDTO approveStory(String id);

  /**
   * Update votes of a story.
   *
   * @param id corresponding to story id
   * @param type corresponding to action upvote or downvote
   * @return updated upvotes.
   */
  StoryDTO updateVotes(String id, String type);
}
