package com.mx.dmx.originacion.custom;

public class EntityNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8410403588657103466L;
	
	public static final String MENSAJE_DEFAULT="Elemento no encontrado";
	
	public EntityNotFoundException(String mensaje) {
	  super(mensaje);
	}


}
