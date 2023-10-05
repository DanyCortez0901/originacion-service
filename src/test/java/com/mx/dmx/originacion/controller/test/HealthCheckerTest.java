package com.mx.dmx.originacion.controller.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mx.dmx.originacion.controller.HealthController;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class HealthCheckerTest {
	
	@InjectMocks
	HealthController health;
	
	
	@Test
	public void healthCheck(){
		
		assertNotNull(health.healthCheck());
		
	}
	
	@Test
	public void healthForceRestart(){
		
		assertNotNull(health.healthForceRestart());
		assertNotNull(health.healthCheck());
		
	}
	

}
