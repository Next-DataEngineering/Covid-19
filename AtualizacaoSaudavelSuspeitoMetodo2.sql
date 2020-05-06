#Start Transaction;

Alter table registrolocalizacao add column a_processar int default 0;


UPDATE registrolocalizacao TAB1
INNER JOIN (
select hashgeo,hashdata from registrolocalizacao
group by hashgeo,hashdata having count(*) >1 and sum(situacao_id=3)>0
) TAB2 ON TAB1.hashgeo = TAB2.hashgeo
	And TAB1.hashdata = TAB2.hashdata				      
SET TAB1.situacao_id = 2, tab1.a_processar = 1
WHERE TAB1.situacao_id = 1;


Update Pessoa p 
Inner Join registrolocalizacao rl on p.id = rl.pessoa_id
Set p.situacao_id = 2
where rl.a_processar=1;


Insert INTO HistoricoSituacao (Data, hashdata, pessoa_id, situacao_id)
Select Data, hashdata, pessoa_id, situacao_id
From registrolocalizacao rl
Where rl.a_processar=1;


SELECT hashdata FROM registrolocalizacao WHERE a_processar = 1;

SELECT hashdata 
    FROM registrolocalizacao 
    WHERE hashdata > any(SELECT hashdata 
                         FROM registrolocalizacao 
                         WHERE a_processar = 1 group by hashdata);

Select pessoa_id from registrolocalizacao where a_processar=1;

Select * from registrolocalizacao where pessoa_id in (Select pessoa_id from registrolocalizacao where a_processar=1);

Select * from (Select * from registrolocalizacao where pessoa_id in (Select pessoa_id from registrolocalizacao where a_processar=1)) as tab where a_processar=0;

Select * from registrolocalizacao where pessoa_id='7f4078ec-8ae1-11ea-bc55-0242ac130003' and hashdata > 
(select hashdata from registrolocalizacao where pessoa_id='7f4078ec-8ae1-11ea-bc55-0242ac130003' and a_processar=1);

Select pessoa_id from (SELECT pessoa_id 
    FROM registrolocalizacao 
    WHERE hashdata > any(SELECT hashdata 
                         FROM registrolocalizacao 
                         WHERE a_processar = 1 group by hashdata)) as tab
                         Where pessoa_id in (Select pessoa_id from registrolocalizacao where a_processar=1);


Select * from registrolocalizacao where pessoa_id='7f4078ec-8ae1-11ea-bc55-0242ac130003';
Select * from registrolocalizacao where pessoa_id='1ccccf90-8fa4-11ea-bc55-0242ac130003';




#'7f4078ec-8ae1-11ea-bc55-0242ac130003'


#Alter table registrolocalizacao drop column a_processar;
#Commit;
