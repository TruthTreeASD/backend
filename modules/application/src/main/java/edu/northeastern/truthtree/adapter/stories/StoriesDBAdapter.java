package edu.northeastern.truthtree.adapter.stories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import edu.northeastern.truthtree.assembler.StoriesAssembler;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;

import static edu.northeastern.truthtree.AppConst.STORIES_URL_GET;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_POST;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_UPDATE_VOTES;
import static edu.northeastern.truthtree.adapter.utilities.URLUtil.putJSONFromURL;

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
    String jsonResponse = URLUtil.postJSONFromURL(STORIES_URL_POST, jsonString);
//    return assembler.fromJSONStringToDTO(jsonResponse);
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
    System.out.println(url);
    String jsonResponse = URLUtil.readJSONFromURLInString(url);
    return assembler.fromJSONStringToDTOList(jsonResponse);
  }

  @Override
  public JSONArray updateVotes(String id, String type, int value) {
    Map<String, String> uriParams = new HashMap<String, String>();
    uriParams.put("id", id);

    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(STORIES_URL_UPDATE_VOTES);

    builder.queryParam("voteType", type);
    builder.queryParam("value", value);

    String url = builder.buildAndExpand(uriParams).toUriString();

    String response = putJSONFromURL(url);
    return JSONUtil.stringToJSONArray(response);
  }
}
