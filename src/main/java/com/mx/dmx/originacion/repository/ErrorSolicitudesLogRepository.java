package com.mx.dmx.originacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.dmx.originacion.entity.ErrorSolicitudesLogEntity;

@Repository
public interface ErrorSolicitudesLogRepository extends JpaRepository<ErrorSolicitudesLogEntity, Long> {	
	List<ErrorSolicitudesLogEntity> findByidSolicitud(Long idSolicitud);
}
