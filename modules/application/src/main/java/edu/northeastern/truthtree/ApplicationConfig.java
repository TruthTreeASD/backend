package edu.northeastern.truthtree;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * Represents the instances that will be created when the API is queried.
 */
@Configuration
@Component
public class ApplicationConfig {

  @Value("${elasticsearchUrl}")
  private String elasticsearchEndpoint;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public RestHighLevelClient restHighLevelClient() {
    return new RestHighLevelClient(RestClient
            .builder(new HttpHost(elasticsearchEndpoint, 443, "https")));
  }
}
