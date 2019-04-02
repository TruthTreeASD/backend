package edu.northeastern.truthtree.adapter.advancedsearch.commonattributes;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import edu.northeastern.truthtree.assembler.CommonAttributesAssembler;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static edu.northeastern.truthtree.AppConst.COMMON_ATTRIBUTES_URL;

public class SupportedAttributesDBAdapter implements ISupportedAttributesAdapter {

    private CommonAttributesAssembler assembler;

    @Autowired
    public SupportedAttributesDBAdapter(CommonAttributesAssembler assembler) {
        this.assembler = assembler;
    }

    @Override
    public List<CommonAttributeDTO> getSupportedAttributes() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(COMMON_ATTRIBUTES_URL);
//        if(!placeType.equals(null) || !placeType.equals(""))
//            builder.queryParam(placeType);
        String response = URLUtil.readJSONFromURLInString(builder.toUriString());
        return assembler.getJSONStringToDTOList(response);
    }
}
