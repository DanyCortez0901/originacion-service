package com.mx.dmx.originacion.model;

import java.math.BigDecimal;

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
	
	@NotNull
	@Valid
	private Long idSolicitud;
	
	@NotNull
	@Valid
	private Long idCredito;
	
	@NotNull
	@Valid
	private BigDecimal capitalDispersado;
	
	@NotNull
	@Valid
	private BigDecimal monto;
	
	@NotNull
	@Valid
	private Integer tasa;
	
	@NotNull
	@Valid
	private Integer plazo;
	
	@NotNull
	@Valid
	private String frecuencia;

}
