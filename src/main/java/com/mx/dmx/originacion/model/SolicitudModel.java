package com.mx.dmx.originacion.model;

import java.math.BigDecimal;

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
public class SolicitudModel {

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private Long idSolicitud;

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private BigDecimal monto;

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private String producto;

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private String tipoSolicitudStr;

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private Integer idTipoSolicitud;

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private Integer tasa;

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private Integer plazo;

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private String frecuencia;

	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private String fechaSolicitud;



}
