

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get cart from session
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		Cart cart = (Cart)session.getAttribute("cart");
		
		request.setAttribute("cart", cart);
		
		// todo use template to print
		
	}
	
	public void CartView(Cart cart, PrintWriter out) {
		
		// uh oh no cart items
		if (cart.getCartItems().size() == 0) {
			out.println("<h1 class=\"cart-empty\"> Your cart seems sad :( </h1>");
			return;
		}
		
		
		for (CartItem item: cart.getCartItems()) {
			out.println("<div class=\"row cart-container\" id=\"" + item.product.getId() + "\"");
			out.println("<div class=\"cart-item\">");
			out.println("<div class=\"cart-img-container\">");
			out.println("<img src=\"/assets/images/products" + item.product.getDefaultImage() + "\" />");
			out.println("</div>");
			out.println("<div class=\"cart-description\">");
			out.println("<span class=\"product-attr product-name\">" + item.product.getName() + "</span>");
			out.println("<span class=\"product-attr product-brand\">" + item.product.getBrand() + "</span>");
			out.println("<span class=\"product-attr\">$ " + String.valueOf(item.product.getPrice()) +"</span>");
			out.println("<span class=\"product-attr\">qty: " + item.qty + "</span>");
			out.println("<button class=\"btn\" onclick=\"removeItems('" + item.product.getId() + "')\">remove</button>");
			out.println("</div></div></div>");
		}
		
		out.println("<div class=\"row\">");
		out.println("<p>Tax: $" + cart.getTax() + "</p>");
		out.println("<p id=\"subtotal\" >Subtotal: $"  + cart.getSubtotal() + " </p>");
		out.println("<p>Total: $ " + cart.getTotal() + "</p>");
		out.println("</div>");
		out.println("<div class=\"row\">");
		// todo fix index.php
		out.println("<button class=\"big-btn\" id=\"checkout-button\" onclick=\"window.location.href='/index.php/checkout'\" >Checkout</button>");
		out.println("</div>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
