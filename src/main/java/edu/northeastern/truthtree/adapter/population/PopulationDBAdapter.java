package edu.northeastern.truthtree.adapter.population;

import edu.northeastern.truthtree.adapter.utilities.JoltUtil;
import org.json.simple.JSONArray;
import org.springframework.web.util.UriComponentsBuilder;

import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_SPEC_PATH;
import static edu.northeastern.truthtree.AppConst.POPULATION_SPEC_PATH;
import static edu.northeastern.truthtree.AppConst.Attributes_URL3;
import static edu.northeastern.truthtree.adapter.utilities.JoltUtil.joltTransform;
import static edu.northeastern.truthtree.adapter.utilities.URLUtil.readJSONFromURL;

public class PopulationDBAdapter implements IPopulationAdapter {


    @Override
    public Object getPopulation(Integer locationId, Integer year) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Attributes_URL3);
        int POPULATION_ATTRIBUTE_NUMBER = 1;

        builder.queryParam("attributes", POPULATION_ATTRIBUTE_NUMBER);
        builder.queryParam("state", locationId);
        builder.queryParam("yearList", year);

        JSONArray response = readJSONFromURL(builder.toUriString());
        Object transformed = joltTransform(response.get(0), ATTRIBUTES_SPEC_PATH);
        return joltTransform(transformed, POPULATION_SPEC_PATH);
    }


}
