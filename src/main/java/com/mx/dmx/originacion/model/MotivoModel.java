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
public class MotivoModel {
	
	@NotNull
	@Valid
	private String codigo;
	
	@NotNull
	@Valid
	private String descrpson;



}
