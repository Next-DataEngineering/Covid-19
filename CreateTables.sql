CREATE DATABASE NextDataEngineering;

CREATE TABLE NextDataEngineering.Situacao(
id             int         NOT NULL,
descricao      varchar(50) NOT NULL,
_created       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
_updated       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (id)
);

CREATE TABLE NextDataEngineering.Pessoa(
id     int         NOT NULL AUTO_INCREMENT,
Pessoa        varchar(50) NOT NULL,
situacao_id   int         NOT NULL,
_created      DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
_updated      DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (id, Pessoa),
FOREIGN KEY (situacao_id) REFERENCES Situacao(id) ON UPDATE CASCADE
);


CREATE TABLE NextDataEngineering.HistoricoSituacao(
pessoa_id      int         NOT null,
Pessoa         varchar(50) NOT NULL,
DATA           datetime    NOT NULL,
situacao_id    int         NOT NULL,
_created       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
_updated       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (situacao_id) REFERENCES Situacao(id)             ON UPDATE CASCADE,
FOREIGN KEY (pessoa_id, Pessoa) REFERENCES Pessoa(id, Pessoa) ON UPDATE cascade
);


CREATE TABLE NextDataEngineering.RegistroLocalizacao (
pessoa_id      int           NOT null,
Pessoa         varchar(50)   NOT NULL,
DATA           datetime      NULL,
lat            double(7, 5)  NULL,
lng            double(7, 5)  NULL,
situacao_id    int           NOT NULL,
_created       DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
_updated       DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (situacao_id) REFERENCES Situacao(id)             ON UPDATE CASCADE,
FOREIGN KEY (pessoa_id, Pessoa) REFERENCES Pessoa(id, Pessoa) ON UPDATE cascade
);

CREATE TABLE NextDataEngineering.LimitesDeslocamento(
pessoa_id      int            NOT null,
Pessoa         varchar(50)    NOT NULL,
lat1           double(7, 5)   NULL,
lng1           double(7, 5)   NULL,
raio           double(7, 5)   NULL,
FOREIGN KEY (pessoa_id, Pessoa) REFERENCES Pessoa(id, Pessoa) ON UPDATE cascade
);




