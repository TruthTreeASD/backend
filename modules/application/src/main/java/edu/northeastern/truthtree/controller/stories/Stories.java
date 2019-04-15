package edu.northeastern.truthtree.controller.stories;

import edu.northeastern.truthtree.dto.NameValueDTO;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.dto.StoryPaginationResponseDTO;
import edu.northeastern.truthtree.enums.OrderType;
import edu.northeastern.truthtree.enums.StoryStatus;
import edu.northeastern.truthtree.enums.VoteType;
import edu.northeastern.truthtree.service.stories.IStoriesService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Stories implements IStories {

  private IStoriesService service;

  @Autowired
  public Stories(IStoriesService service) {
    this.service = service;
  }

  @RequestMapping(value = "/api/stories", method = RequestMethod.POST)
  public StoryDTO createStory(@RequestBody StoryDTO storyDTO) {
    return service.createStory(storyDTO);
  }

  @RequestMapping(value = "/api/stories", method = RequestMethod.GET)
  public StoryPaginationResponseDTO getStories(
      @RequestParam(value = "orderType", required = false) OrderType orderType,
      @RequestParam(value = "storyStatus", required = false) StoryStatus storyStatus,
      @RequestParam(value = "pageSize", required = false) Integer pageSize,
      @RequestParam(value = "currentPage", required = false) Integer currentPage,
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
  ) {
    if (storyStatus != null && !storyStatus.equals(StoryStatus.APPROVED)) {
      HttpSession httpSession = httpServletRequest.getSession();
      if (httpSession.getAttribute("admin") == null) {
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return null;
      }

    }
    return service.getStories(orderType, storyStatus, pageSize, currentPage);
  }

  @RequestMapping(value = "/api/stories/story/{status}/{id}", method = RequestMethod.PUT)
  public void changeStatus(@PathVariable StoryStatus status, @PathVariable String id,
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    HttpSession httpSession = httpServletRequest.getSession();
    if (httpSession.getAttribute("admin") == null) {
      httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      service.changeStatus(status, id);
    }
  }

  @RequestMapping(value = "/api/stories", method = RequestMethod.PUT)
  public StoryDTO updateVotes(@RequestBody StoryDTO storyDTO,
      @RequestParam(value = "type", required = true) VoteType type) {
    return service.updateVotes(storyDTO, type);
  }

  @Override
  @RequestMapping(value = "/api/stories/{id}", method = RequestMethod.DELETE)
  public void deleteStory(@PathVariable String id, HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    HttpSession httpSession = httpServletRequest.getSession();
    if (httpSession.getAttribute("admin") == null) {
      httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      service.deleteStory(id);
    }
  }

  @RequestMapping(value = "/api/stories/order", method = RequestMethod.GET)
  public List<NameValueDTO> getOrderType() {
    return service.getOrderType();
  }

  @RequestMapping(value = "/api/stories/search", method = RequestMethod.GET)
  public StoryPaginationResponseDTO search(@RequestParam(value = "keyword") String keyword,
      @RequestParam(value = "pageSize", required = false) Integer pageSize,
      @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
      @RequestParam(value = "orderBy", required = false) OrderType orderType) {
    return service.search(keyword, pageSize, pageNumber, orderType);
  }

}
