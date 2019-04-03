package edu.northeastern.truthtree.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimilarLocationsAssembler {

    private ObjectMapper mapper;

    @Autowired
    public SimilarLocationsAssembler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public CommonAttributeDTO getJSONStringToDTO(String jsonStr) {
        CommonAttributeDTO commonAttributeDTO = new CommonAttributeDTO();
        try {
            commonAttributeDTO = mapper.readValue(jsonStr, CommonAttributeDTO.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return commonAttributeDTO;
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

    public List<SimilarPlacesDTO> getJSONStringToSimilarPlacesDTOList(String jsonStr) {
        List<SimilarPlacesDTO> similarPlacesDTOList = new ArrayList<>();
        try {
            CollectionType collectionType = mapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, SimilarPlacesDTO.class);
            similarPlacesDTOList = mapper.readValue(jsonStr, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return similarPlacesDTOList;
    }

}
