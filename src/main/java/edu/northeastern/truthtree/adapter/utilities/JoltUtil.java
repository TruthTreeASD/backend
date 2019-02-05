package edu.northeastern.truthtree.adapter.utilities;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import org.json.simple.JSONArray;

import java.util.List;


public class JoltUtil {

    /**
     * Do Jolt mapping for a single Json object.
     * @param inputJSON
     * @param mappingSpecPath
     * @return transformed Json object
     */
    public static Object joltTransform(Object inputJSON, String mappingSpecPath) {
        Chainr chainr = getSpecChainr(mappingSpecPath);
        return chainr.transform(inputJSON);
    }

    /**
     * Do Jolt mapping for Json array.
     * @param jsonArray
     * @param mappingSpecPath
     * @return transformed Json array
     */
    public static JSONArray joltTransform(JSONArray jsonArray, String mappingSpecPath) {
        Chainr chainr = getSpecChainr(mappingSpecPath);
        JSONArray transformedAttributes = new JSONArray();
        for (Object jsonObject : jsonArray) {
            transformedAttributes.add(chainr.transform(jsonObject));
        }
        return transformedAttributes;
    }

    /**
     * Returns Jolt mapping spec chainr.
     * @param mappingSpecPath
     * @return Jolt mapping spec chainr
     */
    private static Chainr getSpecChainr(String mappingSpecPath) {
        List chainrSpecJSON = JsonUtils.filepathToList(mappingSpecPath);
        return Chainr.fromSpec(chainrSpecJSON);
    }

}
