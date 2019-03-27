package edu.northeastern.truthtree.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.northeastern.truthtree.dto.StoryDTO;


@Component
public class StoriesAssembler {

  private ObjectMapper mapper;

  @Autowired
  public StoriesAssembler(ObjectMapper mapper) {
    this.mapper = mapper;

  }

  public List<StoryDTO> fromJSONStringToDTOList(org.json.simple.JSONArray jsonArray) {
    JSONObject jsonObject = null;
    List<StoryDTO> storyDTOs = new ArrayList<>();
    jsonObject = (JSONObject) jsonArray.get(0);
    Map map = (HashMap) jsonObject;
    org.json.simple.JSONArray respArray = (JSONArray) map.get("data");
    for (int i = 0; i < respArray.size(); i++) {
      StoryDTO dto = new StoryDTO();
      JSONObject resp = (JSONObject) respArray.get(i);
      Map respMap = (HashMap) resp;
      dto.setAuthor((String) respMap.get("author"));
      dto.setTags((List) respMap.get("tags"));
      dto.setContent((String) respMap.get("content"));
      dto.setTitle((String) respMap.get("title"));
      dto.setTimestamp((Long) respMap.get("timestamp"));
      dto.setUpvote((Long) respMap.get("upvote"));
      dto.setDownvote((Long) respMap.get("downvote"));
      dto.setId((String) respMap.get("id"));
      storyDTOs.add(dto);
    }
    return storyDTOs;
  }

  public StoryDTO fromJSONStringToDTO(JSONArray jsonArray) {
    StoryDTO dto = null;
    return fromJSONStringToDTOList(jsonArray).get(0);
  }
}
