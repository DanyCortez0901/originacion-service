package com.mx.dmx.originacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.dmx.originacion.entity.PromotorEntity;

@Repository
public interface PromotorRepository extends JpaRepository<PromotorEntity, Long> {	
	PromotorEntity findByNombre(String nombre);
}
