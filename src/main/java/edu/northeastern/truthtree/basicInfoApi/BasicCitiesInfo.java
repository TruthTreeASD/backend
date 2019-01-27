package edu.northeastern.truthtree.basicInfoApi;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;

@RestController
public class BasicCitiesInfo {

  @RequestMapping("/api/cities")
  public String getResponse() {
    JSONParser parser = new JSONParser();
    JSONArray citiesList = new JSONArray();

    try {
      citiesList = (JSONArray) parser.parse(new FileReader("src/main/resources/Cities.json"));

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }

    return citiesList.toJSONString();
  }
}
