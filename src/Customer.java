import java.sql.*;
import java.util.HashMap;

public class Customer extends Database {

	/**
	 * constructor - builds attribute hash map
	 * and initializes it to empty string
	 */
	public Customer() {
		attributes.put("first_name", "");
		attributes.put("last_name", "");
		attributes.put("address", "");
		attributes.put("city", "");
		attributes.put("state", "");
		attributes.put("zip", "");
	}
	
	public static Customer factory(String ... params) {
		Customer c = new Customer();
		
		
		return c;
	}
	
	public boolean exists() {
		try {
			PreparedStatement prepared;
			String sql = "SELECT * FROM `customers` WHERE first_name = ? AND last_name = ?"
					+ " AND address = ? AND city = ? AND state = ? AND zip = ?";
			prepared = connection.prepareStatement(sql);
			prepared.executeQuery();
			
		} catch (SQLException e) {
			
		}
		return false;
	}
}
