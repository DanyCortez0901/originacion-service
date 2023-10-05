package com.mx.dmx.originacion.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Generated
@NoArgsConstructor
@Getter

@Entity
@Setter
@ToString
@Table(name = "error_solicitudes_log")
public class ErrorSolicitudesLogEntity {
	public ErrorSolicitudesLogEntity(Long idSolicitud, String codigo, String descripcion, String excepcion) {
		this.idSolicitud = idSolicitud;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.excepcion = excepcion;
	}

	@Id
	@Column(name = "id_error_solicitudes_log")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idErrorSolicitudesLog;

	@Column(name = "id_solicitud")
	private Long idSolicitud;
	
	@Column(name = "codigo")
	private String codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "excepcion")
	private String excepcion;

	@Column(name = "fecha_creacion")
	@CreationTimestamp
	private Date fechaCreacion;



}
