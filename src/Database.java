import java.sql.*;
import java.util.*;

public class Database {
	
	public static Connection connection;
	
	public static ResultSet queryHandler(Map<String, String> map) throws SQLException {
		ResultSet returnMe = null;	
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://" + Config.address + "/" + Config.dbname, Config.userName, Config.passWord);
		
		Statement statement = null;
		String sql = "SELECT brand, p.color as color, price, default_image, p.id as id, p.name as name, " +
			"p.details as details, p.slug as slug, p.gender as gender, p.category as category, " +
			"i.url as url FROM products as p LEFT JOIN product_images as pi ON (pi.`product_id` = p.id) " +
			"LEFT JOIN images as i ON (i.id = pi.image_id) ";
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
