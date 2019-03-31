package edu.northeastern.truthtree.adapter.advancedsearch.commonattributes;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;

import static edu.northeastern.truthtree.AppConst.COMMON_ATTRIBUTES_PATH;

public class SupportedAttributesMockAdapter implements ISupportedAttributesAdapter {

    @Override
    public Object getSupportedAttributes(String placeType) {
        return JSONUtil.readJSONFile(COMMON_ATTRIBUTES_PATH);
    }
}
