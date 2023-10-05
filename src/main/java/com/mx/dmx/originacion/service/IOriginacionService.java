package com.mx.dmx.originacion.service;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.mx.dmx.originacion.model.AltaSolicitudRequest;
import com.mx.dmx.originacion.model.DispersionRequest;
import com.mx.dmx.originacion.model.EstatusSolicitudRequest;

public interface IOriginacionService {
	
	JsonObject inicioOperaciones(AltaSolicitudRequest request);
	JsonObject modificarEstatus(EstatusSolicitudRequest request);
	JsonObject dispersion(DispersionRequest request);
	JsonObject altaPromotor(String promotor);


}
