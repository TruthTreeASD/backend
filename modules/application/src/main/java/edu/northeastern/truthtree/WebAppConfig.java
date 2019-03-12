package edu.northeastern.truthtree;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // Single directory level - no need to exclude "api"
    registry.addViewController("/{x:[\\w\\-]+}")
        .setViewName("forward:/index.html");
    // Multi-level directory path, need to exclude "api" on the first part of the path
    registry.addViewController("/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}")
        .setViewName("forward:/index.html");
  }
}
