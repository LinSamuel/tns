package tns;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Cart object
 * 
 * +adds to cart
 * add(Product p, int qty);
 * 
 * +remove from cart
 * remove(Product p); 
 * remove(String key);
 * 
 * @author john
 *
 */
public class Cart {
	
	private HashMap<String, CartItem> items;
	private int totalQty = 0;
	private float subtotal = 0;
	private double total = 0;
	private double tax = 0;
	private double taxRate = 0.08;
	private double shipping = 0;
	
	public Cart() {
		items = new HashMap<String, CartItem>();
	}

	/**
	 * add - adds an item to cart given id and qty
	 * 
	 * usage:
	 * // Product p = new Product(); 
	 * Cart c = new Cart();
	 * c.add(product, 1);
	 * 
	 * @param id {String}
	 * @param qty {int} quantity
	 */
	public void add(Product product, int qty) {
		if (items.containsKey(product.getId())) {
			items.get(product.getId()).qty += qty;
		} else {
			CartItem item = new CartItem();
			item.product = product;
			item.qty = qty;
			items.put(product.getId(), item);
		}
		update();
	}
	
	public void updateCartItem(Product product, int qty){
		if((qty == 0) && (items.containsKey(product.getId()))){
			remove(product);
		}
		if (items.containsKey(product.getId())) {
			items.get(product.getId()).qty = qty;
		}
		update();
	}
	
	/**
	 * remove - removes an item from the cart by String id
	 * @param id {String}
	 */
	public void remove(String id) {
		items.remove(id);
		update();
	}
	
	/**
	 * remove - removes a item from the cart by Product object
	 * @param p
	 */
	public void remove(Product p) {
		items.remove(p.getId());
		update();
	}
	
	
	/**
	 * update - calculates total, subtotal, and tax based on cart items
	 * 
	 * usage:
	 * Cart c = new Cart();
	 * c.update(); 
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
	
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	public String getSubtotal() {
		return parseDecimal(subtotal);
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public String getTotal() {
		return parseDecimal(total);
	}
	
	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getTax() {
		return parseDecimal(tax);
	}

//	public void setTaxRate(double taxRate) {
//		this.taxRate = taxRate;
//	}

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
	
	/**
	 * getCartItems - returns items from cart as an ArrayList
	 * 
	 * @return {ArrayList<CartItem>}
	 */
	public ArrayList<CartItem> getCartItems() {
		return new ArrayList<CartItem>(items.values());
	}

	private String parseDecimal(double number) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(number);
	}
}
