package com.mx.dmx.originacion.model;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private String codigo;
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private String descrpson;



}
