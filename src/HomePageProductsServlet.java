

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomePageProductsServlet
 */
@WebServlet("/HomePageProductsServlet")
public class HomePageProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * theGetFunction with the purpose for getting the information about products from the backend database (first part
	 * for the first requirement in the assignment descriptions. It will set the attributes of the HTTPServletRequest
	 * with ArrayLists of some of the women's and men's products that will be displayed in the front page
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HashMap<String,String> homePageMapWomen = new HashMap<String,String>();
		homePageMapWomen.put("p.id","17");
		homePageMapWomen.put("name", "Laurel Tank");
		homePageMapWomen.put("brand", "Madame Shoushou");
		HashMap<String,String> homePageMapMen = new HashMap<String,String>();
		homePageMapMen.put("p.id","3");
		homePageMapMen.put("name", "Long-sleeve Henley");
		homePageMapMen.put("color", "Indigo Large Check");
		try {
			ArrayList<Product> productListWomen = ProductFactory.getProduct(homePageMapWomen, false);
			ArrayList<Product> productListMen = ProductFactory.getProduct(homePageMapMen, false);
			
			request.setAttribute("productListHomeWomen", productListWomen);
			request.setAttribute("productListHomeMen", productListMen);

			
		} catch (Exception e) {
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
