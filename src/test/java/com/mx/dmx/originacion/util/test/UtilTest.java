package com.mx.dmx.originacion.util.test;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mx.dmx.originacion.custom.OriginacionException;
import com.mx.dmx.originacion.util.Util;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class UtilTest {

	@Test
	void sumaFecha() {
		
		Date fecha = Util.strToDate("2021-10-01");
	
		assertNotNull(fecha);
		OriginacionException ex = assertThrows(OriginacionException.class,
				() -> Util.strToDate("2assaas")); 
	
	}

}
