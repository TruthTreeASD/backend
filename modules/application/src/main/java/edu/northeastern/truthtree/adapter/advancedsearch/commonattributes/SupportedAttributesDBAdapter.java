package edu.northeastern.truthtree.adapter.advancedsearch.commonattributes;

import edu.northeastern.truthtree.adapter.utilities.URLUtil;
import org.json.simple.JSONArray;
import org.springframework.web.util.UriComponentsBuilder;

import static edu.northeastern.truthtree.AppConst.COMMON_ATTRIBUTES_URL;

public class SupportedAttributesDBAdapter implements ISupportedAttributesAdapter {

    @Override
    public Object getSupportedAttributes(String placeType) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(COMMON_ATTRIBUTES_URL);
        if(!placeType.equals(null) || !placeType.equals(""))
            builder.queryParam(placeType);
        JSONArray response = URLUtil.readJSONFromURL(builder.toUriString());
        return (Object) response;
    }
}
