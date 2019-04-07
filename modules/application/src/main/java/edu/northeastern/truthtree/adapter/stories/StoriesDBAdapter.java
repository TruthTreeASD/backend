package edu.northeastern.truthtree.adapter.stories;

import static edu.northeastern.truthtree.AppConst.STORIES_URL_CHANGE_STATUS;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_DELETE;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_GET;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_POST;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_UPDATE_VOTES;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import edu.northeastern.truthtree.assembler.StoriesAssembler;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component("storiesDBAdapter")
public class StoriesDBAdapter implements IStoriesAdapter {

  private StoriesAssembler assembler;

  @Autowired
  public StoriesDBAdapter(StoriesAssembler assembler) {
    this.assembler = assembler;
  }

  @Override
  public StoryDTO createStory(StoryDTO storyDTO) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "";
    try {
      jsonString = mapper.writeValueAsString(storyDTO);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    URLUtil.postJSONFromURL(STORIES_URL_POST, jsonString);
    return storyDTO;
  }

  @Override
  public List<StoryDTO> getStories(OrderType order, StoryStatus storyStatus) {
    String fieldName = null;
    String sortBy = null;
    if (order == null) {
      fieldName = "upvote";
      sortBy = "desc";
    } else {
      switch (order) {
        case RECENT:
          fieldName = "timestamp";
          sortBy = "desc";
          break;
        case MOST_UPVOTES:
          fieldName = "upvote";
          sortBy = "desc";
          break;
        case MOST_DOWNVOTES:
          fieldName = "downvote";
          sortBy = "desc";
          break;
        case OLDEST:
          fieldName = "timestamp";
          sortBy = "asc";
          break;
        default:
          fieldName = "upvote";
          sortBy = "desc";
      }
    }
    Map<String, String> uriParams = new HashMap<String, String>();
    if (storyStatus == null) {
      uriParams.put("status", StoryStatus.APPROVED.name());
    } else {
      uriParams.put("status", storyStatus.name());
    }
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STORIES_URL_GET);
    builder.queryParam("order", sortBy);
    builder.queryParam("orderBy", fieldName);
    String url = builder.buildAndExpand(uriParams).toUriString();
    String jsonResponse = URLUtil.readJSONFromURLInString(url);
    return assembler.fromJSONStringToDTOList(jsonResponse);
  }

  @Override
  public void changeStatus(StoryStatus status, String id) {
    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("status", status.name());
    uriParams.put("id", id);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STORIES_URL_CHANGE_STATUS);
    String url = builder.buildAndExpand(uriParams).toUriString();
    URLUtil.putJSONFromURL(url);
  }

  @Override
  public StoryDTO updateVotes(StoryDTO storyDTO, String type) {
    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("id", storyDTO.getId());
    uriParams.put("voteType", type);

    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(STORIES_URL_UPDATE_VOTES);
    String url = builder.buildAndExpand(uriParams).toUriString();

    URLUtil.putJSONFromURL(url);
    if (type.equals("UPVOTE")) {
      storyDTO.setUpvote(storyDTO.getUpvote() + 1);
    } else if (type.equals("DOWNVOTE")) {
      storyDTO.setDownvote(storyDTO.getDownvote() + 1);
    }
    return storyDTO;
  }

  @Override
  public void deleteStory(String id) {
    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("id", id);
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(STORIES_URL_DELETE);
    String url = builder.buildAndExpand(uriParams).toUriString();
    URLUtil.deleteJSONFromURL(url);
  }
}
