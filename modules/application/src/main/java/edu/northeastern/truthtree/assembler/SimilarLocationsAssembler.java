package edu.northeastern.truthtree.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import edu.northeastern.truthtree.dto.LocationDTOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

@Component
public class SimilarLocationsAssembler {

  private ObjectMapper mapper;

  @Autowired
  public SimilarLocationsAssembler(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public LocationDTO getJSONStringToLocationDTO(String jsonStr) {
    LocationDTOWrapper locationDTO = new LocationDTOWrapper();
    try {
      locationDTO = mapper.readValue(jsonStr, LocationDTOWrapper.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return locationDTO.getData();
  }

  public List<CommonAttributeDTO> getJSONStringToCommonAttributeDTOList(String jsonStr) {
    List<CommonAttributeDTO> commonAttributeDTOList = new ArrayList<>();
    try {
      CollectionType collectionType = mapper
              .getTypeFactory()
              .constructCollectionType(List.class, CommonAttributeDTO.class);
      commonAttributeDTOList = mapper.readValue(jsonStr, collectionType);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return commonAttributeDTOList;
  }

  public List<LocationDTO> getJSONStringToSimilarPlacesDTOList(String jsonStr) {
    List<SimilarPlacesDTO> similarPlacesDTOList = null;
    List<LocationDTO> locationDTOList = null;
    try {
      CollectionType collectionType = mapper
              .getTypeFactory()
              .constructCollectionType(List.class, SimilarPlacesDTO.class);
      similarPlacesDTOList = mapper.readValue(jsonStr, collectionType);

      locationDTOList = similarPlacesDTOList.stream().map(similarPlacesDTO ->
              new LocationDTO
                      .Builder()
                      .withId(similarPlacesDTO.getPlace_id())
                      .build()).collect(Collectors.toList());

    } catch (Exception e) {
      e.printStackTrace();
    }
    return locationDTOList;
  }

}
