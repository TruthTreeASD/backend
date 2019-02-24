package edu.northeastern.truthtree;

import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Represents the configuration for the swagger implementation.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Sets up the parameters that the swagger implementation will use.
     * @return swagger Docket with needed parameters.
     */
    @Bean
    public Docket createRestApi() {
        return (new Docket(DocumentationType.SWAGGER_2))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    /**
     * Sets up the API info needed for the swagger documentation.
     * @return API info configuration.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Truth Tree backend APIs")
                .version("1.0")
                .build();
    }
}
