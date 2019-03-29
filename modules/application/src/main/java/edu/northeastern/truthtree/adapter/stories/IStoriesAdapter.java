package edu.northeastern.truthtree.adapter.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;

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

}
