package edu.northeastern.truthtree.adapter.utilities;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import java.util.List;
import org.json.simple.JSONArray;


public class JoltUtil {

  /**
   * Do Jolt mapping for a single Json object.
   *
   * @param inputJSON The JSONObject that will be transformed.
   * @param mappingSpecPath The path to the file that contains the mapping specs
   * @return transformed Json object
   */
  public static Object joltTransform(Object inputJSON, String mappingSpecPath) {
    Chainr chainr = getSpecChainr(mappingSpecPath);
    return chainr.transform(inputJSON);
  }

  /**
   * Do Jolt mapping for Json array.
   *
   * @param jsonArray The JSONArray that will be transformed.
   * @param mappingSpecPath The path to the file that contains the mapping specs.
   * @return transformed Json array
   */
  public static JSONArray joltTransform(JSONArray jsonArray, String mappingSpecPath) {
    System.out.println(mappingSpecPath);
    Chainr chainr = getSpecChainr(mappingSpecPath);
    JSONArray transformedAttributes = new JSONArray();
    for (Object jsonObject : jsonArray) {
      transformedAttributes.add(chainr.transform(jsonObject));
    }
    return transformedAttributes;
  }

  /**
   * Returns Jolt mapping spec chainr.
   *
   * @param mappingSpecPath The path to the file that contains the mapping specs.
   * @return Jolt mapping spec chainr
   */
  private static Chainr getSpecChainr(String mappingSpecPath) {
    List chainrSpecJSON = JsonUtils.classpathToList(mappingSpecPath);
    return Chainr.fromSpec(chainrSpecJSON);
  }

}
