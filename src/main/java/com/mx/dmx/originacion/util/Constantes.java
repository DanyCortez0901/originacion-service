package com.mx.dmx.originacion.util;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public final class Constantes {
	
	private Constantes() {
		super();
	}

	
	public static final String DISPOSICION_NAME = "${amortizaciones.constantes.endpointname}";
	public static final String DIPOSICION_URL = "${amortizaciones.constantes.endpoint}";
	public static final String DIPOSICION_PATH ="${amortizaciones.constantes.endpointpath}";
	public static final String DIPOSICION_BY_LINEA_PATH = "${amortizaciones.constantes.disposiciones.lineacredito.endpointpath}";
	
	public static final String PET_INCORRECTA = "Peticion incorrecta, solo puede enviar un parametro de busqueda";
	public static final String PET_PARAM_INC = "Peticion incorrecta, parametro(s) de busqueda incorrecto(s)";
	public static final String MSG_OPERA = "Entro al inicio de la ejecucion de las operaciones";
	public static final String JSON_NAME = "Originacion";

}
