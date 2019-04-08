package edu.northeastern.truthtree.adapter.stories;

import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;

public class StoriesDBAdapter implements IStoriesAdapter{

  @Override
  public StoryDTO createStory(StoryDTO storyDTO) {
    return null;
  }

  @Override
  public List<StoryDTO> getStories() {
    return null;
  }
  @Override
  public List<StoryDTO> search(String keyword, int pageSize, int currentPage) {
   Map<String, String> uriParams = new HashMap<String, String>();
   uriParams.put("keyword", keyword);
   UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(STORIES_URL_GET);
   builder.queryParam("pageSize", pageSize);
   builder.queryParam("currentPage", currentPage);
   String url = builder.buildAndExpand(uriParams).toUriString();
   String jsonResponse = URLUtil.readJSONFromURLInString(url);
   return assembler.fromJSONStringToDTOList(jsonResponse);
 }
}
