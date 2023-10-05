package com.mx.dmx.originacion.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.mx.dmx.originacion.custom.OriginacionException;
import com.mx.dmx.originacion.entity.ClienteEntity;
import com.mx.dmx.originacion.entity.CreditoEntity;
import com.mx.dmx.originacion.entity.ErrorSolicitudesLogEntity;
import com.mx.dmx.originacion.entity.SolicitudEntity;
import com.mx.dmx.originacion.model.AltaSolicitudRequest;
import com.mx.dmx.originacion.model.DispersionRequest;
import com.mx.dmx.originacion.model.EstatusSolicitudRequest;
import com.mx.dmx.originacion.repository.ClienteRepository;
import com.mx.dmx.originacion.repository.CreditoRepository;
import com.mx.dmx.originacion.repository.ErrorSolicitudesLogRepository;
import com.mx.dmx.originacion.repository.SolicitudRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OriginacionServiceImpl implements IOriginacionService {
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ErrorSolicitudesLogRepository erroRepository;
	
	@Autowired
	private CreditoRepository creditoRepository;
		
    @Autowired
    ModelMapper modelMapper;
	/**
	 * Metodo que inicia las operaciones necesarias para generar la solicitud
	 * 
	 * @param amortaRequest {@link AltaSolicitudRequest} Parametro de entrada
	 *                      que tiene un conjunto de atributos necesarios para el
	 *                      inicio de las operaciones.
	 * @return {@link JsonObject} Respuesta en formato JSON
	 * @throws OriginacionException
	 */
	@Override
	public JsonObject inicioOperaciones(AltaSolicitudRequest request) {
		JsonObject resultados = new JsonObject();	
		try {
			SolicitudEntity solicitud = modelMapper.map(request.getSolicitud(), SolicitudEntity.class);
			solicitud.setEstatus("CREADA");
			solicitud.setFechaUltimoCambio(new Date());
			solicitudRepository.save(solicitud);
			
			ClienteEntity cliente = modelMapper.map(request.getCliente(), ClienteEntity.class);
			clienteRepository.save(cliente);
			resultados.put("Solicitud", solicitud);
			resultados.put("Mensaje", "Solicitud Recibida");
			//TODO:: envio de notificacion al promotor
		} catch (IllegalArgumentException | ConfigurationException | MappingException ex) {
			String mensaje = "No fue posible traducir el modelo de la solicitud a "
					+ "entity para su guardado en base de datos(Solicitud): " + ex.getMessage();
			log.error(mensaje);
			erroRepository.save(new ErrorSolicitudesLogEntity(request.getSolicitud().getIdSolicitud(),"MAP001", 
					mensaje,ex.getMessage()));
			throw new OriginacionException(mensaje, ex);
		}
		
		return resultados;
	}
	@Override
	public JsonObject modificarEstatus(EstatusSolicitudRequest request) {
		JsonObject resultados = new JsonObject();
		Optional<SolicitudEntity> solicitudOptional = solicitudRepository.findById(request.getIdSolicitud());
		if(solicitudOptional.isPresent()) {
			SolicitudEntity solicitud = solicitudOptional.get();
			solicitud.setEstatus(request.getIdEstatus());
			solicitud.setFechaUltimoCambio(new Date());
			solicitudRepository.save(solicitud);
			resultados.put("Solicitud", solicitud);
			resultados.put("Mensaje", "Solicitud modificada");

			//TODO:: envio de notificacion al promotor
			return resultados;
		}
		

		List<ErrorSolicitudesLogEntity> solicitudLogsList = erroRepository.findByidSolicitud(request.getIdSolicitud());
		
		if(solicitudLogsList.isEmpty()) {			
			String mensaje = "No se ecnontraron solicitudes en el log de errores con el id: " 
					+ String.valueOf(request.getIdSolicitud());
			log.error(mensaje);
			erroRepository.save(new ErrorSolicitudesLogEntity(request.getIdSolicitud(),"FIND002",mensaje,""));
			throw new OriginacionException(mensaje);
		}
		
		ErrorSolicitudesLogEntity error = solicitudLogsList.stream()
										.sorted((e1,e2) -> e1.getFechaCreacion().compareTo(e2.getFechaCreacion()) * -1)
										.collect(Collectors.toList())
										.get(0);
				
		;
		
		resultados.put("ErrorLog", error);
		resultados.put("Mensaje", "Solicitud encontrada en log de errores");

		//TODO:: envio de notificacion al promotor
		return resultados;
	}
	@Override
	public JsonObject dispersion(DispersionRequest request) {
		JsonObject resultados = new JsonObject();	
		try {
			CreditoEntity creditoDispersado = modelMapper.map(request, CreditoEntity.class);
			creditoRepository.save(creditoDispersado);

			resultados.put("Credito", creditoDispersado);
			resultados.put("Mensaje", "Credito Dispersado");
			//TODO:: envio de notificacion al promotor
		} catch (IllegalArgumentException | ConfigurationException | MappingException ex) {
			String mensaje = "No fue posible traducir el modelo de la solicitud a "
					+ "entity para su guardado en base de datos(Dispersion): " + ex.getMessage();
			log.error(mensaje);
			erroRepository.save(new ErrorSolicitudesLogEntity(request.getIdSolicitud(),"MAP001", 
					mensaje,ex.getMessage()));
			throw new OriginacionException(mensaje, ex);
		}
		
		return resultados;
	}


	

}
