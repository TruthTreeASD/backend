package edu.northeastern.truthtree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import edu.northeastern.truthtree.adapter.attributes.AttributesDBAdapter;
import edu.northeastern.truthtree.adapter.attributes.AttributesMockAdapter;
import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.BasicInfoDBAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.BasicInfoMockAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.adapter.collections.CollectionsDBAdapter;
import edu.northeastern.truthtree.adapter.collections.CollectionsMockAdapter;
import edu.northeastern.truthtree.adapter.collections.ICollectionsAdapter;
import edu.northeastern.truthtree.adapter.population.IPopulationAdapter;
import edu.northeastern.truthtree.adapter.population.PopulationDBAdapter;
import edu.northeastern.truthtree.adapter.population.PopulationMockAdapter;
import edu.northeastern.truthtree.adapter.timerange.ITimeRangeAdapter;
import edu.northeastern.truthtree.adapter.timerange.TimeRangeDBAdapter;
import edu.northeastern.truthtree.adapter.timerange.TimeRangeMockAdapter;

/**
 * Represents the instances that will be created when the API is queried.
 */
@Configuration
public class ApplicationConfig {

  private static final Boolean RETURN_MOCK_DATA_ATTRIBUTES = false;
  private static final Boolean RETURN_MOCK_DATA_BASIC_INFO = false;
  private static final Boolean RETURN_MOCK_DATA_COLLECTIONS = false;
  private static final Boolean RETURN_MOCK_DATA_TIME_RANGE = false;
  private static final Boolean RETURN_MOCK_DATA_POPULATION = false;

  /**
   * Gets the adapter instance for attributes.
   *
   * @return if RETURN_MOCK_DATA_ATTRIBUTES is true, the mock attributes adapter, database
   * attributes adapter otherwise.
   */
  @Bean
  public IAttributesAdapter getAttributeAdapter() {
    return RETURN_MOCK_DATA_ATTRIBUTES ? new AttributesMockAdapter() : new AttributesDBAdapter();
  }

  /**
   * Gets the adapter instance for population.
   *
   * @return if RETURN_MOCK_DATA_POPULATION is true, the mock population adapter, database
   * population adapter otherwise.
   */
  @Bean
  public IPopulationAdapter getPopulationAdapter() {
    return RETURN_MOCK_DATA_POPULATION ? new PopulationMockAdapter() : new PopulationDBAdapter();
  }

  /**
   * Gets the adapter instance for basic info.
   *
   * @return if RETURN_MOCK_DATA_BASIC_INFO is true, the mock basic into adapter, database basic
   * info adapter otherwise.
   */
  @Bean
  public IBasicInfoAdapter getBasicInfoAdapter() {
    return RETURN_MOCK_DATA_BASIC_INFO ? new BasicInfoMockAdapter() : new BasicInfoDBAdapter();
  }

  /**
   * Gets the adapter instance for collections.
   *
   * @return if RETURN_MOCK_DATA_COLLECTIONS is true, the mock collections adapter, database
   * collections adapter otherwise.
   */
  @Bean
  public ICollectionsAdapter getCollectionsAdapter() {
    return RETURN_MOCK_DATA_COLLECTIONS ? new CollectionsMockAdapter() : new CollectionsDBAdapter();
  }

  /**
   * Gets the adapter instance for time range.
   * @return if RETURN_MOCK_DATA_TIME_RANGE is true, the mock time range adapter, database
   * 				 time range adapter otherwise.
   */
  @Bean
  public ITimeRangeAdapter getTimeRangeAdapter() {
    return RETURN_MOCK_DATA_TIME_RANGE ? new TimeRangeMockAdapter() : new TimeRangeDBAdapter();
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
