package edu.northeastern.truthtree.adapter.attributes;

import edu.northeastern.truthtree.adapter.utilities.JoltUtil;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class AttributesMockAdapter implements IAttributesAdapter{


    public JSONArray getAttributes() {
        String specPath = "src/main/resources/AttributesSpec.json";

        JSONParser parser = new JSONParser();
        JSONArray attributesList = new JSONArray();
        try {
            attributesList = (JSONArray) parser.parse(new FileReader("src/main/resources/Attributes.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return JoltUtil.joltTransform(attributesList, specPath);
    }
}
