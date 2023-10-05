package com.mx.dmx.originacion.controller.test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.mx.dmx.originacion.controller.OriginacionController;
import com.mx.dmx.originacion.model.AltaSolicitudRequest;
import com.mx.dmx.originacion.model.ClienteModel;
import com.mx.dmx.originacion.model.DispersionRequest;
import com.mx.dmx.originacion.model.EstatusSolicitudRequest;
import com.mx.dmx.originacion.service.IOriginacionService;

@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(scripts = { "classpath:test-schema.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
public class OriginacionControllerTest {
	
	@InjectMocks
	OriginacionController controlador;
	
	@Mock
	private IOriginacionService service;
	

	@Test
	public void controller() throws  ParseException{		
		AltaSolicitudRequest request = new AltaSolicitudRequest();	
		ClienteModel cliente = new ClienteModel();
		cliente.setApellidoMaterno("RAMIREZ");
		cliente.setApellidoPaterno("PEREZ");
		cliente.setNombre("LUIS");
		request.setCliente(cliente);
			
		assertNotNull(controlador.registro(request));
		assertNotNull(controlador.modificar(new EstatusSolicitudRequest()));
		assertNotNull(controlador.dispersar(new DispersionRequest()));
		
		
	}
	
}
