import java.sql.*;

import javax.servlet.http.HttpServletRequest;

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
	
	/**
	 * todo remove?
	 * @param params
	 * @return
	 */
	public static Customer factory(String ... params) {
		Customer c = new Customer();
		
		
		return c;
	}
	
	/**
	 * factory - creates a customer based on request parameter
	 *
	 * @param request
	 * @return
	 */
	public static Customer factory(HttpServletRequest request) {
		Customer c = new Customer();
		
		c.set("first_name", request.getParameter("first_name"));
		c.set("last_name", request.getParameter("last_name"));
		c.set("address", request.getParameter("address"));
		c.set("city", request.getParameter("city"));
		c.set("state", request.getParameter("state"));
		c.set("zip", request.getParameter("zip"));
		return c;
	}
	
	/**
	 * todo finish
	 */
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
