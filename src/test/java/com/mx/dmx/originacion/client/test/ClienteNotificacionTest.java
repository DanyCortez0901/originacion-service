package com.mx.dmx.originacion.client.test;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mx.dmx.originacion.client.ClienteNotificacionPromotor;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class ClienteNotificacionTest {

	
	@InjectMocks
	private ClienteNotificacionPromotor clientePromotor;
	
	@Mock
	private RestTemplate clienteRest;


	@Test
	void inicioOperacionesTest(){	
		clientePromotor.notifica(1L, "");

		when(clienteRest.exchange(anyString(), any(), any(), ArgumentMatchers.<Class<String>>any()))
		.thenThrow(new RestClientException("error"));
		clientePromotor.notifica(1L, "");
	
	}
	
}
