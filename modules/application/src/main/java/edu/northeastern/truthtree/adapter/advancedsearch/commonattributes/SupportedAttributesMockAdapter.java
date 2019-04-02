package edu.northeastern.truthtree.adapter.advancedsearch.commonattributes;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.assembler.CommonAttributesAssembler;
import edu.northeastern.truthtree.dto.CommonAttributeDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static edu.northeastern.truthtree.AppConst.COMMON_ATTRIBUTES_PATH;

public class SupportedAttributesMockAdapter implements ISupportedAttributesAdapter {

    @Override
    public List<CommonAttributeDTO> getSupportedAttributes() {
        return null;
    }
}
