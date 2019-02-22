package edu.northeastern.truthtree;

/**
 * Represents the constants used throughout the application.
 */
public class AppConst {

        //App Constants
        private static final String DATABASE_URL = "http://54.153.74.217:8080";
        private static final String RESOURCES_PATH = "src/main/resources";

        //Attribute Adapter Constants
        public static final String ATTRIBUTES_FILE_PATH = RESOURCES_PATH + "/Attributes.json";
        public static final String ATTRIBUTES_MOCK_SPEC_PATH = RESOURCES_PATH + "/AttributesMockSpec.json";

        public static final String ATTRIBUTES_SPEC_PATH = RESOURCES_PATH + "/AttributesSpec.json";
        public static final String ATTRIBUTE_ID_SPEC_PATH = RESOURCES_PATH + "/AttributeIdSpec.json";
        public static final String Attributes_URL1 = DATABASE_URL + "/api/attributes/attributeIds";
        public static final String Attributes_URL2 = DATABASE_URL + "/api/attributes/attributeIds&states";
        public static final String Attributes_URL3 = DATABASE_URL + "/api/attributes/attributeIds&states&yearList";
        public static final String Attributes_URL4 = DATABASE_URL + "/api/attributes/attributeIds&states&yearRange";
        public static final String Attributes_URL5 = DATABASE_URL + "/api/queryAttriIdByCombineation";


        // Basic Info Constants
        public static final String STATES_URL = DATABASE_URL + "/api/location/state";
        public static final String STATES_SPEC_FILE_PATH = RESOURCES_PATH + "/StatesSpec.json";

        public static final String COUNTIES_URL = DATABASE_URL + "/api/location/county";
        public static final String COUNTIES_SPEC_FILE_PATH = RESOURCES_PATH + "/CountiesSpec.json";

        public static final String CITIES_URL = DATABASE_URL + "/api/location/city";
        public static final String CITIES_SPEC_FILE_PATH = RESOURCES_PATH + "/CitiesSpec.json";

        public static final String STATES_FILE_PATH = RESOURCES_PATH + "/States.json";
        public static final String CITIES_FILE_PATH = RESOURCES_PATH + "/Cities.json";
        public static final String COUNTIES_FILE_PATH = RESOURCES_PATH + "/Counties.json";

        public static final String POPULATION_RANGE = "populationRange";

        public static final String POPULATION_KEY = "population";


        // Collections
        public static final String COLLECTIONS_URL = DATABASE_URL + "/api/collections";

        public static final String COLLECTIONS_FILE_PATH = RESOURCES_PATH + "/Collections.json";


        // Time Range
        public static final String TIME_RANGE_URL = DATABASE_URL + "/api/time_range";

        public static final String TIME_RANGE_FILE_PATH = RESOURCES_PATH + "/TimeRange.json";

	// Population Adapter Constants
	public static final String POPULATION_SPEC_PATH = RESOURCES_PATH + "/PopulationSpec.json";

}
