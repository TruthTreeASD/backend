package edu.northeastern.truthtree.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.northeastern.truthtree.dto.StoryPaginationResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import edu.northeastern.truthtree.dto.StoryDTO;
import edu.northeastern.truthtree.dto.StoryDTOWrapper;
import edu.northeastern.truthtree.dto.StoryDTOWrapperList;


@Component
public class StoriesAssembler {

  private ObjectMapper mapper;

  @Autowired
  public StoriesAssembler(ObjectMapper mapper) {
    this.mapper = mapper;

  }

  public List<StoryDTO> fromJSONStringToDTOList(String jsonString) {
    StoryDTOWrapperList storyDTO = new StoryDTOWrapperList();
    try {
      storyDTO = mapper.readValue(jsonString, StoryDTOWrapperList.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return storyDTO.getData().getData();
  }

  public StoryDTO fromJSONStringToDTO(String jsonString) {
    StoryDTOWrapper storyDTO = new StoryDTOWrapper();
    try {
      storyDTO = mapper.readValue(jsonString, StoryDTOWrapper.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return storyDTO.getData();
  }

  public StoryPaginationResponseDTO fromJSONStringToPaginationDTO(String jsonString) {
    StoryDTOWrapperList storyDTO = new StoryDTOWrapperList();
    StoryPaginationResponseDTO storyPaginationResponseDTO = new StoryPaginationResponseDTO();
    try {
      storyDTO = mapper.readValue(jsonString, StoryDTOWrapperList.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    storyPaginationResponseDTO.setData(storyDTO.getData().getData());
    storyPaginationResponseDTO.setTotal(storyDTO.getData().getTotal());
    storyPaginationResponseDTO.setCurrentPage(storyDTO.getData().getCurrentPage());
    storyPaginationResponseDTO.setPageSize(storyDTO.getData().getPageSize());
    storyPaginationResponseDTO.setTotalPage(storyDTO.getData().getTotalPage());
    return storyPaginationResponseDTO;
  }

}
