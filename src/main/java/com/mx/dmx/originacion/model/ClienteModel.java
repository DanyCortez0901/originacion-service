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
public class ClienteModel {

	
	@NotNull
	@Valid
	private String nombre;
	
	@NotNull
	@Valid
	private String apellidoPaterno;
	
	@NotNull
	@Valid
	private String apellidoMaterno;



}
