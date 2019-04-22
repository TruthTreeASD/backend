package edu.northeastern.truthtree.adapter.utilities;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Represents the methods needed to read JSON from a URL API.
 */
@Component
public class URLUtil {

  private static RestTemplate restTemplate = null;

  @Autowired
  public URLUtil(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

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
    ResponseEntity<String> response
            = restTemplate.getForEntity(url, String.class);
    return response.getBody();
  }

  /**
   * Reads a web page and turns its contents into a string.
   *
   * @param url The web address of the web page to be read and converted.
   * @return Web contents as a string
   */
  public static String postJSONFromURL(String url, String jsonString) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<String>(jsonString, headers);
    ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
    return response.getBody();
  }

  /**
   * Reads a web page and turns its contents into a string.
   *
   * @param url The web address of the web page to be read and converted.
   * @return Web contents as a string
   */
  public static void putJSONFromURL(String url) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> entity = new HttpEntity<String>("", headers);
    restTemplate.put(url, entity, String.class);
  }

  public static void deleteJSONFromURL(String url){
    restTemplate.delete(url);
  }
}
