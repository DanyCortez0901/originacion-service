package com.mx.dmx.originacion.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClienteNotificacionPromotor {

	private RestTemplate clienteRest;

	private String baseUrl;



	@Autowired
	public ClienteNotificacionPromotor(RestTemplate clienteRest, @Value("${promotor.notificacion.url}") String baseUrl) {
		this.clienteRest = clienteRest;
		this.baseUrl = baseUrl;
	}

	public void notifica(Long idSolicitud, String promotor) {

		String url = baseUrl + "notificar/" + promotor + "/" + idSolicitud;

		// create headers
		HttpHeaders headers = new HttpHeaders();

		// set `Content-Type` and `Accept` headers
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		// build the request
		HttpEntity<String> entity = new HttpEntity<>(headers);


		try {
			clienteRest.exchange(url, HttpMethod.POST, entity, String.class);
		} catch (Exception e) {
			log.error("hubo un error al notificar al promotor: {}", e.getMessage());
		} 

	}


}
