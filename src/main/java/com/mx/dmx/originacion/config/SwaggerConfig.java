package com.mx.dmx.originacion.config;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	
	@Autowired
	BuildProperties buildProperties;
	
   @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)        		
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mx.dmx.originacion.controller"))
                .paths(PathSelectors.any())
                .build()           
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }
  
    
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Originacion", 
          "Microservicio de contratos y disposiciones de efectivo", 
          buildProperties.getVersion(), 
          "Terms of service",
          new Contact("Daniel Cortez","danielitos0901@ciencias.unam.mx", "dumie.mx"),
          "License of API", "API license URL", Collections.emptyList());
    }
	
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration();
		configuration.setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
