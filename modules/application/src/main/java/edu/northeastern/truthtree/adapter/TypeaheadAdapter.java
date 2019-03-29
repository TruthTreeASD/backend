package edu.northeastern.truthtree.adapter;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import edu.northeastern.truthtree.dto.LocationDTO;

import static org.elasticsearch.index.query.MultiMatchQueryBuilder.Type.PHRASE_PREFIX;

/**
 * Created by steven on 2019/3/22.
 */
@Component
public class TypeaheadAdapter extends BaseAdapter {

  private RestHighLevelClient esClient;

  @Autowired
  public TypeaheadAdapter(RestHighLevelClient esClient) {
    this.esClient = esClient;
  }

  public List<LocationDTO> search(String text) throws IOException {
    SearchRequest searchRequest = new SearchRequest("location");
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
    boolQuery.should(QueryBuilders.matchQuery("name", text))
            .should(QueryBuilders.multiMatchQuery(text, "name",
                    "parent.name", "parent.parent.name").type(PHRASE_PREFIX));
    searchSourceBuilder.query(boolQuery);
    searchRequest.source(searchSourceBuilder);
    SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
    SearchHit[] hits = searchResponse.getHits().getHits();
    return Arrays.stream(hits).map(hit -> mapToLocationDTO(hit.getSourceAsMap()))
            .collect(Collectors.toList());
  }

  private LocationDTO mapToLocationDTO(Map<String, Object> data) {
    Optional<Map<String, Object>> parentDataOptional = Optional.ofNullable((Map) data.get("parent"));
    return new LocationDTO
            .Builder()
            .withId((String) data.get("id"))
            .withName((String) data.get("name"))
            .withParent(parentDataOptional.map(this::mapToLocationDTO).orElse(null))
            .withTypeCode((int) data.get("type_code"))
            .withLatitude((double) data.get("latitude"))
            .withLongitude((double) data.get("longitude"))
            .build();
  }
}
