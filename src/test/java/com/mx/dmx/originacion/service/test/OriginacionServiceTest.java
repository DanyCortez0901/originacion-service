package com.mx.dmx.originacion.service.test;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mx.dmx.originacion.custom.EntityNotFoundException;
import com.mx.dmx.originacion.custom.OriginacionException;
import com.mx.dmx.originacion.entity.ClienteEntity;
import com.mx.dmx.originacion.entity.CreditoEntity;
import com.mx.dmx.originacion.entity.ErrorSolicitudesLogEntity;
import com.mx.dmx.originacion.entity.SolicitudEntity;
import com.mx.dmx.originacion.model.AltaSolicitudRequest;
import com.mx.dmx.originacion.model.ClienteModel;
import com.mx.dmx.originacion.model.DispersionRequest;
import com.mx.dmx.originacion.model.EstatusSolicitudRequest;
import com.mx.dmx.originacion.model.SolicitudModel;
import com.mx.dmx.originacion.repository.ClienteRepository;
import com.mx.dmx.originacion.repository.CreditoRepository;
import com.mx.dmx.originacion.repository.ErrorSolicitudesLogRepository;
import com.mx.dmx.originacion.repository.SolicitudRepository;
import com.mx.dmx.originacion.service.OriginacionServiceImpl;
import com.mx.dmx.originacion.util.Util;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class OriginacionServiceTest {

	
	@InjectMocks
	private OriginacionServiceImpl service;
	
	@Mock
	private SolicitudRepository solicitudRepository;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	@Mock
	private ErrorSolicitudesLogRepository erroRepository;
	
	@Mock
	private CreditoRepository creditoRepository;
	
	@Mock
    ModelMapper modelMapper;

	@Test
	void inicioOperacionesTest() throws  ParseException{		
		AltaSolicitudRequest request = new AltaSolicitudRequest();	
		ClienteModel cliente = new ClienteModel();
		cliente.setApellidoMaterno("RAMIREZ");
		cliente.setApellidoPaterno("PEREZ");
		cliente.setNombre("LUIS");
		request.setCliente(cliente);
		SolicitudModel solicitud = new SolicitudModel();
		request.setSolicitud(solicitud);
			
		SolicitudEntity solicitudEntity = new SolicitudEntity();
		ClienteEntity clienteEntity = new ClienteEntity();
		when(modelMapper.map(eq(solicitud)
				, ArgumentMatchers.<Class<SolicitudEntity>>any())).thenReturn(solicitudEntity);
		when(modelMapper.map(eq(cliente)
				, ArgumentMatchers.<Class<ClienteEntity>>any())).thenReturn(clienteEntity);
		
		assertNotNull(service.inicioOperaciones(request));		
	}
	@Test
	void inicioOperacionesTest_exception() throws  ParseException{		
		AltaSolicitudRequest request = new AltaSolicitudRequest();	
		ClienteModel cliente = new ClienteModel();
		cliente.setApellidoMaterno("RAMIREZ");
		cliente.setApellidoPaterno("PEREZ");
		cliente.setNombre("LUIS");
		request.setCliente(cliente);
		SolicitudModel solicitud = new SolicitudModel();
		request.setSolicitud(solicitud);
			
		when(modelMapper.map(eq(solicitud)
				, ArgumentMatchers.<Class<SolicitudEntity>>any())).thenThrow(new IllegalArgumentException("Error"));
		OriginacionException ex = assertThrows(OriginacionException.class,
				() -> service.inicioOperaciones(request));  	
	}
	
	@Test
	void dispersionTest() throws  ParseException{		
		DispersionRequest request = new DispersionRequest();
			
		CreditoEntity solicitudEntity = new CreditoEntity();
		when(modelMapper.map(eq(request)
				, ArgumentMatchers.<Class<CreditoEntity>>any())).thenReturn(solicitudEntity);		
		
		assertNotNull(service.dispersion(request));		
	}
	@Test
	void dispersionTest_exception() throws  ParseException{		
		DispersionRequest request = new DispersionRequest();
		when(modelMapper.map(eq(request)
				, ArgumentMatchers.<Class<CreditoEntity>>any())).thenThrow(new IllegalArgumentException("Error"));
		OriginacionException ex = assertThrows(OriginacionException.class,
				() -> service.dispersion(request));  	
	}
	
	@Test
	void modificarEstatusTest() throws  ParseException{		
		EstatusSolicitudRequest request = new EstatusSolicitudRequest();
		when(solicitudRepository.findById(any())).thenReturn(Optional.of(new SolicitudEntity()));			
		assertNotNull(service.modificarEstatus(request));		
	}
	
	@Test
	void modificarEstatusTest_optionalEmptyListEmpty() throws  ParseException{		
		EstatusSolicitudRequest request = new EstatusSolicitudRequest();
		when(solicitudRepository.findById(any())).thenReturn(Optional.empty());	
		when(erroRepository.findByidSolicitud(any())).thenReturn(new ArrayList<>());	
		EntityNotFoundException ex =  assertThrows(EntityNotFoundException.class,
				() -> service.modificarEstatus(request));		
	}
	@Test
	void modificarEstatusTest_optionalEmptyListWithElements() throws  ParseException{		
		EstatusSolicitudRequest request = new EstatusSolicitudRequest();
		when(solicitudRepository.findById(any())).thenReturn(Optional.empty());
		
		ArrayList<ErrorSolicitudesLogEntity> errores = new ArrayList<>();
		ErrorSolicitudesLogEntity error1 = new ErrorSolicitudesLogEntity();
		error1.setFechaCreacion(Util.strToDate("2023-10-04"));
		ErrorSolicitudesLogEntity error2 = new ErrorSolicitudesLogEntity();
		error2.setFechaCreacion(Util.strToDate("2023-10-02"));
		errores.add(error1);
		errores.add(error2);
		
		when(erroRepository.findByidSolicitud(any())).thenReturn(errores);	
		assertNotNull(service.modificarEstatus(request));		
	}
}
