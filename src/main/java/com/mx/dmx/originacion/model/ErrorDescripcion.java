/*
 * Financiera Independencia.
 * Copyright (C)  All rights reserved. Todos los derechos reservados 2020.   
 * mailto:
 *
 * License as published by Financiera Independencia. 
 * Licencia publicada por Financiera Independencia version 1 .
 *
 * SpringFoxConfig is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */
package com.mx.dmx.originacion.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "codigo", "mensaje", "nivel", "descripcion", "detalle" })
public class ErrorDescripcion {

	@JsonProperty("codigo")
	private String codigo;
	@JsonProperty("mensaje")
	private String mensaje;
	@JsonProperty("nivel")
	private String nivel;
	@JsonProperty("descripcion")
	private String descripcion;
	@JsonProperty("detalle")
	private String detalle;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("codigo")
	public String getCodigo() {
		return codigo;
	}

	@JsonProperty("codigo")
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@JsonProperty("mensaje")
	public String getMensaje() {
		return mensaje;
	}

	@JsonProperty("mensaje")
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@JsonProperty("nivel")
	public String getNivel() {
		return nivel;
	}

	@JsonProperty("nivel")
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@JsonProperty("descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	@JsonProperty("descripcion")
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@JsonProperty("detalle")
	public String getDetalle() {
		return detalle;
	}

	@JsonProperty("detalle")
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
