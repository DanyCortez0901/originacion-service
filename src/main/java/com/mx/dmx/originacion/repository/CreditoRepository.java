package com.mx.dmx.originacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.dmx.originacion.entity.CreditoEntity;

@Repository
public interface CreditoRepository extends JpaRepository<CreditoEntity, Long> {	
}
