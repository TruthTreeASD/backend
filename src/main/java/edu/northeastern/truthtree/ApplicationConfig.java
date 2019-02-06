package edu.northeastern.truthtree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.northeastern.truthtree.adapter.attributes.AttributesMockAdapter;
import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.BasicInfoMockAdapter;
import edu.northeastern.truthtree.adapter.basicInfo.IBasicInfoAdapter;
import edu.northeastern.truthtree.adapter.collections.CollectionsDBAdapter;
import edu.northeastern.truthtree.adapter.collections.ICollectionsAdapter;

@Configuration
public class ApplicationConfig {

	@Bean
	public IAttributesAdapter getAttributeAdapter() {
		return new AttributesMockAdapter();
	}

	@Bean
	public IBasicInfoAdapter getBasicInfoAdapter() {
		return new BasicInfoMockAdapter();
	}

	@Bean
	public ICollectionsAdapter getCollectionsAdapter() {
		return new CollectionsDBAdapter();
	}

}
