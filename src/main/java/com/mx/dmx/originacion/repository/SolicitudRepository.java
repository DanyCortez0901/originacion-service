package com.mx.dmx.originacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.dmx.originacion.entity.SolicitudEntity;


@Repository
public interface SolicitudRepository extends JpaRepository<SolicitudEntity, Long> {	
}
