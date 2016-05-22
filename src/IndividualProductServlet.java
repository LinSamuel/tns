

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndividualProductServlet
 */
@WebServlet("/IndividualProductServlet")
public class IndividualProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This servlet's doGet function has the purpose of getting the product information to display on the individual product
	 * detail pages.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String productId = request.getParameter("productID");
		response.setContentType("text/html");
		HashMap<String,String> productListingMap = new HashMap<String,String>();
		productListingMap.put("p.id", productId);
		ArrayList<Product> productListing;
		try {
			productListing = ProductFactory.getProduct(productListingMap,false);
			request.setAttribute("productDetails", productListing);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productdetails.jsp");
			dispatcher.include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
