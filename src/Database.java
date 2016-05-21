import java.sql.*;
import java.util.*;

public class Database {
	
	public static Connection connection;
	
	/**
	 * table - String that is the name of the table 
	 * in the database. It is defaulted to products
	 */
	public String table = "products";
	
	protected int id;
	
	/**
	 * attributes - HashMap that maps directly to columns in 
	 * database table
	 */
	protected HashMap<String, String> attributes;
	
	public static ResultSet queryHandler(Map<String, String> map) throws SQLException {
		ResultSet returnMe = null;	
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://" + Config.address + "/" + Config.dbname, Config.userName, Config.passWord);
		
		Statement statement = null;
		String sql = "SELECT brand, p.color as color, price, default_image, p.id as id, p.name as name, " +
			"p.details as details, p.slug as slug, p.gender as gender, p.category as category, " +
			"i.url as url FROM products as p LEFT JOIN product_images as pi ON (pi.`product_id` = p.id) " +
			"LEFT JOIN images as i ON (i.id = pi.image_id) WHERE ";
		statement = connection.prepareStatement(sql);
		int i = 0;
		for (Map.Entry<String,String> kv : map.entrySet())
		{
			if (i++ == 0)
				sql += kv.getKey() + "=\"" + kv.getValue() + "\"";
			else
				sql += " AND " + kv.getKey() + "=\"" + kv.getValue() + "\"";
		}
		
		//System.out.println(sql);
		returnMe = statement.executeQuery(sql);		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return returnMe;
	}

	/**
	 * get - getter (magic method) to get an attribute in the 
	 * attribute HashMap. If attribute does not exists, returns null
	 * 
	 * Usage:
	 *   // given Customer c; and c's id = "123"
	 *   c.get("id"); // returns String "123"
	 * 
	 * @param key {String}
	 * @return {String}
	 */
	public String get(String key) {
		return attributes.get(key);
	}

	public int getId() {
		return id;
	}

	/**
	 * set - setter (magic method) to set attribute hash map
	 * the attribute hash-map maps directly to columns in database
	 * 
	 * Usage:
	 *   Customer c = new Customer() // extends Database
	 *   c.set("id", "123"); // note id is string
	 * @param key
	 * @param value
	 */
	public void set(String key, String value) {
		if (attributes.containsKey(key)) {
			attributes.put(key, value);
		}
	}

	/**
	 * setTable - sets the current table name
	 * for inheritance
	 * 
	 * usage:
	 *   Customer c = new Customer() // extends Database
	 *   c.setTable("customer");
	 * 
	 * @param table {String}
	 */
	public void setTable(String table) {
		this.table = table;
	}

	/**
	 * setId
	 * id's should be set apart from fillable attributes 
	 * @param id {int}
	 */
	public void setId(int id) {
		this.id = id;
	}
}
