CREATE TABLE IF NOT EXISTS aluno (
    id bigint PRIMARY KEY NOT NULL,
    nome CHARACTER VARYING(255) NOT NULL,
    documento CHARACTER VARYING(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS materia (
    id bigint PRIMARY KEY NOT NULL,
    nome CHARACTER VARYING(255) NOT NULL,
    capacidade bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS matricula (
    id bigint PRIMARY KEY NOT NULL,
    aluno_id bigint NOT NULL,
    materia_id bigint NOT NULL,
    descricao_semestre CHARACTER VARYING(255) NOT NULL,
    finalizado boolean NOT NULL,
   	CONSTRAINT fk_aluno FOREIGN KEY ( aluno_id ) REFERENCES aluno ( id ),
   	CONSTRAINT fk_materia FOREIGN KEY ( materia_id ) REFERENCES materia ( id )
);

CREATE TABLE IF NOT EXISTS materia_dependencia (
    id bigint PRIMARY KEY NOT NULL,
    materia_id bigint NOT NULL,
    materia_dependencia_id bigint NOT NULL,
    CONSTRAINT fk_materia FOREIGN KEY ( materia_id ) REFERENCES materia ( id ),
   	CONSTRAINT fk_materia_2 FOREIGN KEY ( materia_dependencia_id ) REFERENCES materia ( id )
);

CREATE SEQUENCE seq_aluno;
CREATE SEQUENCE seq_materia;
CREATE SEQUENCE seq_matricula;
CREATE SEQUENCE seq_materia_dependencia;

CREATE TABLE IF NOT EXISTS account (
    id bigint PRIMARY KEY NOT NULL,
    document CHARACTER VARYING(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS transaction (
    id bigint PRIMARY KEY NOT NULL,
    account_id bigint NOT NULL,
    operation_type CHARACTER VARYING(20) NOT NULL,
    amount numeric(15,2) NOT NULL,
    event_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   	CONSTRAINT fk_account FOREIGN KEY ( account_id ) REFERENCES account ( id )
);

CREATE SEQUENCE seq_account;
CREATE SEQUENCE seq_transaction;