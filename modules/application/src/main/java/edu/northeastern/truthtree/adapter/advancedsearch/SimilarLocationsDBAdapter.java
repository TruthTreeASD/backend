package edu.northeastern.truthtree.adapter.advancedsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import edu.northeastern.truthtree.assembler.SimilarLocationsAssembler;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.MultipleAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;
import edu.northeastern.truthtree.dto.SingleAttributeDTO;
import edu.northeastern.truthtree.dto.YearRangeDTO;

import static edu.northeastern.truthtree.AppConst.COMMON_ATTRIBUTES_URL;
import static edu.northeastern.truthtree.AppConst.SIMILAR_PLACES_URL;

@Component("similarLocationsDBAdapter")
public class SimilarLocationsDBAdapter implements ISimilarLocationsAdapter {

  private SimilarLocationsAssembler assembler;

  @Autowired
  public SimilarLocationsDBAdapter(SimilarLocationsAssembler assembler) {
    this.assembler = assembler;
  }

  @Override
  public List<CommonAttributeDTO> getSupportedAttributes() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(COMMON_ATTRIBUTES_URL);
    String response = URLUtil.readJSONFromURLInString(builder.toUriString());
    return assembler.getJSONStringToCommonAttributeDTOList(response);
  }

  @Override
  public List<SimilarPlacesDTO> getSimilarLocations(int id,
                                                    int placeType,
                                                    List<Integer> attributes,
                                                    int normalizeBy,
                                                    List<Integer> year,
                                                    Integer count) {
    String response = "";
    if (attributes.size() > 1) {
      MultipleAttributeDTO attributeDTO = new MultipleAttributeDTO();
      attributeDTO.setId(id);
      if (count == null) {
        attributeDTO.setCount(10);
      }
      attributeDTO.setPlace_type(placeType);
      attributeDTO.setNormalize_by(normalizeBy);
      attributeDTO.setAttribute(attributes);
      attributeDTO.setYear(year.get(0));

      ObjectMapper mapper = new ObjectMapper();

      String jsonString = "";
      try {
        jsonString = mapper.writeValueAsString(attributeDTO);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

      response = URLUtil.postJSONFromURL(SIMILAR_PLACES_URL + "multi", jsonString);

    } else {
      SingleAttributeDTO attributeDTO = new SingleAttributeDTO();
      attributeDTO.setId(id);
      if (count == null) {
        attributeDTO.setCount(10);
      }
      attributeDTO.setPlace_type(placeType);
      attributeDTO.setNormalize_by(normalizeBy);
      attributeDTO.setAttribute(attributes.get(0));
      YearRangeDTO yearRangeDTO = new YearRangeDTO();
      yearRangeDTO.setStart(year.get(0));
      yearRangeDTO.setEnd(year.get(1));
      attributeDTO.setYear_range(yearRangeDTO);

      ObjectMapper mapper = new ObjectMapper();

      String jsonString = "";
      try {
        jsonString = mapper.writeValueAsString(attributeDTO);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

      response = URLUtil.postJSONFromURL(SIMILAR_PLACES_URL + "single", jsonString);
    }
    return assembler.getJSONStringToSimilarPlacesDTOList(response);
  }

}
