package edu.northeastern.truthtree.api;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;

@RestController
public class AttributeResource {

    @RequestMapping("/api/attributes")
    public String attributeResource() {
        JSONParser parser = new JSONParser();
        JSONArray citiesList = new JSONArray();

        try {
            citiesList = (JSONArray) parser.parse(new FileReader("src/main/resources/Attributes.json"));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return citiesList.toJSONString();
    }
}
