package edu.northeastern.truthtree.service.stories;

import edu.northeastern.truthtree.adapter.stories.IStoriesAdapter;
import edu.northeastern.truthtree.dto.NameValueDTO;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.dto.StoryPaginationResponseDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;
import edu.northeastern.truthtree.enums.VoteType;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
  public StoryPaginationResponseDTO getStories(OrderType orderType, StoryStatus storyStatus, Integer pageSize, Integer currentPage) {
    return adapter.getStories(orderType, storyStatus, pageSize, currentPage);
  }

  @Override
  public void changeStatus(StoryStatus status, String id) {
    adapter.changeStatus(status, id);
  }

  @Override
  public StoryDTO updateVotes(StoryDTO storyDTO, VoteType type) {
    return adapter.updateVotes(storyDTO, type);
  }

  @Override
  public void deleteStory(String id) {
    adapter.deleteStory(id);
  }

  @Override
  public StoryPaginationResponseDTO search(String keyword, Integer pageSize, Integer pageNumber, OrderType orderType) {
    return adapter.search(keyword, pageSize, pageNumber, orderType);
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
