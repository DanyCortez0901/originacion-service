package com.mx.dmx.originacion.errors.test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mx.dmx.originacion.model.ErrorDescripcion;
import com.mx.dmx.originacion.model.ErrorDetalle;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class ErrorsTest {

	
	@Test
	public void errorsPOJOs(){
		
		ErrorDetalle errorDetails = new ErrorDetalle();
		ErrorDescripcion detail = new ErrorDescripcion();
		detail.setCodigo("000000");
		detail.setDescripcion("Test");
		detail.setDetalle("Prueba Test");
		detail.setNivel("Prueba");
		detail.setMensaje("Test Mock");
		detail.setAdditionalProperty("test", "00000");
		List<ErrorDescripcion> errors = new ArrayList<>();
		errors.add(detail);
		errorDetails.setErrors(errors);
		errorDetails.setAdditionalProperty("test", "00000");
		
		errorDetails.getAdditionalProperties();
		errorDetails.getErrors();
		detail.getCodigo();
		detail.getDescripcion();
		detail.getDetalle();
		detail.getNivel();
		detail.getMensaje();
		
		assertNotNull(detail.getAdditionalProperties());

	}
	
	
	

}
