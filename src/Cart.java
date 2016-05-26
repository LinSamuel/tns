import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	// todo change to Product
	private HashMap<String, CartItem> items;
	private int totalQty = 0;
	private float subtotal = 0;
	private double total = 0;
	private double tax = 0;
	private double taxRate = 0.08;
	private double shipping = 0;
	/**
	 * add - adds an item to cart given id and qty
	 * @param id {String}
	 * @param qty {int} quantity
	 */
	public void add(Product product, int qty) {
		CartItem item = items.get(product.getId());
		if (item != null) {
			item.qty += qty;
		} else {
			item.product = product;
			item.qty = qty;
			items.put(product.getId(), item);
		}
	}
	
	public CartItem remove(String id) {
		return items.remove(id);
	}
	
	public CartItem remove(Product p) {
		return items.remove(p.getId());
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
			subtotal += cartItem.qty * cartItem.product.getPrice();
		}
		
		tax = subtotal * taxRate;
		total = subtotal + tax;
		
	}
	
	public boolean isEmpty() {
		return totalQty == 0;
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
	
	public String getShipping() {
		return parseDecimal(shipping);
	}
	
	public HashMap<String, CartItem> getItems() {
		return items;
	}
	
	public ArrayList<CartItem> getCartItems() {
		return new ArrayList<CartItem>(items.values());
	}

	private String parseDecimal(double number) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(number);
	}
}
