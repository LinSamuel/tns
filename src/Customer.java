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
	
	/**
	 * save - public facing function that returns
	 * the last inserted id and sets it to its own attribute
	 * @return
	 */
	public int save() {
		try {
			java.sql.PreparedStatement prepared;
			// connect
			String sql = Utils.prepareStatement(attributes, table);
			prepared = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			prepared.setObject(1, attributes.get("first_name"));
			prepared.setObject(2, attributes.get("last_name"));
			prepared.setObject(3, attributes.get("address"));
			prepared.setObject(4, attributes.get("first_name"));
			prepared.setObject(5, attributes.get("city"));
			prepared.setObject(6, attributes.get("zip"));
			
			int id = prepared.executeUpdate();
			
			if (id == 0) {
				throw new SQLException("id failed");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
		setId(id);
		return id;
	}
}
