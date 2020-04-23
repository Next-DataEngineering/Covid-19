package school.cesar.next.covid.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class EntradaCasoSuspeito {
	private Connection connection;

	public EntradaCasoSuspeito(Connection connection) {
		this.connection = connection;
	}
	
	public void adicionarPessoa(Pessoa pessoa, String situacao) {
		String id = pessoa.id;
		try{
			String queryPessoa = "insert into NextDataEngineering.Pessoa (id, situacao_id) Values (" + id + ", " + situacao + ", );";
			Statement adiconar = connection.createStatement();
			adiconar.executeQuery(queryPessoa);
		}catch(SQLException sqle){
			sqle.printStackTrace();
	   }
	}

	public void adicionarHistorico(Pessoa pessoa, Date dataSuspeita) {
		String id = pessoa.id;
		Date data = dataSuspeita;		
		try{
			String querySituacao = "insert into NextDataEngineering.HistoricoSituacao (pessoa_id, Data, situacao_id) Values (" + id + ", " + data + ", 2);";
			Statement adiconar = connection.createStatement();
			adiconar.executeQuery(querySituacao);
		}catch(SQLException sqle){
			sqle.printStackTrace();
	   }		
	}
}
