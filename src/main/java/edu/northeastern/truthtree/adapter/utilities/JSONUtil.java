package edu.northeastern.truthtree.adapter.utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONUtil {

  /**
   * Loads and parses a JSON file into a JSON array.
   *
   * @param filePath location of the JSON file that will be parsed.
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

  /**
   * Converts jsonString into a JSONArray.
   *
   * @param jsonString string to be converted into a JSONArray.
   * @return jsonString as a JSONArray
   */
  static JSONArray stringToJSONArray(String jsonString) {
    JSONParser parser = new JSONParser();
    JSONArray jsonArray = null;

    try {
      jsonArray = (JSONArray) parser.parse(jsonString);
    } catch (ParseException e) {

      e.printStackTrace();
    } catch (ClassCastException cce) {

      jsonArray = new JSONArray();
      jsonArray.add(stringToJSONObject(jsonString));
    }

    return jsonArray;
  }

  /**
   * Converts jsonString into a JSONObject.
   *
   * @param jsonString string to be converted into a JSONArray.
   * @return jsonString as a JSONObject
   */
  private static JSONObject stringToJSONObject(String jsonString) {
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = null;

    try {
      jsonObject = (JSONObject) parser.parse(jsonString);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return jsonObject;
  }

  public static JSONArray filterJSON(JSONArray jsonArray, String JSONKey, int startValue,
                                     int endValue) {

    JSONArray filteredArray = new JSONArray();

    for (int i = 0; i < jsonArray.size(); i++) {
      JSONObject object = (JSONObject) jsonArray.get(i);

      String valueString = (String) object.get(JSONKey);
      valueString = valueString.replaceAll(",", "");
      int valueInt = Integer.parseInt(valueString);

      if (valueInt >= startValue && valueInt <= endValue) {
        filteredArray.add(object);
      }
    }

    return filteredArray;
  }
}
