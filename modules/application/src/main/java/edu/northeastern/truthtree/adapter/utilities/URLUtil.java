package edu.northeastern.truthtree.adapter.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;

/**
 * Represents the methods needed to read JSON from a URL API.
 */
public class URLUtil {

  /**
   * Reads the content form a web address and converts it into a JSONArray.
   *
   * @param url The web address of the web page to be read and converted.
   * @return JSONArray in the form of the text on the web page
   */
  public static JSONArray readJSONFromURL(String url) {

    String jsonString = readURL(url);

    return JSONUtil.stringToJSONArray(jsonString);
  }

  /**
   * Reads a web page and turns its contents into a string.
   *
   * @param url The web address of the web page to be read and converted.
   * @return Web contents as a string
   */
  private static String readURL(String url) {
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
}
