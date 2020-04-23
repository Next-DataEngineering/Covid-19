package school.cesar.next.covid.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AtualizarRegistro {
    private Connection connection;

    public void ConexaoBanco(Connection connection) {
		this.connection = connection;
	}

    public Boolean verificacaoSituacao(String id) {
        try{    
            String query = "select situacao_id from NextDataEngineering.Pessoa where id=" + id + ",;";
            Statement adiconar = connection.createStatement();
            ResultSet resultado = adiconar.executeQuery(query);
            Integer situacao = resultado.getInt(0);
            if (situacao == 3){
                return true;
            }
            else {
                return false;
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
	   }
    }

        

}