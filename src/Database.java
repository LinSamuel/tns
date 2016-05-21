import java.sql.*;
import java.util.*;

public class Database {
	
	public static Connection connection;
	private static final String address = "localhost";
	private static final String dbname = "tnsdb";
	private static final String userName = "root";
	private static final String passWord = "root";
	
	public static ResultSet queryHandler(Map<String, String> map) throws SQLException {
		ResultSet returnMe = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://" + address + "/" + dbname, userName, passWord);
		
		Statement statement = null;
		String sql = "SELECT * FROM products WHERE ";
		statement = connection.prepareStatement(sql);
		int i = 0;
		for (Map.Entry<String,String> kv : map.entrySet())
		{
			if (i++ == 0)
				sql += kv.getKey() + "=\"" + kv.getValue() + "\"";
			else
				sql += " AND " + kv.getKey() + "=\"" + kv.getValue() + "\"";
		}
		
		System.out.println(sql);
		returnMe = statement.executeQuery(sql);		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return returnMe;
	}
}
