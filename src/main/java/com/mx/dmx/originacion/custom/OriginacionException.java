package com.mx.dmx.originacion.custom;

public class OriginacionException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1579042768128920674L;
	
	
	public OriginacionException(String mensaje) {
	  super(mensaje);
	}

	public OriginacionException(String mensaje, Exception cause) {
		super(mensaje, cause);
	}

}
