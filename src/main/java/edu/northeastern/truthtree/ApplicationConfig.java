package edu.northeastern.truthtree;

import edu.northeastern.truthtree.adapter.attributes.AttributesMockAdapter;
import edu.northeastern.truthtree.adapter.attributes.IAttributesAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public IAttributesAdapter getAttributeAdapter() {
        return new AttributesMockAdapter();
    }

}
