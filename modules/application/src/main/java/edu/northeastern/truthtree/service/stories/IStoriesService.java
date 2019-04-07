package edu.northeastern.truthtree.service.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.NameValueDTO;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;

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
  List<StoryDTO> getStories(OrderType orderType, StoryStatus storyStatus);

  /**
   * Changes status of a given story.
   *
   * @return String
   */
  String changeStatusStory(String status, String id);

  /**
   * Updates votes of a type and story id
   *
   * @param storyDTO containing details of the story
   * @param type containing type of update
   * @return storyDTO
   */
  StoryDTO updateVotes(StoryDTO storyDTO, String type);

  /**
   * Deletes story.
   *
   * @param id represents story id in String.
   */
  void deleteStory(String id);

  /**
   * Returns supported story order types in name-display value format.
   *
   * @return Object containing list of story order types.
   */
  List<NameValueDTO> getOrderType();

}
