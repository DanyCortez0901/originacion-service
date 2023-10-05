/*
 * Financiera Independencia.
 * Copyright (C)  All rights reserved. Todos los derechos reservados 2019.   
 * mailto:
 *
 * License as published by Financiera Independencia. 
 * Licencia publicada por Financiera Independencia version 1 .
 *
 * ErrorDetalle.java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */
package com.mx.dmx.originacion.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "errors" })
public class ErrorDetalle {

	@JsonProperty("errors")
	private List<ErrorDescripcion> errors = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	@JsonProperty("errors")
	public List<ErrorDescripcion> getErrors() {
		return errors;
	}

	@JsonProperty("errors")
	public void setErrors(List<ErrorDescripcion> errors) {
		this.errors = errors;
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
