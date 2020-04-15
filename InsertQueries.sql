insert into NextDataEngineering.Situacao(id, descricao)
Values (1, "saudável");

insert into NextDataEngineering.Situacao(id, descricao)
Values (2, "suspeito");

insert into NextDataEngineering.Situacao(id, descricao)
Values (3, "confirmado");

insert into NextDataEngineering.Situacao(id, descricao)
Values (4, "curado");

insert into NextDataEngineering.Pessoa (id, Pessoa, situacao_id)
Values (UUID(), "Ricardo", 1);

insert into NextDataEngineering.HistoricoSituacao (pessoa_id, Data, situacao_id)
Values ("98838ae0-7f46-11ea-91c7-00ad1bf9c1e6", current_date(), 1);
