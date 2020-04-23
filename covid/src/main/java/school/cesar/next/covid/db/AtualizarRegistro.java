package school.cesar.next.covid.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class AtualizarRegistro {
    private Connection connection;

    public void conexaoBanco() throws SQLException {
		this.connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ NextDataEngineering?serverTimezone=UTC","root","inserirsenhalocal");

	}

    public Integer verificacaoSituacao(Pessoa pessoa) {
        try{    
            String id = pessoa.id;
            PreparedStatement selectPessoa = connection.prepareStatement("SELECT situacao_id from NextDataEngineering.Pessoa WHERE id=(?)");
			selectPessoa.setString(1, id);
            ResultSet resultado = selectPessoa.executeQuery();
            resultado.first();
            Integer situacao = resultado.getInt(0);
            return situacao;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return 0;
	   }
    }

    public Integer verificarHistorico(LocalDateTime data, Pessoa pessoa) {
        try{
            String id = pessoa.id;
            java.sql.Date sqlDate = java.sql.Date.valueOf(data.toLocalDate());
            PreparedStatement selectPessoa = connection.prepareStatement("SELECT situacao_id from NextDataEngineering.HistoricoSituacao WHERE DATA=(?) AND pessoa_id=(?)");
            selectPessoa.setString(1, id);
            selectPessoa.setDate(2, sqlDate);      
            ResultSet resultado = selectPessoa.executeQuery();
            resultado.first();
            Integer situacao = resultado.getInt(0);
            return situacao;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return 0;
       }
    }
    
    public void atualizarSituacao(Pessoa pessoa) {
        try{
            String id = pessoa.id;
            String update = "UPDATE NextDataEngineering.Pessoa SET situacao_id = 4 WHERE id=" + id + ";";
            PreparedStatement updateSituacao = connection.prepareStatement("UPDATE NextDataEngineering.Pessoa SET situacao_id = 4 WHERE id=(?)");
            updateSituacao.setString(1, id);
            updateSituacao.executeUpdate(update);
        }catch(SQLException sqle){
            sqle.printStackTrace();
       }
    } 

    public void run(Pessoa pessoa, Date data) {
        Integer situacao = verificacaoSituacao(pessoa);
        if (situacao == 3) {
            LocalDateTime ldt = LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault());
            LocalDateTime dataVerificacao = ldt.minusDays(15);
            Integer historico = verificarHistorico(dataVerificacao, pessoa);
            if (historico == 3) {
                atualizarSituacao(pessoa);
                System.out.println("A situação da pessoa " + pessoa.id + " foi atualizada");
            }
        }
    }
}