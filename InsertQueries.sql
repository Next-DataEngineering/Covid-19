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
