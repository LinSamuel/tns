import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Orders extends Database {
	
	public Orders() {
		attributes.put("customer_id", "0");
		attributes.put("total", "0");
		attributes.put("subtotal", "0");
		attributes.put("tax", "0");
		attributes.put("shipping", "0");
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
			po.set("customer_id", Integer.toString( customer.getId() ));
			po.set("order_id", Integer.toString( order.getId() ));
			po.set("qty", Integer.toString( item.qty ));
			po.save();
		}
	}
}
