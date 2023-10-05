package com.mx.dmx.originacion.service.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mx.dmx.originacion.model.AltaSolicitudRequest;

public class AmortizacionesServiceData {

	public AltaSolicitudRequest loadAmortizacionRequest() {

		AltaSolicitudRequest amortaRequest;
		amortaRequest = new AltaSolicitudRequest();
		return amortaRequest;

	}






	public ResponseEntity<String> disposicionResponse() {

		String body = "{" + "\"idDisposicion\":1," + "\"frecuenciaPago\":\"M\"," + "\"plazoPago\":24,"
				+ "\"diaPago\":6," + "\"montoDisposicion\":6242.20," + "\"montoOferta\":0.00,"
				+ "\"fechaDisposicion\":\"2021-08-06T00:00:00.000-05:00\"," + "\"fechaLiquidacion\":null,"
				+ "\"fechaUltimoAtraso\":null," + "\"fechaDispersion\":null," + "\"propietarioCartera\":\"2011\","
				+ "\"fondeadora\":null,\"status\":\"D\"," + "\"statusCobranza\":\"N\","
				+ "\"statusCarteraVencida\":\"I\"," + "\"idDispersion\":1," + "\"idProducto\":\"MIDN\","
				+ "\"idLineaCredito\":8," + "\"disposicionPcts\":[]}";

		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body, HttpStatus.OK);
		return responseEntity;

	}

	public ResponseEntity<String> disposicionResponse(Integer idDispo) {

		String body = "{" +
				"\"idDisposicion\":" + idDispo + ","
				+ "\"frecuenciaPago\":\"M\"," + "\"plazoPago\":24,"
				+ "\"diaPago\":6,"
				+ "\"montoDisposicion\":6242.20,"
				+ "\"montoOferta\":0.00,"
				+ "\"fechaDisposicion\":\"2021-08-06T00:00:00.000-05:00\","
				+ "\"fechaLiquidacion\":null,"
				+ "\"fechaUltimoAtraso\":null,"
				+ "\"fechaDispersion\":null,"
				+ "\"propietarioCartera\":\"2011\","
				+ "\"fondeadora\":null,\"status\":\"D\"," + "\"statusCobranza\":\"N\","
				+ "\"statusCarteraVencida\":\"I\","
				+ "\"idDispersion\":1,"
				+ "\"idProducto\":\"MIDN\","
				+ "\"idLineaCredito\":1,"
				+ "\"esSeguro\":false,"
				+ "\"disposicionPcts\":[]}";

		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body, HttpStatus.OK);
		return responseEntity;
	}

	public ResponseEntity<String> disposicionResponse(Integer idDispo, String fechaDispersion) {

		String body = "{" + "\"idDisposicion\":" + idDispo + ","
				+ "\"frecuenciaPago\":\"M\"," + "\"plazoPago\":24,"
				+ "\"diaPago\":6," + "\"montoDisposicion\":6242.20,"
				+ "\"montoOferta\":0.00,"
				+ "\"fechaDisposicion\":\"2021-08-06T00:00:00.000-05:00\","
				+ "\"fechaLiquidacion\":null,"
				+ "\"fechaUltimoAtraso\":null,"
				+ "\"fechaDispersion\":\"" + fechaDispersion + "T00:00:00.000-05:00\","
				+ "\"propietarioCartera\":\"2011\","
				+ "\"fondeadora\":null,\"status\":\"D\","
				+ "\"statusCobranza\":\"N\","
				+ "\"statusCarteraVencida\":\"I\","
				+ "\"idDispersion\":1,"
				+ "\"idProducto\":\"MIDN\","
				+ "\"idLineaCredito\":1,"
				+ "\"esSeguro\":false,"
				+ "\"disposicionPcts\":[]}";

		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body, HttpStatus.OK);
		return responseEntity;
	}

	public ResponseEntity<String> disposicionExceptionResponse() {

		String body = "{" + "\"idDisposicion\":3,"
				+ "\"frecuenciaPago\":\"M\"," + "\"plazoPago\":24,"
				+ "\"diaPago\":6,"
				+ "\"montoDisposicion\":6242.20," + "\"montoOferta\":0.00,"
				+ "\"fechaDisposicion\":\"2021-08-06T00:00:00.000-05:00\","
				+ "\"fechaLiquidacion\":null,"
				+ "\"fechaUltimoAtraso\":null,"
				+ "\"fechaDispersion\":null,"
				+ "\"propietarioCartera\":\"2011\","
				+ "\"fondeadora\":null,\"status\":\"D\","
				+ "\"statusCobranza\":\"N\","
				+ "\"statusCarteraVencida\":\"I\","
				+ "\"idDispersion\":1,"
				+ "\"idProducto\":\"MIDN\","
				+ "\"idLineaCredito\":8,"
				+ "\"disposicionPcts\":[]}";

		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body, HttpStatus.OK);
		return responseEntity;

	}

	public ResponseEntity<String> disposicionJSONExceptionResponse() {

		String body = "" + "\"idDisposicion\":1," + "\"frecuenciaPago\":\"M\"," + "\"plazoPago\":24," + "\"diaPago\":6,"
				+ "\"montoDisposicion\":6242.20," + "\"montoOferta\":0.00,"
				+ "\"fechaDisposicion\":\"2021-08-06T00:00:00.000-05:00\"," + "\"fechaLiquidacion\":null,"
				+ "\"fechaUltimoAtraso\":null," + "\"fechaDispersion\":null," + "\"propietarioCartera\":\"2011\","
				+ "\"fondeadora\":null,\"status\":\"D\"," + "\"statusCobranza\":\"N\","
				+ "\"statusCarteraVencida\":\"I\"," + "\"idDispersion\":1," + "\"idProducto\":\"MIDN\","
				+ "\"idLineaCredito\":8," + "\"s\":[]}";

		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body, HttpStatus.OK);
		return responseEntity;

	}
}
