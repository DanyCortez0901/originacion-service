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
public class SolicitudModel {

	
	@NotNull
	@Valid
	private Long idSolicitud;

	
	@NotNull
	@Valid
	private BigDecimal monto;

	
	@NotNull
	@Valid
	private String producto;

	
	@NotNull
	@Valid
	private String tipoSolicitudStr;

	
	@NotNull
	@Valid
	private Integer idTipoSolicitud;

	
	@NotNull
	@Valid
	private Integer tasa;

	
	@NotNull
	@Valid
	private Integer plazo;

	
	@NotNull
	@Valid
	private String frecuencia;

	
	@NotNull
	@Valid
	private String fechaSolicitud;



}
