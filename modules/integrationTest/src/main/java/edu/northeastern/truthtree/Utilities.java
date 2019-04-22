package edu.northeastern.truthtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

public class Utilities {

  /**
   * Reads the content form a web address and converts it into a JSONArray.
   *
   * @param url The web address of the web page to be read and converted.
   * @return JSONArray in the form of the text on the web page
   */
  public static JSONArray readJSONFromURL(String url) {

    String jsonString = readURL(url);

    return stringToJSONArray(jsonString);
  }

  /**
   * Reads a web page and turns its contents into a string.
   *
   * @param url The web address of the web page to be read and converted.
   * @return Web contents as a string
   */
  public static String readURL(String url) {
    String line;
    URL urlObj;
    StringBuilder response = new StringBuilder();

    try {
      urlObj = new URL(url);
      URLConnection connection = urlObj.openConnection();

      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

      while ((line = br.readLine()) != null) {
        response.append(line);
      }

      br.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return response.toString();
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

}
