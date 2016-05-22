

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

/**
 * Servlet implementation class ProductListingServlet
 */
@WebServlet("/ProductListingServlet")
public class ProductListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This servlet's doGet method's purpose is to handle with getting the product information from the backend database
	 * depending on the gender and category chosen.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gender = request.getParameter("gender");
		String category = request.getParameter("category");
		response.setContentType("text/html");
		HashMap<String,String> productListingMap = new HashMap<String,String>();
		
		productListingMap.put("gender", gender);
		ArrayList<Product> productListing;
		String pageMode = "";
		boolean isComplex = false;
		if (gender.equals("men")){
			pageMode = "menGeneral";
		} else if (gender.equals("women")){
			pageMode = "womenGeneral";
		}
		if (category != null){
			productListingMap.put("category", category);
			isComplex = true;
			if((category.equals("bottoms")) & gender.equals("men")){
				pageMode = "menBottoms";
			} else if((category.equals("tops")) & gender.equals("men")){
				pageMode = "menTops";
			} if((category.equals("bottoms")) & gender.equals("women")){
				pageMode = "womenBottoms";
			} else if((category.equals("tops")) & gender.equals("women")){
				pageMode = "womenTops";
			} else if((category.equals("dresses")) & gender.equals("women")){
				pageMode = "womenDresses";
			} 
		}
		try {
			productListing = ProductFactory.getProduct(productListingMap,isComplex);
			request.setAttribute("productListing", productListing);
			request.setAttribute("pageMode", pageMode);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productlist.jsp");
			dispatcher.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
