package com.mx.dmx.originacion.exception.test;


import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.TestPropertySource;

import com.mx.dmx.originacion.custom.EntityNotFoundException;
import com.mx.dmx.originacion.custom.OriginacionException;
import com.mx.dmx.originacion.exception.ErrorResponseEntityExceptionHandler;
import com.mx.dmx.originacion.model.ErrorDetalle;

import jakarta.servlet.http.HttpServletRequest;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class ErrorResponseEntityExceptionHandlerTest {

	@Spy
	@InjectMocks
	ErrorResponseEntityExceptionHandler error;


	@Mock
	HttpServletRequest request;

	@Test
	void handleExceptionTest() throws NoSuchMethodException, SecurityException {
		ErrorDetalle errorDetalle = error.handleBusinessException(new OriginacionException("exception"), request);
		assertFalse(errorDetalle.getErrors().isEmpty());
		
		errorDetalle = error.handleBusinessException(new OriginacionException("exception"), request);
		assertFalse(errorDetalle.getErrors().isEmpty());
		
		errorDetalle = error.handleBusinessException(new DataIntegrityViolationException("exception"), request);
		assertFalse(errorDetalle.getErrors().isEmpty());
		
		errorDetalle = error.handleBusinessException(new HttpMessageNotReadableException("exception"), request);
		assertFalse(errorDetalle.getErrors().isEmpty());
		
		errorDetalle = error.handleBusinessException(new EntityNotFoundException("exception"), request);
		assertFalse(errorDetalle.getErrors().isEmpty());
		
	}
	
}
