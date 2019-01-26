package edu.northeastern.truthtree.basicInfoApi;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileReader;
import java.io.IOException;


public class BasicStatesInfo {

  @RequestMapping("/api/states")
  public String getResponse() {

    JSONParser parser = new JSONParser();
    JSONArray statesList = new JSONArray();

    try {
      statesList = (JSONArray) parser.parse(new FileReader("./States.json"));

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }

    return statesList.toJSONString();
  }
}
