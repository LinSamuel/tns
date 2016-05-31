package tns;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Orders extends Database {
	
	public Orders() {
		attributes = new LinkedHashMap<String, String>();
		attributes.put("customer_id", "0");
		attributes.put("total", "0");
		attributes.put("subtotal", "0");
		attributes.put("tax", "0");
		attributes.put("shipping", "0");
		table = "orders";
	}
	
	public static void place(Customer customer, Cart cart) {
		
		// save customer
		customer.save();
		
		// create a new order and save
		Orders order = new Orders();
		order.set("customer_id", Integer.toString(customer.getId()));
		order.set("total", cart.getTotal());
		order.set("subtotal", cart.getSubtotal());
		order.set("tax", cart.getTax());
		order.set("shipping", cart.getShipping());
		
		order.save();
		
		// iterate through cartItems and save
		ArrayList<CartItem> cartItems = new ArrayList<CartItem>(cart.getItems().values());
		for (CartItem item: cartItems) {
			ProductOrders po = new ProductOrders();
			po.set("product_id", item.product.getId());
			po.set("order_id", Integer.toString( order.getId() ));
			po.set("qty", Integer.toString( item.qty ));
			po.save();
		}
	}

	public static Cart find(String id) {
		Cart cart = new Cart();
		
		ResultSet rs = query(id);
		
		double total = 0.0;
		double tax = 0.0;
		float subtotal = 0.0f;
		int qty;
		
		try {
			while (rs.next()) {
				Product p = new Product();
				
				p.setId(rs.getString("product_id"));
				p.setBrand(rs.getString("brand"));
				p.setName(rs.getString("name"));
				p.setColor(rs.getString("color"));
				p.setPrice(rs.getDouble("price"));
				p.setDefaultImage(rs.getString("default_image"));
				p.setDetails(rs.getString("details"));
				p.setSlug(rs.getString("slug"));
				p.setGender(rs.getString("gender"));
				p.setGender(rs.getString("gender"));
				p.setCategory(rs.getString("category"));
				
				total    = rs.getDouble("total");
				tax      = rs.getDouble("tax");
				subtotal = rs.getFloat("subtotal");
				qty      = rs.getInt("qty");
				
				cart.add(p, qty);
				
			}
			
			cart.setSubtotal(subtotal);
			cart.setTotal(total);
			cart.setTax(tax);
			
		} catch (SQLException e) {
			// nope
			System.out.println(e.getMessage());
		}
		
		return cart;
	}
	
	private static ResultSet query(String id) {
		
		Database.setConnection();
		ResultSet results = null;
		PreparedStatement prepared = null;
		
		String sql = "SELECT o.total, o.subtotal, o.tax,"
				+ " po.qty, "
				+ " p.color,p.slug, p.name, p.brand, p.price, p.default_image, p.details, p.id as product_id, "
				+ " p.gender, p.category "
				+ " FROM `orders` as o " + 
				"LEFT JOIN `product_orders` as po ON (o.id = po.order_id) " + 
				"LEFT JOIN `products` as p ON (po.product_id = p.id) " + 
				"WHERE o.id = ?";
		
		try {
			prepared = connection.prepareStatement(sql);
			prepared.setObject(1, id);
			results = prepared.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return results;
		}
		
		return results;
	}
}
