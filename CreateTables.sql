CREATE DATABASE NextDataEngineering;

CREATE TABLE NextDataEngineering.Situacao(
situacao_id    int         NOT NULL,
descricao      varchar(50) NOT NULL,
_created       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
_updated       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (situacao_id)
);

CREATE TABLE NextDataEngineering.Pessoa(
pessoa_id     int         NOT NULL AUTO_INCREMENT,
Pessoa        varchar(50) NOT NULL,
situacao_id   int         NOT NULL,
_created      DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
_updated      DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (pessoa_id)
);


CREATE TABLE NextDataEngineering.HistoricoSituacao(
Pessoa         varchar(50) NOT NULL,
DATA           datetime    NOT NULL,
situacao_id    int         NOT NULL,
_created       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
_updated       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (situacao_id),
FOREIGN KEY (Pessoa)
);


CREATE TABLE NextDataEngineering.RegistroLocalizacao (
Pessoa    varchar(50)   NOT NULL,
DATA      datetime      NULL,
lat       double(7, 5)  NULL,
lng       double(7, 5)  NULL,
situacao  int           NOT NULL,
_created  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
_updated  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (situacao_id),
FOREIGN KEY (Pessoa)
);

CREATE TABLE NextDataEngineering.LimitesDeslocamento(
Pessoa    varchar(50)    NOT NULL,
lat1      double(7, 5)   NULL,
lng1      double(7, 5)   NULL,
raio      double(7, 5)   NULL,
FOREIGN KEY (pessoa)
);




