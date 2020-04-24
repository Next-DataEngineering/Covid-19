package school.cesar.next.covid.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AtualizarSituacao {
    private ConexaoLocal conexaoLocal = new ConexaoLocal();
    private Connection connection = conexaoLocal.getconnection();

    public AtualizarSituacao() throws SQLException {
    }

    public Integer lerSituacao(Pessoa pessoa) {
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
    public void atualizarSituacao(Integer situacao_id, Pessoa pessoa) {
        try{
            String id = pessoa.id;
            String update = "UPDATE NextDataEngineering.Pessoa SET situacao_id = (?) WHERE id=" + id + ";";
            PreparedStatement updateSituacao = connection.prepareStatement("UPDATE NextDataEngineering.Pessoa SET situacao_id = (?) WHERE id=(?)");
            updateSituacao.setInt(1, situacao_id);
            updateSituacao.setString(2, id);
            updateSituacao.executeUpdate(update);
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    public Integer atualizarHistorico(LocalDateTime data, Pessoa pessoa, Integer situacao_id) {
        try{
            String id = pessoa.id;
            java.sql.Date sqlDate = java.sql.Date.valueOf(data.toLocalDate());
            PreparedStatement selectPessoa = connection.prepareStatement("insert into NextDataEngineering.HistoricoSituacao (pessoa_id, Data, situacao_id) values (?,?,?)");
            selectPessoa.setString(1, id);
            selectPessoa.setDate(2, sqlDate);
            selectPessoa.setInt(3, situacao_id);
            ResultSet resultado = selectPessoa.executeQuery();
            resultado.first();
            Integer situacao = resultado.getInt(0);
            return situacao;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return 0;
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

