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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;


@RestController
@Api(value = "Originacion service")
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
	@ApiOperation(value = "Ejecuta Calculo Inicial")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna la ejecucion"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 400, message = "Hubo un error al procesar la peticion"),
			@ApiResponse(code = 409, message = "Hubo un conflicto en el proceso")
	})			
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonObject> registro(@Valid @RequestBody AltaSolicitudRequest peticion){
		return ResponseEntity.status(HttpStatus.OK).body(originacion.inicioOperaciones(peticion));
	}
	
	
	@ApiOperation(value = "Dispersa una solicitud")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna la ejecucion"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 400, message = "Hubo un error al procesar la peticion"),
			@ApiResponse(code = 409, message = "Hubo un conflicto en el proceso")
	})			
	@PostMapping(path = "/dispersar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonObject> dispersar(@Valid @RequestBody DispersionRequest peticion){
		return ResponseEntity.status(HttpStatus.OK).body(originacion.dispersion(peticion));
	}
	
	
	@ApiOperation(value = "Modifica una solicitud")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna la ejecucion"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 400, message = "Hubo un error al procesar la peticion"),
			@ApiResponse(code = 409, message = "Hubo un conflicto en el proceso")
	})
	@PostMapping(path = "/modificar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonObject> modificar(@Valid @RequestBody EstatusSolicitudRequest peticion){
	return ResponseEntity.status(HttpStatus.OK).body(originacion.modificarEstatus(peticion));
}
}