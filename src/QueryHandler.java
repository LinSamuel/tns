import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class QueryHandler {
	// Incorporate mySQL driver
	public static void queryDatabase() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	// Connect to the test database
	Connection connection = DriverManager.getConnection("jdbc:mysql:///tnsdb","mytestuser", "mypassword");
	
	
	connection.close();
}
}
