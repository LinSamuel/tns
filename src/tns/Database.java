package tns;
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
	protected LinkedHashMap<String, String> attributes;
	
	public static Connection setConnection() {
		if (Database.connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://" + Config.address + "/" + Config.dbname, Config.userName, Config.passWord);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return connection;
	}
	public static Connection getConnection() {
		if (Database.connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://" + Config.address + "/" + Config.dbname, Config.userName, Config.passWord);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return connection;
	}
	public static ResultSet queryHandler(Map<String, String> map) throws SQLException {
		ResultSet returnMe = null;	
		try {
		
		PreparedStatement pstatement = null;
		String sql = "SELECT brand, p.color as color, price, default_image, p.id as id, p.name as name, "
				+ "p.details as details, p.slug as slug, p.gender as gender, p.category as category, "
				+ "i.url as url FROM products as p LEFT JOIN product_images as pi ON (pi.product_id = p.id) "
				+ "LEFT JOIN images as i ON (i.id = pi.image_id) WHERE ";
		
		sql += Utils.prepareWhere(map);
		sql += ";";
		pstatement = connection.prepareStatement(sql);
		int i = 1;
		
		for (String value: map.values()) {
			System.out.println(value);
			pstatement.setObject(i, value);
			i++;
		}	
		
		System.out.println(sql);
		returnMe = pstatement.executeQuery();
			
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
		return this.id;
	}
	
	/**
	 * save - inserts current attributes into table
	 * 
	 * usage:
	 *   Customer c = new Customer();
	 *   c.set("first_name", "john");
	 *   c.save();
	 *   // returns prime key
	 * 
	 * @return {int}
	 */
	public int save() {
		try {
			String sqlStatement = Utils.prepareInsert(attributes, table);
			PreparedStatement prepared = getConnection().prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
			
			int i = 1;
			for (String value : attributes.values()) {
				prepared.setObject(i, value);
				i++;
			}
			
			int id = prepared.executeUpdate();
			
			if (id <= 0) {
				throw new SQLException("Nope id's didnt return anything");
			}
			
			ResultSet rs = prepared.getGeneratedKeys();
			if (rs.next()){
				id = rs.getInt(1);
			} else {
				id = 4444;
			}
			setId(id);
			rs.close();

			prepared.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
		return id;
	}
	
	public boolean exists() {
		
		return true;
	}

	/**
	 * set - setter (magic method) to set attribute hash map
	 * the attribute hash-map maps directly to columns in database
	 * 
	 * Usage:
	 *   Customer c = new Customer(); // extends Database
	 *   c.set("first_name", "123");
	 * @param key {String}
	 * @param value {String}
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
	public int setId(int id) {
		this.id = id;

		return id;
	}
}
