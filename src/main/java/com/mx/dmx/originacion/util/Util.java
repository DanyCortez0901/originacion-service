package com.mx.dmx.originacion.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mx.dmx.originacion.custom.OriginacionException;

public class Util {
	
	
	private Util() {
		super();
	}
			

	/**
	 * Metodo para darle formato de fecha a un String "yyyy-MM-dd HH:mm".
	 * @param str String Valor de la fecha.
	 * @return {@link Date} Fecha
	 * @throws OriginacionException
	 */
	public static Date strToDate(String str) {
		Date dateTime = null;
		try {
			dateTime = new SimpleDateFormat("yyyy-MM-dd").parse(str);
		} catch (ParseException e) {
			throw new OriginacionException(e.getMessage());
		}
		return dateTime;
	}

}
