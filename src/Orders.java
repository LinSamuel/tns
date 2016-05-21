import java.sql.SQLException;
import java.sql.Statement;

public class Orders extends Database {
	
	public Orders() {
		attributes.put("customer_id", "0");
		attributes.put("total", "0");
		attributes.put("subtotal", "0");
		attributes.put("tax", "0");
		attributes.put("shipping", "0");
	}
	
	public int save() {
		try {
			java.sql.PreparedStatement prepared;
			// connect
			
			// build sql prepared statement
			String sql = Utils.prepareStatement(attributes, table);
			prepared = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			prepared.setInt(1, Integer.parseInt(attributes.get("customer_id")) );
			prepared.setFloat(2, Float.parseFloat(attributes.get("total")) );
			prepared.setFloat(3,  Float.parseFloat(attributes.get("subtotal")) );
			prepared.setFloat(4, Float.parseFloat(attributes.get("tax")) );
			prepared.setFloat(5, Float.parseFloat(attributes.get("shipping")) );
			
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
