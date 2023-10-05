package com.mx.dmx.originacion.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated
@Getter
@Setter
@ToString
public class AltaSolicitudRequest {
	@NotNull
	@Valid
	private String promotor;
	
	@NotNull
	@Valid
	private String empresa;
	
	@NotNull
	@Valid
	private ClienteModel cliente;
	
	@NotNull
	@Valid
	private SolicitudModel solicitud;



}
