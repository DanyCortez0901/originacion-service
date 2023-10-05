package com.mx.dmx.originacion.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mx.dmx.originacion.custom.FormatInputException;
import com.mx.dmx.originacion.custom.OriginacionException;
import com.mx.dmx.originacion.model.ErrorDescripcion;
import com.mx.dmx.originacion.model.ErrorDetalle;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ErrorResponseEntityExceptionHandler {
	
	public static final String ERROR_INTERNO = " Error interno de negocio {}";
	public static final String WARNING = "WARNING";
	public static final String ERROR = "ERROR";
	public static final String CODIGO_400 = "ORIGINACION0000400";
	public static final String CODIGO_403 = "ORIGINACION0000403";
	public static final String CODIGO_409 = "ORIGINACION0000409";
	public static final String MENSAJE_AMORTA = "No se crea la BITACORA";
	public static final String MENSAJE_CALCULO = "No se pudo realizar los calculos";
	public static final String MENSAJE_COMUNICA = "Error de comunicación";
	public static final String DESC_INPUT_NO_VALIDO = "Datos de entrada invalidos";
	public static final String DESC_ERROR_OBTENCION = "Error en la obtención de la información";
	public static final String DESC_FORMULA = "No se logra aplicar la formula";
	public static final String DESC_NO_CALCULA = "No se logra calcular la BITACORA";
	public static final String DESC_RESTRICCION = "Falla por restricción de llave foranea";
	public static final String DESC_RANGO = "Dia de pago fuera de rango";

	/**
	 * Metodo que muestra el detalle de error de comunicacion.
	 * @param ex
	 * @param request
	 * @return {@link ErrorDetalle} Objeto con la informacion del error.
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public final ErrorDetalle handleException(OriginacionException ex, HttpServletRequest request) {
		log.error(ERROR_INTERNO, ex);
		return crearErrorDetalle(CODIGO_400,DESC_ERROR_OBTENCION,ex.getMessage(),MENSAJE_COMUNICA, ERROR);
	}

	/**
	 * Metodo que muestra el detalle de error al realizar los calculos.
	 * @param ex
	 * @param request
	 * @return {@link ErrorDetalle} Objeto con la informacion del error.
	 */
	@ExceptionHandler(OriginacionException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public final ErrorDetalle handleBusinessException(OriginacionException ex, HttpServletRequest request) {
		log.error(ERROR_INTERNO, ex);
		return crearErrorDetalle(CODIGO_403,DESC_FORMULA,ex.getMessage(),MENSAJE_CALCULO,WARNING);
	}
	

	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public final ErrorDetalle handleBusinessException(DataIntegrityViolationException ex, HttpServletRequest request) {
		log.error(ERROR_INTERNO, ex);
		return crearErrorDetalle(CODIGO_409,DESC_RESTRICCION,ex.getMessage(),MENSAJE_AMORTA,WARNING);
	}

	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public final ErrorDetalle handleBusinessException(HttpMessageNotReadableException ex, HttpServletRequest request) {
		log.error(ERROR_INTERNO, ex);
		return crearErrorDetalle(CODIGO_409,DESC_INPUT_NO_VALIDO,ex.getMessage(),MENSAJE_AMORTA,WARNING);
	}
	
	@ExceptionHandler(FormatInputException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public final ErrorDetalle handleBusinessException(FormatInputException ex, HttpServletRequest request) {
		log.error(ERROR_INTERNO, ex);
		return crearErrorDetalle(CODIGO_400,DESC_INPUT_NO_VALIDO,ex.getMessage(),MENSAJE_AMORTA,WARNING);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public final ErrorDetalle handleBusinessException(MethodArgumentNotValidException ex, HttpServletRequest request) {
		log.error(ERROR_INTERNO, ex);
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errores.put(fieldName, errorMessage);
		});
		return crearErrorDetalle(CODIGO_409,DESC_INPUT_NO_VALIDO,errores.toString(),MENSAJE_CALCULO,WARNING);
	}
	
	/**
	 * Metodo que crea detalle del error.
	 * @param codigo
	 * @param descripcion
	 * @param detalle
	 * @param mensaje
	 * @param nivel
	 * @return {@link ErrorDetalle} Objeto con la informacion del error.
	 */
	private ErrorDetalle crearErrorDetalle(String codigo, String descripcion, String detalle, String mensaje,
			String nivel) {
		ErrorDetalle errorDetails = new ErrorDetalle();
		ErrorDescripcion detail = new ErrorDescripcion();
		detail.setCodigo(codigo);
		detail.setDescripcion(descripcion);
		detail.setDetalle(detalle);
		detail.setNivel(nivel);
		detail.setMensaje(mensaje);
		List<ErrorDescripcion> errors = new ArrayList<>();
		errors.add(detail);
		errorDetails.setErrors(errors);
		return errorDetails;
	}
	

}
