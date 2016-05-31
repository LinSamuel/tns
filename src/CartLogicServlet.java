

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tns.Cart;
import tns.Product;
import tns.ProductFactory;

/**
 * Servlet implementation class CartLogicServlet
 */
@WebServlet("/CartLogicServlet")
public class CartLogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartLogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// get cart from session
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		Cart cart = (Cart)session.getAttribute("cart");		

		request.setAttribute("cart", cart);
		
		// todo print out cart details
		int quantity = 0;
		if (request.getParameter("qty") == null) {
			return;
		}
		
		String add = request.getParameter("add");
		String update = request.getParameter("update");
		
		if (add == null && update == null) {
			return;
		}
		
		HashMap<String,String> productQueryMap = new HashMap<String,String>();
		ArrayList<Product> theProduct = null;
		quantity = Integer.parseInt(request.getParameter("qty"));
		
		// giant clusertfuck of if and else ifs
		String productId = (add != null) ? add : (update != null) ? update: null;
		
		productQueryMap.put("p.id",productId);
			
		try {
			theProduct = ProductFactory.getProduct(productQueryMap, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (quantity <= 0) {
			cart.remove(productId);
			//out.println(product);
			out.println("{\"tax\":\"" + cart.getTax() + "\"," +
					"\"subtotal\":\"" + cart.getSubtotal() + "\"," +
					"\"deleted\":\"" + productId + "\"," +
					"\"total\": \"" + cart.getTotal() + "\"}");
			
			return;
		} else if (update != null){
			cart.updateCartItem(theProduct.get(0), quantity);
		} else if (add != null) {
			cart.add(theProduct.get(0), quantity);
		}
		
		out.println("{\"tax\":" + cart.getTax() + "," +
				"\"subtotal\":" + cart.getSubtotal() + "," +
				"\"total\":" + cart.getTotal() + "}");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
