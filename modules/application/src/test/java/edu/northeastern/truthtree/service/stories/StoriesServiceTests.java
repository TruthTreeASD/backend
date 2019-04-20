package edu.northeastern.truthtree.service.stories;

import edu.northeastern.truthtree.adapter.stories.StoriesDBAdapter;
import edu.northeastern.truthtree.dto.NameValueDTO;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.dto.StoryPaginationResponseDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;
import edu.northeastern.truthtree.enums.VoteType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.hamcrest.collection.IsIterableContainingInOrder;


@RunWith(MockitoJUnitRunner.class)
public class StoriesServiceTests {

    @Mock
    private StoriesDBAdapter storiesDBAdapter;

    @InjectMocks
    private StoriesService storiesService;

    @Before
    public void setup() {
        storiesService = new StoriesService(storiesDBAdapter);
    }

    @Test
    public void testCreateStory() {
        StoryDTO storyDTO = new StoryDTO();
        storyDTO.setId("1");
        storyDTO.setAuthor("Mark");
        storyDTO.setContent("testing story creation");
        List<String> tags = new ArrayList<>();
        tags.add("psuedo_tag1");
        tags.add("psuedo_tag2");
        tags.add("psuedo_tag3");
        storyDTO.setTags(tags);
        StoryDTO actual = storiesDBAdapter.createStory(storyDTO);
        assertEquals(actual, storiesService.createStory(storyDTO));
    }

    @Test
    public void testChangeStatus() {
        String id = "string1554848255796";
        StoryStatus status = StoryStatus.APPROVED;
        doNothing().when(storiesDBAdapter).changeStatus(status, id);
        storiesService.changeStatus(status, id);
        verify(storiesDBAdapter).changeStatus(status, id);
    }

    @Test
    public void testUpdateVotes() {
        StoryDTO storyDTO = new StoryDTO();
        storyDTO.setId("1");
        storyDTO.setAuthor("Mark");
        storyDTO.setContent("testing story creation");
        List<String> tags = new ArrayList<>();
        tags.add("psuedo_tag1");
        tags.add("psuedo_tag2");
        tags.add("psuedo_tag3");
        storyDTO.setTags(tags);
        VoteType voteType = VoteType.UPVOTE;
        StoryDTO actual = storiesDBAdapter.updateVotes(storyDTO, voteType);
        assertEquals(actual, storiesService.updateVotes(storyDTO, voteType));
    }

    @Test
    public void testDeleteStory() {
        String id = "string1554848255796";
        doNothing().when(storiesDBAdapter).deleteStory(id);
        storiesService.deleteStory(id);
        verify(storiesDBAdapter, times(1)).deleteStory(id);
    }

    @Test
    public void testSearch() {
        String keyword = "mass";
        Integer pageSize = 5;
        Integer pageNumber = 2;
        OrderType orderType = OrderType.RECENT;
        StoryPaginationResponseDTO actual = storiesDBAdapter.search(keyword, pageSize, pageNumber, orderType);
        assertEquals(actual, storiesService.search(keyword, pageSize, pageNumber, orderType));
    }

    @Test
    public void testGetStories() {
        OrderType orderType = OrderType.RECENT;
        StoryStatus status = StoryStatus.APPROVED;
        Integer pageSize = 5;
        Integer currentPage = 2;
        StoryPaginationResponseDTO actual = storiesDBAdapter.getStories(orderType, status, pageSize, currentPage);
        assertEquals(actual, storiesService.getStories(orderType, status, pageSize, currentPage));
    }

//    @Test
//    public void testGetOrderType() {
//        List<NameValueDTO> actual = new ArrayList<>();
//        for (OrderType orderType : OrderType.values()) {
//            NameValueDTO nv = new NameValueDTO();
//            nv.setName(orderType.name());
//            nv.setValue(orderType.getValue());
//            actual.add(nv);
//        }
//        List<NameValueDTO> expected = storiesService.getOrderType();
//        assertArrayEquals(expected.toArray(), actual.toArray());
//    }


}
