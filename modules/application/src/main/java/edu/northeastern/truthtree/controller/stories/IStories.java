package edu.northeastern.truthtree.controller.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.NameValueDTO;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.dto.StoryPaginationResponseDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;
import edu.northeastern.truthtree.enums.VoteType;


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
  StoryPaginationResponseDTO getStories(OrderType orderType, StoryStatus storyStatus, Integer pageSize, Integer currentPage);

  /**
   * Changes status of a given story.
   */
  void changeStatus(StoryStatus status, String id);

  /**
   * Upvote a story.
   *
   * @param storyDTO containing details of the story
   * @param type     containing the type of update
   * @return storyDTO
   */
  StoryDTO updateVotes(StoryDTO storyDTO, VoteType type);

  /**
   * Deletes story from the system.
   *
   * @param id corresponding to the story id in String.
   */
  void deleteStory(String id);

  /**
   * Returns all order of stories supported by system.
   *
   * @return list containing name value pairs of {@link OrderType}
   */
  List<NameValueDTO> getOrderType();

  /**
   * Returns searched stories.
   *
   * @param keyword    containing a string of keywords
   * @param pageSize   , the number of stories per page
   * @param pageNumber pageNumber, the number of the page of stories returned
   * @return List<StoryDTO> containing stories
   */
  List<StoryDTO> search(String keyword, Integer pageSize, Integer pageNumber);


}
