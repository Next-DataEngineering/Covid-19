package school.cesar.next.covid.db;

import java.sql.*;

public class BuscarPessoas {
    private Connection connection;


    public BuscarPessoas() throws SQLException{
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ NextDataEngineering?serverTimezone=UTC","root","MSpoloaquatico$02");
    }
    public void lerpessoa() {

        try{
            PreparedStatement lerPessoa = connection.prepareStatement("select id from NextDataEngineering.Pessoa LIMIT 50");

            ResultSet rs = lerPessoa.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");

                System.out.println(id);
            }

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
