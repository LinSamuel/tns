package tns;

import java.util.LinkedHashMap;

public class ProductOrders extends Database {
	public ProductOrders() {
		attributes = new LinkedHashMap<String, String>();
		attributes.put("product_id","");
		attributes.put("order_id", "");
		attributes.put("qty", "0");
		table = "product_orders";
	}
}
