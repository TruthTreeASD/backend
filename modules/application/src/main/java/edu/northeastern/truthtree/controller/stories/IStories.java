package edu.northeastern.truthtree.controller.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import org.json.simple.JSONArray;


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
   * Upvote a story.
   *
   * @param id corresponding to story id
   * @param type corresponding to action upvote or downvote
   * @param value corresponding to updated value of votes
   */
 JSONArray updateVotes(String id, String type, int value);

}
