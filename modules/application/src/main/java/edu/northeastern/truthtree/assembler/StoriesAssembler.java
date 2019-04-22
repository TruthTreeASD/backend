package edu.northeastern.truthtree.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.dto.StoryDTOWrapper;
import edu.northeastern.truthtree.dto.StoryDTOWrapperList;
import edu.northeastern.truthtree.dto.StoryPaginationResponseDTO;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StoriesAssembler {

  /**
   * Initializing Jackson Object Mapper
   */
  private ObjectMapper mapper;

  @Autowired
  public StoriesAssembler(ObjectMapper mapper) {
    this.mapper = mapper;

  }

  /**
   * Given a JSON Response as String
   * @param jsonString
   * @return a {@link List<StoryDTO>}
   * using Jackson Object Mapper
   */
  public List<StoryDTO> fromJSONStringToDTOList(String jsonString) {
    StoryDTOWrapperList storyDTO = new StoryDTOWrapperList();
    try {
      storyDTO = mapper.readValue(jsonString, StoryDTOWrapperList.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return storyDTO.getData().getData();
  }

  /**
   * Given a JSON Response as String
   * @param jsonString
   * @return a {@link StoryDTO}
   * using Jackson Object Mapper
   */
  public StoryDTO fromJSONStringToDTO(String jsonString) {
    StoryDTOWrapper storyDTO = new StoryDTOWrapper();
    try {
      storyDTO = mapper.readValue(jsonString, StoryDTOWrapper.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return storyDTO.getData();
  }

  /**
   * Given a JSON Response as String
   * @param jsonString
   * @return a {@link StoryPaginationResponseDTO}
   * using Jackson Object Mapper
   */
  public StoryPaginationResponseDTO fromJSONStringToPaginationDTO(String jsonString) {
    StoryDTOWrapperList storyDTO = new StoryDTOWrapperList();
    try {
      storyDTO = mapper.readValue(jsonString, StoryDTOWrapperList.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return storyDTO.getData();
  }

}
