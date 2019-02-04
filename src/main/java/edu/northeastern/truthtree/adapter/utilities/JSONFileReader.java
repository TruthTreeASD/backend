package edu.northeastern.truthtree.adapter.utilities;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONFileReader {

  /**
   * Loads and parses a JSON file into a JSON array.
   *
   * @param filePath location of the JSON file that will be parsed.
   *
   * @return JSON array that represents the loaded file at filePath
   */
  public static JSONArray readJSONFile(String filePath) {
    JSONParser parser = new JSONParser();
    JSONArray jsonArray = new JSONArray();

    try {
      jsonArray = (JSONArray) parser.parse(new FileReader(filePath));

    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }

    return jsonArray;
  }
}
