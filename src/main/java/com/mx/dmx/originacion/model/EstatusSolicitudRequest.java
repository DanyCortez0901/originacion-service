package com.mx.dmx.originacion.model;

import java.util.List;

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
public class EstatusSolicitudRequest {
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private Long idSolicitud;
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private String idEstatus;
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private String fechaCambio;
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private 
	List<MotivoModel> motivos;



}
