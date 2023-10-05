package com.mx.dmx.originacion.util.test;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mx.dmx.originacion.util.Util;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class UtilTest {

	@Test
	public void sumaFecha() {
		
		Date fecha = Util.strToDate("2021-10-01 00:00:00");
		
		Date result = Util.sumaDias(fecha, 1);
		
		assertNotNull(result);
	
	}

}
