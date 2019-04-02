package edu.northeastern.truthtree.adapter.utilities;

import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

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

  public static String readJSONFromURLInString(String url) {

    return readURL(url);
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

  /**
   * Reads a web page and turns its contents into a string.
   *
   * @param url The web address of the web page to be read and converted.
   * @return Web contents as a string
   */
  public static String postJSONFromURL(String url, String jsonString) {
    StringBuffer response = new StringBuffer();
    try {
      URL postUrl = new URL(url);
      HttpURLConnection con = (HttpURLConnection) postUrl.openConnection();
      con.setRequestMethod("POST");
      con.setDoOutput(true);
      con.setRequestProperty("Content-Type", "application/json");
      DataOutputStream write = null;
      try {
        write = new DataOutputStream(con.getOutputStream());
        write.writeBytes(jsonString);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        response = new StringBuffer();
        while ((output = in.readLine()) != null) {
          response.append(output);
        }
        System.out.println(response);
        in.close();
      } catch (IOException exception) {
        throw exception;
      } finally {
        try {
          if (write != null) {
            write.close();
          }
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return response.toString();
  }

  /**
   * Reads a web page and turns its contents into a string.
   *
   * @param url The web address of the web page to be read and converted.
   * @return Web contents as a string
   */
  public static String putJSONFromURL(String url) {
    StringBuffer response = new StringBuffer();
    try {
      URL putUrl = new URL(url);
      HttpURLConnection con = (HttpURLConnection) putUrl.openConnection();
      con.setRequestMethod("PUT");
      con.setDoOutput(true);
      con.setRequestProperty("Content-Type", "application/json");
      DataOutputStream write = null;
      try {
        write = new DataOutputStream(con.getOutputStream());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String output;
        response = new StringBuffer();
        while ((output = in.readLine()) != null) {
          response.append(output);
        }
        System.out.println(response);
        in.close();
      } catch (IOException exception) {
        throw exception;
      } finally {
        try {
          if (write != null) {
            write.close();
          }
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return response.toString();
  }
}
