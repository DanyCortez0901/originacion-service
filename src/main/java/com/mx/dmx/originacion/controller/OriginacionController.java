package com.mx.dmx.originacion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.mx.dmx.originacion.custom.OriginacionException;
import com.mx.dmx.originacion.model.AltaSolicitudRequest;
import com.mx.dmx.originacion.model.DispersionRequest;
import com.mx.dmx.originacion.model.EstatusSolicitudRequest;
import com.mx.dmx.originacion.service.IOriginacionService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/originacion")
public class OriginacionController {

	@Autowired
	private IOriginacionService originacion;



	/**
	 * Controller que inicia las operaciones necesarias para generar y guardar la solicitud de credito.
	 * @param peticion {@link AltaSolicitudRequest} 
	 * Parametro de entrada que tiene un conjunto de atributos necesarios para el inicio de las operaciones. 
	 * @return {@link ResponseEntity} Objeto Json con informacion de la solicitud guardada y su estatus, ademas de HttpStatus.
	 * @throws OriginacionException
	 */			
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonObject> registro(@Valid @RequestBody AltaSolicitudRequest peticion){
		return ResponseEntity.status(HttpStatus.OK).body(originacion.inicioOperaciones(peticion));
	}
	
	
		
	@PostMapping(path = "/dispersar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonObject> dispersar(@Valid @RequestBody DispersionRequest peticion){
		return ResponseEntity.status(HttpStatus.OK).body(originacion.dispersion(peticion));
	}
	
	

	@PostMapping(path = "/modificar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonObject> modificar(@Valid @RequestBody EstatusSolicitudRequest peticion){
	return ResponseEntity.status(HttpStatus.OK).body(originacion.modificarEstatus(peticion));
}
}