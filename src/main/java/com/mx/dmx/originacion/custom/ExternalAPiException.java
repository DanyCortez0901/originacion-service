package com.mx.dmx.originacion.custom;

public class ExternalAPiException extends OriginacionException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3737942240848982909L;

	public ExternalAPiException(String mensaje, Exception cause) {
		super(mensaje, cause);
	}

	public ExternalAPiException(String mensaje) {
		super(mensaje);
	}

}
