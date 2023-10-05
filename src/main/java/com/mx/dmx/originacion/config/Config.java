package com.mx.dmx.originacion.config;

import java.time.Duration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	
	
	@Autowired
	BuildProperties buildProperties;
	

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration();
		configuration.setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        int timeout = (60 * 1000);
        return restTemplateBuilder.setConnectTimeout(Duration.ofMillis(timeout))
                .setReadTimeout(Duration.ofMillis(timeout)).build();
    }
}
