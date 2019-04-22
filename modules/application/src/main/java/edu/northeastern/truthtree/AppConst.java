package edu.northeastern.truthtree;

import org.springframework.stereotype.Component;


/**
 * Represents the constants used throughout the application.
 */
@Component
public class AppConst {

  //Attribute Adapter Constants
  public static final String ATTRIBUTES_FILE_PATH = "/Attributes.json";
  public static final String ATTRIBUTES_MOCK_SPEC_PATH = "/AttributesMockSpec.json";

  public static final String ATTRIBUTES_SPEC_PATH = "/AttributesSpec.json";
  public static final String ATTRIBUTE_ID_SPEC_PATH = "/AttributeIdSpec.json";
  public static final String ATTRIBUTES_URL1 = "/api/attributes/attributeIds";
  public static final String ATTRIBUTES_URL2 = "/api/attributes/attributeIds&states";
  public static final String ATTRIBUTES_URL3 = "/api/attributes/attributeIds&states&yearList";
  public static final String ATTRIBUTES_URL4 = "/api/attributes/attributeIds&states&yearRange";
  public static final String ATTRIBUTES_URL5 = "/api/queryAttriIdByCombineation";


  // Basic Info Constants
  public static final String STATES_URL = "/api/location/state";
  public static final String STATES_SPEC_FILE_PATH = "/StatesSpec.json";

  public static final String COUNTIES_URL = "/api/location/county";
  public static final String COUNTIES_SPEC_FILE_PATH = "/CountiesSpec.json";

  public static final String CITIES_URL = "/api/location/city";
  public static final String CITIES_SPEC_FILE_PATH = "/CitiesSpec.json";

  public static final String STATES_FILE_PATH = "/States.json";
  public static final String CITIES_FILE_PATH = "/Cities.json";
  public static final String COUNTIES_FILE_PATH = "/Counties.json";

  public static final String POPULATION_RANGE = "populationRange";
  public static final String POPULATION_KEY = "population";
  public static final String POPULATION_URL = "/api/findValue?attributeId=1&locationId=%s";
  public static final String POPULATION_RANGE_URL = "/api/findValue";

  // Collections
  public static final String COLLECTIONS_URL = "/api/collections";
  public static final String COLLECTIONS_SPEC_PATH = "/CollectionsSpec.json";
  public static final String COLLECTIONS_FILE_PATH = "/Collections.json";


  // Time Range
  public static final String TIME_RANGE_URL = "/api/time_range";
  public static final String TIME_RANGE_FILE_PATH = "/TimeRange.json";

  // Population
  public static final String POPULATION_SPEC_PATH = "/PopulationSpec.json";

  //Attribute, Normalization constants
  public static final int TOTAL_REVENUE_ID = 4;
  public static final int POPULATION_ID = 1;
  public static final String ATTRIBUTES = "attributes";
  public static final String DATA = "data";
  public static final String LOCATION_ID = "location_id";
  public static final String VALUE = "value";
  public static final String YEAR = "year";
  public static final String NAME = "name";
  public static final String POPULATION_PARAMETER = "Population";
  public static final String TOTAL_REVENUE_PARAMETER = "Total_Revenue";
  public static final String BY_REVENUE = "by_revenue";
  public static final String PER_CAPITA = "per_capita";

  //Stories APIs
  public static final String STORIES_URL_POST = "/api/stories/story";
  public static final String STORIES_URL_GET = "/api/stories/story/{status}/page";
  public static final String STORIES_URL_SEARCH = "/api/stories/story/search/page/{keyword}";

  // Similar State, City and County constants
  public static final String COMMON_ATTRIBUTES_URL = "/api/similar/supported";
  public static final String COMMON_ATTRIBUTES_PATH = "/CommonAttributes.json";
  public static final String SIMILAR_PLACES_URL = "/api/similar/";
  public static final String LOCATION_BY_ID_URL = "/api/location/queryById";

  public static final String STORIES_URL_CHANGE_STATUS = "/api/stories/story/{status}/{id}";
  public static final String STORIES_URL_UPDATE_VOTES = "/api/stories/story/vote/{id}/{voteType}";
  public static final String STORIES_URL_DELETE = "/api/stories/story/{id}";
}
