package edu.northeastern.truthtree.adapter.population;

import static edu.northeastern.truthtree.AppConst.ATTRIBUTES_URL3;
import static edu.northeastern.truthtree.AppConst.POPULATION_SPEC_PATH;
import static edu.northeastern.truthtree.adapter.utilities.JoltUtil.joltTransform;
import static edu.northeastern.truthtree.adapter.utilities.URLUtil.readJSONFromURL;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PopulationDBAdapter implements IPopulationAdapter {

  @Value("${databaseUrl}")
  private String db_endpoint;

  @Override
  public Object getPopulation(Integer locationId, Integer year) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(db_endpoint + ATTRIBUTES_URL3);
    int POPULATION_ATTRIBUTE_NUMBER = 1;

    builder.queryParam("attributes", POPULATION_ATTRIBUTE_NUMBER);
    builder.queryParam("state", locationId);
    builder.queryParam("yearList", year);

    JSONArray response = readJSONFromURL(builder.toUriString());
    return joltTransform(response.get(0), POPULATION_SPEC_PATH);
  }
}
