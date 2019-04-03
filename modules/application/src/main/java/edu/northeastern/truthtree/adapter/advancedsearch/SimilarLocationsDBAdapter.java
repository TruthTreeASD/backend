package edu.northeastern.truthtree.adapter.advancedsearch;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import edu.northeastern.truthtree.assembler.SimilarLocationsAssembler;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import edu.northeastern.truthtree.dto.SimilarPlacesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static edu.northeastern.truthtree.AppConst.COMMON_ATTRIBUTES_URL;
import static edu.northeastern.truthtree.AppConst.SIMILAR_PLACES_URL;

public class SimilarLocationsDBAdapter implements ISimilarLocationsAdapter {

    private SimilarLocationsAssembler assembler;

    @Autowired
    public SimilarLocationsDBAdapter(SimilarLocationsAssembler assembler) {
        this.assembler = assembler;
    }

    @Override
    public List<CommonAttributeDTO> getSupportedAttributes() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(COMMON_ATTRIBUTES_URL);
//        if(!placeType.equals(null) || !placeType.equals(""))
//            builder.queryParam(placeType);
        String response = URLUtil.readJSONFromURLInString(builder.toUriString());
        return assembler.getJSONStringToCommonAttributeDTOList(response);
    }

    @Override
    public List<SimilarPlacesDTO> getSimilarLocations(String id,
                                                      String placeType,
                                                      List<Integer> attributes,
                                                      String normalizeBy,
                                                      List<String> year,
                                                      String count) {
        String url = SIMILAR_PLACES_URL;
        UriComponentsBuilder builder;
        if(attributes.size() > 1) {
            System.out.println("inside");
            url += "multiple";
            builder = UriComponentsBuilder.fromHttpUrl(url);
            builder.queryParam("id", id);
            builder.queryParam("place_type", placeType);
            for(Integer attribute : attributes) {
                builder.queryParam("attribute", attribute);
            }
            builder.queryParam("normalize_by", normalizeBy);
            builder.queryParam("year", year.get(0));
            builder.queryParam("count", count);
        } else {
            url += "single";
            builder = UriComponentsBuilder.fromHttpUrl(url);
            builder.queryParam("id", id);
            builder.queryParam("place_type", placeType);
            builder.queryParam("attribute", attributes.get(0));
            builder.queryParam("normalize_by", normalizeBy);
            for(String y : year)
                builder.queryParam("year_range", y);
            builder.queryParam("count", count);
        }
        String response = URLUtil.readJSONFromURLInString(builder.toUriString());
        return assembler.getJSONStringToSimilarPlacesDTOList(response);
    }

}
