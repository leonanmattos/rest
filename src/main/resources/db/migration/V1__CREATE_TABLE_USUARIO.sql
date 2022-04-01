-- TABLE: tb_usuario
-- DROP TABLE sa_rest.tb_usuario;

CREATE TABLE sa_rest.tb_usuario (
	id_usuario BIGINT NOT NULL,
	cpf_usuario VARCHAR(11) NOT NULL,
	nome_usuario VARCHAR(150) NOT NULL,
	email VARCHAR(100) NULL,
	num_telefone VARCHAR(15) NULL,
	situacao BOOL NOT NULL,
	CONSTRAINT tb_usuario_pkey PRIMARY KEY (id_usuario)
);