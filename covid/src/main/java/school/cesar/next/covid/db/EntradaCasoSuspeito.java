package school.cesar.next.covid.db;

import java.sql.*;
import java.util.Date;

public class EntradaCasoSuspeito{
	private Connection connection;

	public EntradaCasoSuspeito() throws SQLException {
		this.connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ NextDataEngineering?serverTimezone=UTC","root","inserirsenhalocal");

	}

	public void adicionarPessoa(Pessoa pessoa) {
		String id = pessoa.id;
		try{
			//String queryPessoa = "insert into NextDataEngineering.Pessoa (id, situacao_id) Values (" + id + ", 2);";
			PreparedStatement insertPessoa = connection.prepareStatement("insert into NextDataEngineering.Pessoa (id, situacao_id) values (?,?)");
			insertPessoa.setString(1, id);
			insertPessoa.setInt(2, 2);
			//Statement adiconar = connection.insertPessoa();
			insertPessoa.executeUpdate();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}

	public void adicionarHistorico(Pessoa pessoa, Date dataSuspeita) {
		String id = pessoa.id;
		Date data = dataSuspeita;
		try{
			//String querySituacao = "insert into NextDataEngineering.HistoricoSituacao (pessoa_id, DATA, situacao_id) Values (" + id + ", " + data + ", 2);";
			//Statement adiconar = connection.createStatement();
			PreparedStatement insertHistorico = connection.prepareStatement("insert into NextDataEngineering.HistoricoSituacao (pessoa_id, Data, situacao_id) values (?,?,?)");
			insertHistorico.setString(1, id);
			insertHistorico.setDate(2, (java.sql.Date) data);
			insertHistorico.setInt(3, 2);
			insertHistorico.executeUpdate();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
}

