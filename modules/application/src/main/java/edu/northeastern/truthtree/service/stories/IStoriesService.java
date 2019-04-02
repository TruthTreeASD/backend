package edu.northeastern.truthtree.service.stories;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import java.util.List;

public interface IStoriesService {
  /**
   * Creates a story with the parameters provided in {@link StoryDTO}.
   *
   * @param storyDTO containing details of story.
   * @return storyDTO containing new story to be created.
   */
  StoryDTO createStory(StoryDTO storyDTO);

  /**
   * Returns list of stories specified in the {@link OrderType}.
   *
   * @param orderType represents how story will be sorted.
   * @return list of stories.
   */
  List<StoryDTO> getStories(OrderType orderType);

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
   * Updates votes of a type and story id
   *
   * @param id represents how story id.
   * @param type represents upvote or downvote.
   * @return updated value.
   */
  StoryDTO updateVotes(String id, String type);

}
