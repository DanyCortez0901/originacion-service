package com.mx.dmx.originacion.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "creditos")
public class CreditoEntity {

	@Id
	@Column(name = "id_credito")
	private Long idCredito;
	
	@Column(name = "fecha_creacion")
	@CreationTimestamp
	private Date fechaCreacion;
	
	@Column(name = "id_solicitud")
	private Long idSolicitud;
	
	@Column(name = "capital_dispersado")	
	private BigDecimal capitalDispersado;
	
	@Column(name = "monto")
	private BigDecimal monto;
	
	@Column(name = "tasa")
	private Integer tasa;
	
	@Column(name = "plazo")
	private Integer plazo;
	
	@Column(name = "frecuencia")
	private String frecuencia;
	
}
