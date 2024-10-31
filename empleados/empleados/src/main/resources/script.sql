CREATE TABLE public.empleado (
	identificacion varchar NOT NULL,
	primer_apellido varchar NULL,
	segundo_apellido varchar NULL,
	primer_nombre varchar NULL,
	otros_nombre varchar NULL,
	pais varchar NULL,
	tipo_id varchar NULL,
	correo_electronico varchar NULL,
	fecha_ingreso timestamp NULL,
	area varchar NULL,
	estado varchar NULL,
	fecha_registro timestamp NULL,
	foto varchar NULL,
	CONSTRAINT empleado_pk PRIMARY KEY (identificacion)
);