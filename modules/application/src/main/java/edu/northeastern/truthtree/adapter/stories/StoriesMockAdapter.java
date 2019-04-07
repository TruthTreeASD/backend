package edu.northeastern.truthtree.adapter.stories;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("storiesMockAdapter")
public class StoriesMockAdapter implements IStoriesAdapter {

  @Override
  public StoryDTO createStory(StoryDTO storyDTO) {
    storyDTO.setId("43232233323");
    return storyDTO;
  }

  @Override
  public List<StoryDTO> getStories(OrderType order, StoryStatus storyStatus) {
    List<StoryDTO> response = new ArrayList<>();
    StoryDTO storyDTO1 = new StoryDTO();
    storyDTO1.setId("43232233323");
    storyDTO1.setAuthor("Alice");
    List<String> tags1 = new ArrayList<>();
    tags1.add("Finance");
    tags1.add("Crime");
    storyDTO1.setTags(tags1);
    storyDTO1.setContent("This is my first post");

    StoryDTO storyDTO2 = new StoryDTO();
    storyDTO2.setId("4323223321993");
    storyDTO2.setAuthor("Bob");
    List<String> tags2 = new ArrayList<>();
    tags2.add("Finance");
    tags2.add("Debt");
    storyDTO2.setTags(tags2);
    storyDTO2.setContent("This is my second post");

    response.add(storyDTO1);
    response.add(storyDTO2);
    return response;
  }

  public StoryDTO updateVotes(String id, String type) {
    StoryDTO storyDTO1 = new StoryDTO();
    storyDTO1.setId("43232233323");
    storyDTO1.setAuthor("Alice");
    List<String> tags1 = new ArrayList<>();
    tags1.add("Finance");
    tags1.add("Crime");
    storyDTO1.setTags(tags1);
    storyDTO1.setContent("This is my first post");
    return storyDTO1;
  }

  @Override
  public void deleteStory(String id) {

  }

  @Override
  public String changeStatusStory(String status, String id) {
    return "";
  }
}
