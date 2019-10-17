DROP SCHEMA IF EXISTS empresaschema CASCADE;
CREATE SCHEMA empresaschema;

SET search_path  = 'empresaschema';

CREATE TABLE empresaschema.departamento (dnome character varying(255) NOT NULL, dnumero varchar(11) PRIMARY KEY);

CREATE TABLE empresaschema.funcionario (pnome character varying(255) NOT NULL,
                                        minicial character(1),
                                        unome character varying(255) NOT NULL,
                                        cpf varchar(11) PRIMARY KEY,
                                        endereco character varying(255),
                                        sexo character(2),
                                        salario numeric(10,2) DEFAULT 0.0,
                                        cpf_supervisor varchar(11),
                                        dnr integer)
);

INSERT INTO empresaschema.departamento VALUES ('Pesquisa', 3);
INSERT INTO empresaschema.departamento VALUES ('Administracao',4);
INSERT INTO empresaschema.funcionario VALUES ('James', 'E', 'Borg', '888665555', '450 Stone, Houston, TX', 'M' , 55000, '12345678', 1);
INSERT INTO empresaschema.funcionario VALUES ('Jennifer', 'S', 'Wallace', '987654321', '291 Berry, Bellaire, TX', 'F' , 43000, '888665555', 4);


