package com.mx.dmx.originacion.exception.test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.TestPropertySource;

import com.mx.dmx.originacion.custom.FormatInputException;
import com.mx.dmx.originacion.custom.OriginacionException;
import com.mx.dmx.originacion.exception.ErrorResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class ErrorResponseEntityExceptionHandlerTest {

	@Spy
	@InjectMocks
	ErrorResponseEntityExceptionHandler error;

	OriginacionException ex;

	DataIntegrityViolationException dataEx;

	HttpMessageNotReadableException httpEx;

	FormatInputException inEx;

	@Mock
	HttpServletRequest request;


	@BeforeAll
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
				
	}

	
}
