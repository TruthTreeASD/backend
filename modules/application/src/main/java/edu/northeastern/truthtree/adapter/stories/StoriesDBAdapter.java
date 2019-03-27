package edu.northeastern.truthtree.adapter.stories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import edu.northeastern.truthtree.assembler.StoriesAssembler;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.StoryOrder;

import static edu.northeastern.truthtree.AppConst.STORIES_URL_GET;
import static edu.northeastern.truthtree.AppConst.STORIES_URL_POST;

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
    return assembler.fromJSONStringToDTO(jsonResponse);
  }

  @Override
  public List<StoryDTO> getStories(StoryOrder order) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STORIES_URL_GET);
    String fieldName = null;
    String orderType = null;
    if (StoryOrder.RECENT.equals(order)) {
      fieldName = "timestamp";
      orderType = "timestamp";
    } else if (order == null || StoryOrder.MOST_UPVOTES.equals(order)) {
      fieldName = "upvote";
      orderType = "upvote";
    } else if (StoryOrder.MOST_DOWNVOTES.equals(order)) {
      fieldName = "downvote";
      orderType = "downvote";
    }
    builder.queryParam("sortBy", fieldName);
    builder.queryParam("orderType", orderType);
    String url = builder.toUriString();
    String jsonResponse = URLUtil.readJSONFromURLInString(url);
    return assembler.fromJSONStringToDTOList(jsonResponse);
  }
}
