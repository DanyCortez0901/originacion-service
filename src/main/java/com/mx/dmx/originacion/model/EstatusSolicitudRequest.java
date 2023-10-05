package com.mx.dmx.originacion.model;

import java.util.List;

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
	
	@NotNull
	@Valid
	private Long idSolicitud;
	
	@NotNull
	@Valid
	private String idEstatus;
	
	@NotNull
	@Valid
	private String fechaCambio;
	
	@NotNull
	@Valid
	private 
	List<MotivoModel> motivos;



}
