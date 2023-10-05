DROP SCHEMA dmx if exists;

CREATE SCHEMA dmx;

CREATE TABLE dmx.solicitudes (
	id_solicitud int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
	monto numeric(12, 2) NULL DEFAULT 0,
	producto varchar NULL,
	estatus varchar NULL,
	tipo_solicitud_str varchar NULL,
	id_tipo_solicitud int8 NULL,
	tasa int4 NULL,
	plazo int8 NULL,
	frecuencia varchar NULL,
	fecha_solicitud timestamp NULL,
	fecha_ultimo_cambio timestamp NULL
);

CREATE TABLE dmx.clientes (
	id_cliente int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
	nombre varchar NOT NULL,
	apellido_paterno varchar NULL,
	apellido_materno varchar NULL
);

CREATE TABLE dmx.creditos (
	id_credito int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
	fecha_creacion timestamp NULL,
	id_solicitud int8 NOT NULL,
	capital_dispersado numeric(12, 2) NULL DEFAULT 0,
	monto numeric(12, 2) NULL DEFAULT 0,
	tasa int4 NULL,
	plazo int4 NULL,
	frecuencia varchar NULL
);

CREATE TABLE dmx.error_solicitudes_log (
	id_error_solicitudes_log int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
	id_solicitud int8 NOT NULL,
	codigo varchar NULL,
	descripcion varchar NULL,
	excepcion varchar NULL,
	fecha_creacion varchar NULL
);
