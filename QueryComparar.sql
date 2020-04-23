SELECT NextDataEngineering.RegistroLocalizacao.pessoa_id,
NextDataEngineering.RegistroLocalizacao.lat,
NextDataEngineering.RegistroLocalizacao.long,
NextDataEngineering.RegistroLocalizacao._updated INTO LocalizacaoBackUp
FROM NextDataEngineering.RegistroLocalizacao

SELECT *
	FROM NextDataEngineering.RegistroLocalizacao, LocalizacaoBackUp
	GROUP BY LocalizacaoBackUp.pessoa_id
	WHERE MINUTE(NextDataEngineering.RegistroLocalizacao._updated)-MINUTE(LocalizacaoBackUp._update) <=30 AND 
		NextDataEngineering.RegistroLocalizacao.lat-LocalizacaoBackUp.lat <X AND
		NextDataEngineering.RegistroLocalizacao.long-LocalizacaoBackUp.long <Y AND NOT
		NextDataEngineering.RegistroLocalizacao.pessoa_id=LocalizacaoBackUp.pessoa_id
        ;
;
