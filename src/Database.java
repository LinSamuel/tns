import java.sql.*;
import java.util.*;

public class Database {
	
	public static Connection connection;
	
	public static ResultSet queryHandler(Map<String, String> map) throws SQLException {
		ResultSet returnMe = null;	
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://" + Config.address + "/" + Config.dbname, Config.userName, Config.passWord);
		
		PreparedStatement statement = null;
		String sql = "SELECT brand, p.color as color, price, default_image, p.id as id, p.name as name, " +
			"p.details as details, p.slug as slug, p.gender as gender, p.category as category, " +
			"i.url as url FROM products as p LEFT JOIN product_images as pi ON (pi.`product_id` = p.id) " +
			"LEFT JOIN images as i ON (i.id = pi.image_id) ";
		statement = connection.prepareStatement(sql);
		for (Map.Entry<String, String> kv : map.entrySet())
		{
			sql += kv.getKey() + " = ? AND ";
		}
		// strip out " AND "
		sql = sql.substring(0, sql.length() - 5);
		
		statement = connection.prepareStatement(sql);
		
		int i = 1;
		for (Map.Entry<String,String> kv : map.entrySet())
		{
			statement.setString(i++, kv.getValue());
		}
		
		System.out.println(statement.toString());
		returnMe = statement.executeQuery();		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return returnMe;
	}
}
