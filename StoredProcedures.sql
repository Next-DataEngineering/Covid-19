DELIMITER $$
Create procedure atualizacaoRegistro()
	BEGIN
    DECLARE Pessoa varchar(255);
    DECLARE PessoaVerificar varchar(255);
    DECLARE DataCruzamento INT;
    DECLARE DataVerificar INT;
    DECLARE done BOOLEAN;
    DECLARE counter  INT;
    DECLARE curPessoaSuspeita 
		CURSOR FOR 
			Select pessoa_id, hashdata FROM registrolocalizacao WHERE a_processar=1;#pessoas que necessitam ser mudadas e data de cruzmento
	DECLARE curVerificar
		CURSOR FOR
			Select pessoa_id, hashdata from registrolocalizacao where pessoa_id in (Select pessoa_id from registrolocalizacao where a_processar=1);#todas as datas dos ids anteriores
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    SET     counter  = 4;      
    
	OPEN curPessoaSuspeita;
    OPEN curVerificar;
    
    atualizarSitucacao:  WHILE counter <= 5 DO 
		FETCH curPessoaSuspeita into Pessoa, DataCruzamento;
        FETCH curVerificar into PessoaVerificar, DataVerificar;
       
       
        IF DataVerificar > DataCruzamento and Pessoa=PessoaVerificar THEN 
        Update registrolocalizacao
        SET situacao_id=2
		WHERE pessoa_id=Pessoa and hashdata=DataVerificar;
        END IF;
        SET counter = counter + 1;               
    END WHILE atualizarSitucacao;
	
    CLOSE curPessoaSuspeita;
    CLOSE curVerificar;
  
END$$
DELIMITER ;