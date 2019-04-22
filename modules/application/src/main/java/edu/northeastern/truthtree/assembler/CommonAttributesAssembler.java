package edu.northeastern.truthtree.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonAttributesAssembler {

    /**
     * Initializing Jackson Object Mapper
     */
    private ObjectMapper mapper;

    @Autowired
    public CommonAttributesAssembler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Given a JSON Response as String
     * @param jsonStr
     * @return a {@link CommonAttributeDTO}
     * using Jackson Object Mapper
     */
    public CommonAttributeDTO getJSONStringToDTO(String jsonStr) {
        CommonAttributeDTO commonAttributeDTO = new CommonAttributeDTO();
        try {
            commonAttributeDTO = mapper.readValue(jsonStr, CommonAttributeDTO.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return commonAttributeDTO;
    }

    /**
     * Given a JSON Response as String
     * @param jsonStr
     * @return a {@link List<CommonAttributeDTO>}
     * using Jackson Object Mapper
     */
    public List<CommonAttributeDTO> getJSONStringToDTOList(String jsonStr) {
        List<CommonAttributeDTO> commonAttributeDTOWrapperListDTO = new ArrayList<>();
        try {
            CollectionType collectionType = mapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, CommonAttributeDTO.class);
            commonAttributeDTOWrapperListDTO = mapper.readValue(jsonStr, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commonAttributeDTOWrapperListDTO;
    }

}
