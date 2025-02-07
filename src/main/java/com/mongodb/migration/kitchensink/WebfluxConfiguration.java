package com.mongodb.migration.kitchensink;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebfluxConfiguration implements WebFluxConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry corsRegistry) {
    corsRegistry
        .addMapping("/**")
        .allowedOrigins("*") // Allows all origins
        .allowedMethods("*") // Allows all HTTP methods
        .allowedHeaders("*") // Allows all headers
        .allowCredentials(false) // Set to true if authentication is needed
        .maxAge(3600);
  }
}
