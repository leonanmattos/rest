 ----------------------------------------------------------
 ------------------------- USUARIO ------------------------
 ----------------------------------------------------------

-- SEQUENCE: sq_usuario
-- DROP SEQUENCE sa_rest.sq_usuario;
CREATE SEQUENCE sa_rest.sq_usuario
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

-- TABLE: tb_usuario
-- DROP TABLE sa_rest.tb_usuario;
CREATE TABLE sa_rest.tb_usuario (
	id_usuario BIGINT NOT NULL DEFAULT nextval('sa_rest.sq_usuario'::regclass),
	cpf_usuario VARCHAR(11) NOT NULL,
	nome_usuario VARCHAR(150) NOT NULL,
	email VARCHAR(100) NULL,
	num_telefone VARCHAR(15) NULL,
	situacao BOOL NOT NULL,
	CONSTRAINT tb_usuario_pkey PRIMARY KEY (id_usuario)
);