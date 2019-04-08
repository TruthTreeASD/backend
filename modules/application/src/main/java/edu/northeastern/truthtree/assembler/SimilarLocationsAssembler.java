package edu.northeastern.truthtree.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.LocationDBResponseDTO;
import edu.northeastern.truthtree.dto.LocationDTO;
import edu.northeastern.truthtree.dto.LocationDTOWrapper;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;

@Component
public class SimilarLocationsAssembler {

  private ObjectMapper mapper;

  @Autowired
  public SimilarLocationsAssembler(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public LocationDTO getJSONStringToLocationDTO(String jsonStr) {
    LocationDTO dto = null;
    try {
      LocationDTOWrapper locationDTO = mapper.readValue(jsonStr, LocationDTOWrapper.class);
      LocationDBResponseDTO responseDTO = locationDTO.getData();
      dto = new LocationDTO.Builder().withId(responseDTO.getId())
              .withName(responseDTO.getName())
              .withLatitude(responseDTO.getLatitude())
              .withLongitude(responseDTO.getLongitude())
              .withTypeCode(responseDTO.getType_code())
              .build();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dto;
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
