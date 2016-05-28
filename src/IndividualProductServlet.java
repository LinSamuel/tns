
import java.io.IOException;
import java.io.PrintWriter;
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
			PrintWriter out = response.getWriter();
			out.println("	<head>\n" + 
					"		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
					"		<title>Individual Product Page</title>\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" + 
					"		<script src=\"js/imageswap.js\"></script>\n" + 
					"	</head>");
			Template.printHeader(out);
			out.println("<body>\n");
			
			productListing = ProductFactory.getProduct(productListingMap,false);
			request.setAttribute("productDetails", productListing);
			request.setAttribute("theProduct", productListing.get(0));
			
			/////
			System.out.println("");
			//
			
			if (productListing.isEmpty())
				out.println("<h2>No Results Found</h2>");
			else
			{
				for (Product item : productListing)
				{
					out.println("	<div class=\"row\">\n" + 
							"		<div id=\"productDisplay\">\n" + 
							"			<div class=\"big-image\">\n" + 
							"				<img id=\"bigpic\" src=\"img/products" + item.getDefaultImage() + "\" alt=\"productImage\" width=\"auto\" height=\"auto\">\n" + 
							"			</div>\n" + 
							"			<div class=\"big-image-body\">\n" + 
							"				<div>");

					for (String images : item.getImages())
					{
						out.println("						<img onclick=\"imageswap(this)\" src=\"img/products"
								+ images + "\" alt=\"productImage\" width=\"15%\" height=\"auto\">");

					}
					out.println("				</div>\n" + 
							"				<h3 class=\"product-name\">" + item.getName() + "</h3>\n" + 
							"				<p> by <span class=\"product-brand\">" + item.getBrand() + "</span></p>\n" + 
							"				<br>\n" + 
							"				<p class=\"product-name\">Price</p>\n" + 
							"				<p>" + item.getName() + "</p>\n" + 
							"				<br>\n" + 
							"				<p class=\"product-name\"> Color</p>\n" + 
							"				<p></p>\n" + 
							"				<p>" + item.getColor() + "</p>\n" + 
							"				<br>\n" + 
							"				<p class=\"product-name\">Details</p>\n" + 
							"				<p></p>\n" + 
							"				<p>" + item.getDetails() + "</p>\n" + 
							"				<br>\n" + 
							"				<input id=\"product-qty\" class=\"mailinglist-input\" type=\"number\" name=\"product-qty\" value=\"1\">\n" + 
							"				<button onclick=\"addItems(${product.id})\">Add Items To Cart </button>\n" + 
							"			</div>\n" + 
							"		</div>\n" + 
							"	</div>");
				}
			}
			
			Template.printFooter(out);
			
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
