package edu.northeastern.truthtree.controller.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.NameValueDTO;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.dto.StoryPaginationResponseDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;
import edu.northeastern.truthtree.enums.VoteType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
  StoryPaginationResponseDTO getStories(OrderType orderType, StoryStatus storyStatus,
      Integer pageSize, Integer currentPage, HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse);

  /**
   * Changes status of a given story.
   *
   * @param status corresponding to status of story
   * @param id corresponding to the story id in String.
   * @param httpServletRequest corresponding to the client request.
   * @param httpServletResponse corresponding to the sserver response.
   */
  void changeStatus(StoryStatus status, String id, HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse);

  /**
   * Upvote a story.
   *
   * @param storyDTO containing details of the story
   * @param type containing the type of update
   * @return storyDTO
   */
  StoryDTO updateVotes(StoryDTO storyDTO, VoteType type);

  /**
   * Deletes story from the system.
   *
   * @param id corresponding to the story id in String.
   * @param httpServletRequest corresponding to the client request.
   * @param httpServletResponse corresponding to the sserver response.
   */
  void deleteStory(String id, HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse);

  /**
   * Returns all order of stories supported by system.
   *
   * @return list containing name value pairs of {@link OrderType}
   */
  List<NameValueDTO> getOrderType();

  /**
   * Returns searched stories.
   *
   * @param keyword containing a string of keywords
   * @param pageSize , the number of stories per page
   * @param pageNumber pageNumber, the number of the page of stories returned
   * @param orderBy ordertype, the available order types
   * @return List<StoryDTO> containing stories
   */
  StoryPaginationResponseDTO search(String keyword, Integer pageSize, Integer pageNumber,
      OrderType orderBy);
}
