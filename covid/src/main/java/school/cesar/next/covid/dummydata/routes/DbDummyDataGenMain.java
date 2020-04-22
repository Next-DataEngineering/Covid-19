package school.cesar.next.covid.dummydata.routes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.UUID;

public class DbDummyDataGenMain {
	public static final long DOIS_MINUTOS = 2*60*1000;
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root","inserirsenhalocal");//conectar de verdade aqui
		String userId = UUID.randomUUID().toString();
		

		PreparedStatement insertPessoa = connection.prepareStatement("Insert into Pessoa (id) values (?)");		
		insertPessoa.setString(1, userId);
		insertPessoa.executeUpdate();
		
		
		DbDummyDataProcessor proc = new DbDummyDataProcessor(userId, connection);
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2019);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 0);
		DummyDataGenerator gen = new DummyDataGenerator("pcr-pilar", cal.getTime(), DOIS_MINUTOS, 1000000l, proc);
		gen.run();
	}
}
