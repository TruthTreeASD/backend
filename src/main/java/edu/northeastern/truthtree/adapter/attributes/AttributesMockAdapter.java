package edu.northeastern.truthtree.adapter.attributes;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import edu.northeastern.truthtree.adapter.utilities.JSONUtil;
import edu.northeastern.truthtree.adapter.utilities.JoltUtil;

public class AttributesMockAdapter implements IAttributesAdapter{
    private static final String ATTRIBUTES_FILE_PATH = "src/main/resources/Attributes.json";
    private static final String ATTRIBUTES_SPEC_PATH = "src/main/resources/AttributesSpec.json";


    public JSONArray getAttributes() {

        JSONArray attributesList = JSONUtil.readJSONFile(ATTRIBUTES_FILE_PATH);

        return JoltUtil.joltTransform(attributesList, ATTRIBUTES_SPEC_PATH);
    }
}
