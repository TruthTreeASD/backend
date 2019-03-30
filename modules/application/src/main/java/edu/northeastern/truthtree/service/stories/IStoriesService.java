package edu.northeastern.truthtree.service.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import org.json.simple.JSONArray;

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
   * Updates votes of a type and story id
   *
   * @param id represents how story id.
   * @param type represents upvote or downvote.
   * @param value represents upvote or downvote value.
   * @return updated value.
   */
  JSONArray updateVotes(String id, String type, int value);

}
