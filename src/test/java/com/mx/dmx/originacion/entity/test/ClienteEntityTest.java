package com.mx.dmx.originacion.entity.test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mx.dmx.originacion.entity.ClienteEntity;
import com.mx.dmx.originacion.repository.ClienteRepository;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class ClienteEntityTest {

	@InjectMocks
	ClienteEntity entity;
	
	@Mock
	private ClienteRepository bitacora;
	
	@Test
	public void entity() {
		
		entity = new ClienteEntity();
		entity.setApellidoMaterno("lopez");
		
		List<ClienteEntity> lista = new ArrayList<>();		
		lista.add(entity);
		
		Mockito.when(bitacora.findAll()).thenReturn(lista);
		
		for(ClienteEntity resp:lista) {
			assertNotNull(resp.getApellidoMaterno());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
