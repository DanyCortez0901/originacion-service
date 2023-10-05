package com.mx.dmx.originacion.exception.custom;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.mx.dmx.originacion.custom.ExternalAPiException;

class ExternalAPiExceptionTest {

	@Test
	void ExternalAPiExceptionStringException() {
		Exception cause = new RuntimeException("cause exception");
		String mensaje = "message exception";
		ExternalAPiException exception = new ExternalAPiException(mensaje, cause);

		assertEquals("message exception", exception.getMessage());
		assertEquals("cause exception", exception.getCause().getMessage());
		assertNotNull(exception.getCause());
	}

	@Test
	void ExternalAPiExceptionString() {
		String mensaje = "message exception";
		ExternalAPiException exception = new ExternalAPiException(mensaje);

		assertEquals("message exception", exception.getMessage());
		assertNull(exception.getCause());
	}

}
