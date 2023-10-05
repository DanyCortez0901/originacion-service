package com.mx.dmx.originacion.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/health")
public class HealthController{
	
	// Variable estatica de reinicio
	private boolean reiniciaForzado=false;
	private static final Logger LOGGER = LogManager.getLogger(HealthController.class);
	
	/**
	 * Controller que reinicia el contenedor.
	 * @return {@link ResponseEntity} Retorna HttpStatus.
	 */
	@GetMapping(path = "/healthCheck")
	public ResponseEntity<Object> healthCheck() {
		
		// Se valida si el estatus es true se reinicia el contenedor
    	if(reiniciaForzado) {
    		LOGGER.info("000000", getClass(), "***************************** Reiniciando contenedor ********");
    		return new ResponseEntity<>(new Object(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	// Funciona correctamente
    	LOGGER.info("000000", getClass(), "Funcionando correctamente");
		return new ResponseEntity<>(new Object(), HttpStatus.OK);
	
	}

	/**
	 * Metodo que cambia el estatus de reinicio.
	 * @return retorna "OK" de tipo String.
	 */
	@GetMapping(path = "/healthForceRestart")
	public String healthForceRestart() {
		// Se cambia el estatus del reinicio
		reiniciaForzado=true;
		return "OK";
	}

}