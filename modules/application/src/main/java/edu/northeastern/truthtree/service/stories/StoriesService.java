package edu.northeastern.truthtree.service.stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import edu.northeastern.truthtree.adapter.stories.IStoriesAdapter;
import edu.northeastern.truthtree.dto.NameValueDTO;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;

@Component
public class StoriesService implements IStoriesService {
  private IStoriesAdapter adapter;

  @Autowired
  public StoriesService(@Qualifier("storiesDBAdapter") IStoriesAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public StoryDTO createStory(StoryDTO storyDTO) {
    return adapter.createStory(storyDTO);
  }

  @Override
  public List<StoryDTO> getStories(OrderType orderType, StoryStatus storyStatus) {
    return adapter.getStories(orderType, storyStatus);
  }

  @Override
  public List<StoryDTO> getApprovedStories() {
    return adapter.getApprovedStories();
  }

  @Override
  public List<StoryDTO> getPendingStories() {
    return adapter.getPendingStories();
  }

  @Override
  public StoryDTO approveStory(String id) {
    return adapter.approveStory(id);
  }

  @Override
  public StoryDTO updateVotes(String id, String type) {
    return adapter.updateVotes(id, type);
  }

  @Override
  public void deleteStory(String id) {
    adapter.deleteStory(id);
  }

  /**
   * Returns supported story order types in name-display value format.
   *
   * @return Object containing list of story order types.
   */
  @Override
  public List<NameValueDTO> getOrderType() {
    List<NameValueDTO> orderTypes = new ArrayList<>();
    for (OrderType type : OrderType.values()) {
      NameValueDTO nameValueDTO = new NameValueDTO();
      nameValueDTO.setName(type.name());
      nameValueDTO.setValue(type.getValue());
      orderTypes.add(nameValueDTO);
    }
    return orderTypes;
  }
}
