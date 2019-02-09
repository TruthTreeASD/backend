package edu.northeastern.truthtree;

import edu.northeastern.truthtree.adapter.timerange.ITimeRangeAdapter;
import edu.northeastern.truthtree.adapter.timerange.TimeRangeDBAdapter;
import edu.northeastern.truthtree.adapter.timerange.TimeRangeMockAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.northeastern.truthtree.adapter.attributes.AttributesDBAdapter;
import edu.northeastern.truthtree.adapter.attributes.AttributesMockAdapter;
import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.BasicInfoDBAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.BasicInfoMockAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.adapter.collections.CollectionsDBAdapter;
import edu.northeastern.truthtree.adapter.collections.CollectionsMockAdapter;
import edu.northeastern.truthtree.adapter.collections.ICollectionsAdapter;

@Configuration
public class ApplicationConfig {
    private static final Boolean RETURN_MOCK_DATA_ATTRIBUTES = true;
    private static final Boolean RETURN_MOCK_DATA_BASIC_INFO = true;
    private static final Boolean RETURN_MOCK_DATA_COLLECTIONS = true;
    private static final Boolean RETURN_MOCK_DATA_TIME_RANGE = true;

	@Bean
	public IAttributesAdapter getAttributeAdapter() {
		return RETURN_MOCK_DATA_ATTRIBUTES ? new AttributesMockAdapter() : new AttributesDBAdapter();
	}

	@Bean
	public IBasicInfoAdapter getBasicInfoAdapter() {
		return RETURN_MOCK_DATA_BASIC_INFO ? new BasicInfoMockAdapter() : new BasicInfoDBAdapter();
	}

	@Bean
	public ICollectionsAdapter getCollectionsAdapter() {
		return RETURN_MOCK_DATA_COLLECTIONS ? new CollectionsMockAdapter() : new CollectionsDBAdapter();
	}

	@Bean
	public ITimeRangeAdapter getTimeRangeAdapter() {
		return RETURN_MOCK_DATA_TIME_RANGE ? new TimeRangeMockAdapter() : new TimeRangeDBAdapter();
	}
}
