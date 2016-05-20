import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Product {
	// Incorporate mySQL driver
	public static void queryDatabase() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	// Connect to the test database
	Connection connection = DriverManager.getConnection("jdbc:mysql:///tnsdb","mytestuser", "mypassword");
	
	
	connection.close();
}
}
