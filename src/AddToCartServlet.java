import tns.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This servlet adds items to the cart.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// get cart from session
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		
		Cart cart = (Cart)session.getAttribute("cart");
		
		Product productToAdd = (Product)request.getAttribute("theProduct");
		int qtyToAdd = (int)request.getAttribute("totalQty");
		
		if(productToAdd != null) {
			cart.add(productToAdd, qtyToAdd);
		}
		
		request.setAttribute("cartQty", cart.getTotalQty());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
