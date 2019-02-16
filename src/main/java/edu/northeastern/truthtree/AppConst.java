package edu.northeastern.truthtree;

/**
 * Represents the constants used throughout the application.
 */
public class AppConst {
	// App Constants
	public static final String DATABASE_URL = "http://54.241.137.214:8080";
	public static final String RESOURCES_PATH = "src/main/resources";

	// Attribute Adapter Constants
	public static final String ATTRIBUTES_FILE_PATH = RESOURCES_PATH + "/Attributes.json";
	public static final String ATTRIBUTES_MOCK_SPEC_PATH = RESOURCES_PATH + "/AttributesMockSpec.json";

	public static final String ATTRIBUTES_SPEC_PATH = RESOURCES_PATH + "/AttributesSpec.json";
	public static final String ATTRIBUTE_ID_SPEC_PATH = RESOURCES_PATH + "/AttributeIdSpec.json";
	public static final String Attributes_URL1 = DATABASE_URL + "/api/attributes/attributeIds";
	public static final String Attributes_URL2 = DATABASE_URL + "/api/attributes/attributeIds&states";
	public static final String Attributes_URL3 = DATABASE_URL + "/api/attributes/attributeIds&states&yearList";
	public static final String Attributes_URL4 = DATABASE_URL + "/api/attributes/attributeIds&states&yearRange";
	public static final String Attributes_URL5 = DATABASE_URL + "/api/queryAttriIdByCombineation";

	// Collections Adapter Constants
	public static final String COLLECTIONS_URL = DATABASE_URL + "/api/collections";

}
