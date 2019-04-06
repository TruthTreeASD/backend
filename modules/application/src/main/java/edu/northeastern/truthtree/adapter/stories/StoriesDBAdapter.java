package edu.northeastern.truthtree.adapter.stories;

import static edu.northeastern.truthtree.AppConst.STORIES_URL_APPROVE_STORY;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_DELETE;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_GET;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_GET_APPROVED;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_GET_PENDING;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_POST;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_UPDATE_VOTES;
import static edu.northeastern.truthtree.adapter.utilities.URLUtil.putJSONFromURL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jndi.toolkit.url.UrlUtil;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import edu.northeastern.truthtree.assembler.StoriesAssembler;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
  public List<StoryDTO> getStories(OrderType order) {
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
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STORIES_URL_GET + "/" + fieldName);
    builder.queryParam("orderType", sortBy);
    String url = builder.toUriString();
    String jsonResponse = URLUtil.readJSONFromURLInString(url);
    return assembler.fromJSONStringToDTOList(jsonResponse);
  }

  @Override
  public List<StoryDTO> getApprovedStories() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STORIES_URL_GET_APPROVED);
    String url = builder.toUriString();
    String jsonResponse = URLUtil.readJSONFromURLInString(url);
    return assembler.fromJSONStringToDTOList(jsonResponse);
  }

  @Override
  public List<StoryDTO> getPendingStories() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STORIES_URL_GET_PENDING);
    String url = builder.toUriString();
    String jsonResponse = URLUtil.readJSONFromURLInString(url);
    return assembler.fromJSONStringToDTOList(jsonResponse);
  }

  @Override
  public StoryDTO approveStory(String id) {
    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("id", id);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STORIES_URL_APPROVE_STORY);
    String url = builder.buildAndExpand(uriParams).toUriString();
    String jsonResponse = URLUtil.readJSONFromURLInString(url);
    return assembler.fromJSONStringToDTO(jsonResponse);
  }

  @Override
  public StoryDTO updateVotes(String id, String type) {
    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("id", id);
    uriParams.put("voteType", type);

    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(STORIES_URL_UPDATE_VOTES);
    String url = builder.buildAndExpand(uriParams).toUriString();

    String response = putJSONFromURL(url);
    return assembler.fromJSONStringToDTO(response);
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
