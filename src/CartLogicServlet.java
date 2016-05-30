

import java.io.IOException;
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
		// get cart from session
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		Cart cart = (Cart)session.getAttribute("cart");		

		request.setAttribute("cart", cart);
		
		// todo print out cart details
		int quantity = 0;
		if (request.getParameter("qty") != null) {
			quantity = Integer.parseInt(request.getParameter("qty"));
		}
		
		if (request.getParameter("add") != null) {
			String productId = request.getParameter("add");
			HashMap<String,String> productQueryMap = new HashMap<String,String>();
			productQueryMap.put("p.id",productId);
			ArrayList<Product> theProduct = null;
			try {
				theProduct = ProductFactory.getProduct(productQueryMap, false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (quantity == 0) {
				cart.remove(productId);
			} else {
				cart.add(theProduct.get(0), quantity);
			}
		}  
		
		if (request.getParameter("update") != null) {
			String productId = request.getParameter("update");
			HashMap<String,String> productQueryMap = new HashMap<String,String>();
			productQueryMap.put("p.id",productId);
			ArrayList<Product> theProduct = null;
			try {
				theProduct = ProductFactory.getProduct(productQueryMap, false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (quantity == 0) {
				cart.remove(productId);
			} else {
				cart.updateCartItem(theProduct.get(0), quantity);
			}
		} 

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
