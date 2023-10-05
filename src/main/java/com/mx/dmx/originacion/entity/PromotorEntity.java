package com.mx.dmx.originacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Generated
@Getter
@Setter
@Entity
@ToString
@Table(name = "promotores")
public class PromotorEntity {
	@Id
	@Column(name = "id_promotor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPromotor;

	@Column(name = "nombre")
	private String nombre;



}
