import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	// todo change to Product
	private HashMap<String, CartItem> items;
	private int totalQty;
	private float subtotal;
	private double total;
	private double tax;
	private double taxRate = 0.08;

	/**
	 * add - adds an item to cart given id and qty
	 * @param id {String}
	 * @param qty {int} quantity
	 */
	public void add(String id, int qty) {
		CartItem item = items.get(id);
		if (item != null) {
			item.qty += qty;
			items.put(id, item);
		} else {
			
			// todo query database and get item price;
			double price = 13.99;
			// price = product.find('id');
			
			item.id = id;
			item.qty = qty;
			item.price = price;
			
			items.put(id, item);
		}
	}
	
	public CartItem remove(String id) {
		return items.remove(id);
	}
	
	
	/**
	 * update
	 * 
	 * updates totalQty, subtotal, tax, and total
	 * for the current cart
	 */
	public void update() {
		totalQty = 0;
		subtotal = 0;
		
		for (Map.Entry<String, CartItem> entry: items.entrySet()) {
			CartItem cartItem = entry.getValue();
			totalQty += cartItem.qty;
			subtotal += cartItem.qty * cartItem.price;
		}
		
		tax = subtotal * taxRate;
		total = subtotal + tax;
		
	}
	
	public String getSubtotal() {
		return parseDecimal(subtotal);
	}
	
	public String getTotal() {
		return parseDecimal(total);
	}
	
	public String getTax() {
		return parseDecimal(tax);
	}

	public String getTaxRate() {
		return parseDecimal(taxRate);
	}
	
	public int getTotalQty() {
		return totalQty;
	}
	private String parseDecimal(double number) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(number);
	}
}
