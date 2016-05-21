

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HashMap<String,String> homePageMap = new HashMap<String,String>();
		homePageMap.put("p.id","2");
		//homePageMap.put("color","Slate");
		try {
			ArrayList<Product> productList = ProductFactory.getProduct(homePageMap);
//			ArrayList<Product> productList = new ArrayList<Product>();
//			Product prod1 = new Product();
//			prod1.setId("1");
//			prod1.setBrand("brand");
//			prod1.setName("name");
//			productList.add(prod1);
			
			request.setAttribute("productList", productList);
			RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher("/HomePageProductsServlet");
			dispatcher2.include(request, response);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productlist.jsp");
			
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
