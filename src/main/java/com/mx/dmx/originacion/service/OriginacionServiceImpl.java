package com.mx.dmx.originacion.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.mx.dmx.originacion.client.ClienteNotificacionPromotor;
import com.mx.dmx.originacion.custom.EntityNotFoundException;
import com.mx.dmx.originacion.custom.OriginacionException;
import com.mx.dmx.originacion.entity.ClienteEntity;
import com.mx.dmx.originacion.entity.CreditoEntity;
import com.mx.dmx.originacion.entity.ErrorSolicitudesLogEntity;
import com.mx.dmx.originacion.entity.PromotorEntity;
import com.mx.dmx.originacion.entity.SolicitudEntity;
import com.mx.dmx.originacion.model.AltaSolicitudRequest;
import com.mx.dmx.originacion.model.DispersionRequest;
import com.mx.dmx.originacion.model.EstatusSolicitudRequest;
import com.mx.dmx.originacion.repository.ClienteRepository;
import com.mx.dmx.originacion.repository.CreditoRepository;
import com.mx.dmx.originacion.repository.ErrorSolicitudesLogRepository;
import com.mx.dmx.originacion.repository.PromotorRepository;
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
	private PromotorRepository promotorRepository;
	
	@Autowired
	private ClienteNotificacionPromotor clientePromotor;
		
    @Autowired
    ModelMapper modelMapper;
	/**
	 * Metodo que inicia las operaciones necesarias para generar la solicitud
	 * 
	 * @param request {@link AltaSolicitudRequest} Parametro de entrada
	 *                      que tiene un conjunto de atributos necesarios para el
	 *                      inicio de las operaciones.
	 * @return {@link JsonObject} Respuesta en formato JSON
	 * @throws OriginacionException
	 */
	@Override
	public JsonObject inicioOperaciones(AltaSolicitudRequest request) {
		JsonObject resultados = new JsonObject();	
		try {

			PromotorEntity promotor = promotorRepository.findByNombre(request.getPromotor());
			
			ClienteEntity cliente = modelMapper.map(request.getCliente(), ClienteEntity.class);
			clienteRepository.save(cliente);
			
			SolicitudEntity solicitud = modelMapper.map(request.getSolicitud(), SolicitudEntity.class);
			solicitud.setEstatus("CREADA");
			solicitud.setFechaUltimoCambio(new Date());
			solicitud.setIdCliente(cliente.getIdCliente());
			solicitud.setIdPromotor(promotor.getIdPromotor());
			solicitudRepository.save(solicitud);
			
			
			resultados.put("Solicitud", solicitud);
			resultados.put("Mensaje", "Solicitud Recibida");
			clientePromotor.notifica(solicitud.getIdSolicitud(), request.getPromotor());
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
	
	
	/**
	 * Metodo que cambia el estatus de la solicitud.
	 * 
	 * @param request {@link EstatusSolicitudRequest} Parametro de entrada
	 *                      que tiene un conjunto de atributos necesarios para modificar 
	 *                      la solicitud ya registrada
	 * @return {@link JsonObject} Respuesta en formato JSON
	 * @throws {@link EntityNotFoundException}
	 */
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


			Optional<PromotorEntity> promotorOptional = promotorRepository.findById(solicitud.getIdPromotor());
			if(promotorOptional.isPresent())
				clientePromotor.notifica(solicitud.getIdSolicitud(), promotorOptional.get().getNombre());
			return resultados;
		}
		

		List<ErrorSolicitudesLogEntity> solicitudLogsList = erroRepository.findByidSolicitud(request.getIdSolicitud());
		
		if(solicitudLogsList.isEmpty()) {			
			String mensaje = "No se ecnontraron solicitudes en el log de errores con el id: " 
					+ String.valueOf(request.getIdSolicitud());
			log.error(mensaje);
			erroRepository.save(new ErrorSolicitudesLogEntity(request.getIdSolicitud(),"FIND002",mensaje,""));
			throw new EntityNotFoundException(mensaje);
		}
		
		ErrorSolicitudesLogEntity error = solicitudLogsList.stream()
										.sorted((e1,e2) -> e1.getFechaCreacion().compareTo(e2.getFechaCreacion()) * -1)
										.toList()
										.get(0);
				
		
		
		resultados.put("ErrorLog", error);
		resultados.put("Mensaje", "Solicitud encontrada en log de errores");
		return resultados;
	}
	
	
	/**
	 * Metodo que dispersa un credito.
	 * 
	 * @param request {@link DispersionRequest} Parametro de entrada
	 *                      que tiene un conjunto de atributos necesarios para dispersar una solicitud
	 * @return {@link JsonObject} Respuesta en formato JSON
	 * @throws {@link OriginacionException}
	 */
	@Override
	public JsonObject dispersion(DispersionRequest request) {
		JsonObject resultados = new JsonObject();	
		try {
			
			
			Optional<SolicitudEntity> solicitudOptional = solicitudRepository.findById(request.getIdSolicitud());
			if(!solicitudOptional.isPresent()) {
				throw new IllegalArgumentException("No se encontro la solicitud con id: " + request.getIdSolicitud());
			}
			SolicitudEntity solicitud = solicitudOptional.get();
			CreditoEntity creditoDispersado = modelMapper.map(request, CreditoEntity.class);
			creditoRepository.save(creditoDispersado);
			resultados.put("Credito", creditoDispersado);
			resultados.put("Mensaje", "Credito Dispersado");
			
			Optional<PromotorEntity> promotorOptional = promotorRepository.findById(solicitud.getIdPromotor());
			if(promotorOptional.isPresent())
				clientePromotor.notifica(request.getIdSolicitud(), promotorOptional.get().getNombre());
			
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

	
	/**
	 * Metodo que registra un promotor.
	 * 
	 * @param request String con el nombre del prmootor
	 * @return {@link JsonObject} Respuesta en formato JSON
	 * @throws {@link OriginacionException}
	 */
	@Override
	public JsonObject altaPromotor(String promotor) {
		JsonObject resultados = new JsonObject();	
		try {			
			PromotorEntity promotorNuevo = new PromotorEntity();
			promotorNuevo.setNombre(promotor);
			PromotorEntity promotorGenerado = promotorRepository.save(promotorNuevo);
			resultados.put("Promotor", promotorGenerado);
			resultados.put("Mensaje", "Promotor registrado exitosamente");
		} catch (IllegalArgumentException ex) {
			String mensaje = "No fue posible guardar al promotor: " + ex.getMessage();
			log.error(mensaje);
			erroRepository.save(new ErrorSolicitudesLogEntity(0l,"PROM001", 
					mensaje,ex.getMessage()));
			throw new OriginacionException(mensaje, ex);
		}
		return resultados;
	}
	

}
