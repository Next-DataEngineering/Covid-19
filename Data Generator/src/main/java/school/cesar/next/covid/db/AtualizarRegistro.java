package school.cesar.next.covid.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AtualizarRegistro {
    private Connection connection;

    public void ConexaoBanco(Connection connection) {
		this.connection = connection;
	}

    public Integer verificacaoSituacao(Pessoa pessoa) {
        try{    
            String id = pessoa.id;
            String query = "SELECT situacao_id from NextDataEngineering.Pessoa WHERE id=" + id + ",;";
            Statement stat = connection.createStatement();
            ResultSet resultado = stat.executeQuery(query);
            resultado.first();
            Integer situacao = resultado.getInt(0);
            return situacao;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return 0;
	   }
    }

    public Integer verificarHistorico(Date data, Pessoa pessoa) {
        try{
            String id = pessoa.id;
            String query = "SELECT situacao_id from NextDataEngineering.HistoricoSituacao WHERE DATA=" + data + "AND pessoa_id=" + id + ";";
            Statement stat = connection.createStatement();
            ResultSet resultado = stat.executeQuery(query);
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
            Statement stat = connection.createStatement();
            stat.executeUpdate(update);
        }catch(SQLException sqle){
            sqle.printStackTrace();
       }
    } 

    public void run(Pessoa pessoa, Date data) {
        Integer situacao = verificacaoSituacao(pessoa);
        if (situacao == 3) {
            LocalDateTime ldt = LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault());
            ldt = ldt.minusDays(15);
            Date dataVerificacao = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
            Integer historico = verificarHistorico(dataVerificacao, pessoa);
            if (historico == 3) {
                atualizarSituacao(pessoa);
                System.out.println("A situação da pessoa " + pessoa.id + " foi atualizada");
            }
        }
    }
}