package tns;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Checkout extends Database {

	public ArrayList<Product> getItems(String orderID) {
		
		// 
		ArrayList<Product> items = new ArrayList<Product>();
		
		return items;
	}
}
