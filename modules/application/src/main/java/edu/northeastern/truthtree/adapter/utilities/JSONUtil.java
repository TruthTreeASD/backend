package edu.northeastern.truthtree.adapter.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;


/**
 * Represents the methods used to manipulate JSON.
 */
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
      InputStream inputStream = new ClassPathResource(filePath).getInputStream();
      jsonArray = (JSONArray) parser.parse(new InputStreamReader(inputStream));

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
  public static JSONArray stringToJSONArray(String jsonString) {
    JSONParser parser = new JSONParser();
    JSONArray jsonArray = null;

    try {
      jsonArray = (JSONArray) parser.parse(jsonString);
    } catch (ParseException e) {

      e.printStackTrace();
    } catch (ClassCastException cce) {   // jsonString is in JSONObject format

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
  public static JSONObject stringToJSONObject(String jsonString) {
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = null;

    try {
      jsonObject = (JSONObject) parser.parse(jsonString);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return jsonObject;
  }

  /**
   * Filters the given JSONArray into values that are within startValue and endValue for JSONKey.
   *
   * @param jsonArray The given array that will be filtered.
   * @param JSONKey The key that jsonArray will be filtered by.
   * @param startValue The minimum value that will appear in the filtered JSONArray.
   * @param endValue The maximum value that will appear in the filtered JSONArray.
   * @return JSONArray that only contains objects in which startValue is less than JSONKey and
   * greater than endValue
   */
  public static JSONArray filterJSON(JSONArray jsonArray, String JSONKey, int startValue,
      int endValue) {

    JSONArray filteredArray = new JSONArray();

    for (int i = 0; i < jsonArray.size(); i++) {
      JSONObject object = (JSONObject) jsonArray.get(i);

      long value = (long) object.get(JSONKey);

      if (value >= startValue && value <= endValue) {
        filteredArray.add(object);
      }
    }

    return filteredArray;
  }

  /**
   * Given an errorMessage will return a JSONArray with Error as the key and errorMessage as the
   * value.
   *
   * @param errorMessage Message that will be added to a JSONArray
   * @return JSONArray where the key is Error and the value is errorMessage
   */
  public static JSONArray createErrorMessage(String errorMessage) {
    JSONArray jsonArray = new JSONArray();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("Error", errorMessage);
    jsonArray.add(jsonObject);

    return jsonArray;
  }

  /**
   * Takes in an array in the format: [ { "key1": { "subKey1": "subvalue1", ... , "subKeyN":
   * "subvalueN" }, ... { "keyN": { "subKey1": "subvalue1", ... , "subKeyN": "subvalueN" } } } ]
   *
   * Outputs array in the format: [{ "subKey1": "subvalue1", ... , "subKeyN": "subvalueN" }, {
   * "subKey1": "subvalue1", ... , "subKeyN": "subvalueN" } ]
   *
   * @param previousArray The array to be converted into the output format.
   * @return JSONArray in the output format
   */
  public static JSONArray moveObjectsUpOneLevel(JSONArray previousArray) {
    JSONParser parser = new JSONParser();
    JSONArray newJSONArray = null;

    JSONArray transformedArray = new JSONArray();
    try {
      newJSONArray = (JSONArray) parser.parse(previousArray.toJSONString());

      JSONObject topObject = (JSONObject) newJSONArray.get(0);

      for (Object innerObject : topObject.keySet()) {
        JSONObject state = (JSONObject) topObject.get(innerObject);

        transformedArray.add(state);
      }

    } catch (ParseException e) {
      e.printStackTrace();
    }

    return transformedArray;
  }
}
