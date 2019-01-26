package edu.northeastern.truthtree.basicInfoApi;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileReader;
import java.io.IOException;


public class BasicCountiesInfo {

  @RequestMapping("counties")
  public String getResponse() {
    JSONParser parser = new JSONParser();
    JSONArray countiesList = new JSONArray();

    try {
      countiesList = (JSONArray) parser.parse(new FileReader("./Counties.json"));



    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }

    return countiesList.toJSONString();
  }
}
