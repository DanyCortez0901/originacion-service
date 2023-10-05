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
public class DispersionRequest {
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private Long idSolicitud;
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private Long idCredito;
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private BigDecimal capitalDispersado;
	@ApiModelProperty(required = true)
	@NotNull
	@Valid
	private BigDecimal monto;
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

}
