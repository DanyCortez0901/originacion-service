package com.mx.dmx.originacion.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated
@Getter
@Entity
@Setter
@ToString
@Table(name = "solicitudes")
public class SolicitudEntity {

	
	@Id
	@Column(name = "id_solicitud")
	private Long idSolicitud;

	
	
	@Column(name = "monto")
	private BigDecimal monto;

	
	
	@Column(name = "producto")
	private String producto;
	

	@Column(name = "estatus")
	private String estatus;

	
	@Column(name = "tipo_solicitud_str")
	private String tipoSolicitudStr;

	
	
	@Column(name = "id_tipo_solicitud")
	private Integer idTipoSolicitud;

	
	
	@Column(name = "tasa")
	private Integer tasa;

	
	
	@Column(name = "plazo")
	private Integer plazo;

	
	
	@Column(name = "frecuencia")
	private String frecuencia;

	
	
	@Column(name = "fecha_solicitud")
	private Date fechaSolicitud;
	
	
	@Column(name = "fecha_ultimo_cambio")
	private Date fechaUltimoCambio;


}
