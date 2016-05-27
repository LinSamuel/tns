

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

/**
 * Servlet implementation class ProductListingServlet
 */
@WebServlet("/ProductListingServlet")
public class ProductListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public ProductListingServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	Template.printHeader(out);
        	
    		String gender = request.getParameter("gender");
    		String category = request.getParameter("category");
    		response.setContentType("text/html");
    		HashMap<String,String> productListingMap = new HashMap<String,String>();
    		
    		productListingMap.put("gender", gender);
    		ArrayList<Product> productListing;
    		String pageMode = "";
    		boolean isComplex = false;
    		if (gender == null)
    		{
    			Template.printBody(out, "<h1 style=\"text-align:center\">INVALID PAGE -- USE NAVIGATIONS! :)</h1>");
    			Template.printFooter(out);
    			
    			return;
    		}
    		else if (gender.equals("men")){
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
    		try{
    			productListing = ProductFactory.getProduct(productListingMap,isComplex);
    			if (productListing.isEmpty())
    				Template.printBody(out, "<h2>No Results Found</h2>");
    			else
    			{
    				out.println("<div class=\"row\">");
    				if (pageMode.equals("menGeneral"))
    				{
    					out.println("	<div class=\"sidebar\">\n" + 
    							"		<a href=\"ProductListingServlet?gender=men\"> <h1 style=\"color: #5E9DC8\">Men</h1> </a>\n" + 
    							"	    <a href=\"ProductListingServlet?gender=men&category=tops\">\n" + 
    							"	        <h4>Tops</h4> </a>\n" + 
    							"	    <a href=\"ProductListingServlet?gender=men&category=bottoms\">\n" + 
    							"	        <h4>Bottoms</h4> </a>\n" + 
    							"	</div>");
    				}
    				else if (pageMode.equals("womenGeneral"))
    				{
    					out.println("	<div class=\"sidebar\">\n" + 
    							"		<a href=\"ProductListingServlet?gender=women\"> <h1 style=\"color: #5E9DC8\">Women</h1> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=tops\">\n" + 
    							"			<h4>Tops</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=bottoms\">\n" + 
    							"			<h4>Bottoms</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=dresses\">\n" + 
    							"			<h4>Dresses</h4> </a>\n" + 
    							"	</div>");
    				}
    				else if (pageMode.equals("menBottoms"))
    				{
    					out.println("	<div class=\"sidebar\">\n" + 
    							"		<a href=\"ProductListingServlet?gender=men\"> <h1>Men</h1> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=men&category=tops\">\n" + 
    							"		    <h4>Tops</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=men&category=bottoms\">\n" + 
    							"		    <h4 style=\"color: #5E9DC8\">Bottoms</h4> </a>\n" + 
    							"	</div>");
    				}
    				else if (pageMode.equals("menTops"))
    				{
    					out.println("	<div class=\"sidebar\">\n" + 
    							"		<a href=\"ProductListingServlet?gender=men\"> <h1>Men</h1> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=men&category=tops\">\n" + 
    							"			<h4 style=\"color: #5E9DC8\">Tops</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=men&category=bottoms\">\n" + 
    							"			<h4>Bottoms</h4> </a>\n" + 
    							"	</div>");
    				}
    				else if (pageMode.equals("womenBottoms"))
    				{
    					out.println("	<div class=\"sidebar\">\n" + 
    							"		<a href=\"ProductListingServlet?gender=women\"> <h1>Women</h1> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=tops\">\n" + 
    							"		    <h4>Tops</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=bottoms\">\n" + 
    							"		    <h4 style=\"color: #5E9DC8\">Bottoms</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=dresses\">\n" + 
    							"		    <h4>Dresses</h4> </a>\n" + 
    							"	</div>");
    				}
    				else if (pageMode.equals("womenDresses"))
    				{
    					out.println("	<div class=\"sidebar\">\n" + 
    							"		<a href=\"ProductListingServlet?gender=women\"> <h1>Women</h1> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=tops\">\n" + 
    							"		    <h4>Tops</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=bottoms\">\n" + 
    							"		    <h4>Bottoms</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=dresses\">\n" + 
    							"		    <h4 style=\"color: #5E9DC8\">Dresses</h4> </a>\n" + 
    							"	</div>");
    				}
    				else if (pageMode.equals("womenTops"))
    				{
    					out.println("	<div class=\"sidebar\">\n" + 
    							"		<a href=\"ProductListingServlet?gender=women\"> <h1 >Women</h1> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=tops\">\n" + 
    							"		    <h4 style=\"color: #5E9DC8\">Tops</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=bottoms\">\n" + 
    							"		    <h4>Bottoms</h4> </a>\n" + 
    							"		<a href=\"ProductListingServlet?gender=women&category=dresses\">\n" + 
    							"		    <h4>Dresses</h4> </a>\n" + 
    							"	</div>");
    				}
    				out.println("<div id=\"productList\">");
    				for (Product item : productListing)
    				{
    					out.println("	<div class=\"main-page\">\n" + 
    							"	<a href = \"IndividualProductServlet?productID=" + item.getId() + "\"> <img class =\"product-image\" src=\"img/products" + item.getDefaultImage() + "\" alt=productImage width=\"150\" height=\"auto\"/></a>\n" + 
    							"	<p class=\"product-name\">" + item.getName() + "</p>\n" + 
    							"	<p class=\"product-brand\">" + item.getBrand() + "</p>\n" + 
    							"	<p>" + item.getPrice() + "</p>\n" + 
    							"	</div>");
    				}
    				out.println("</div>\n" + 
    						"</div>");
    				
    			}
    		} catch (Exception e)
    		{
    			e.printStackTrace();
    		}
    		
    		
        	
        	Template.printFooter(out);
        	
        } 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This servlet's doGet method's purpose is to handle with getting the product information from the backend database
	 * depending on the gender and category chosen.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String gender = request.getParameter("gender");
//		String category = request.getParameter("category");
//		response.setContentType("text/html");
//		HashMap<String,String> productListingMap = new HashMap<String,String>();
//		
//		productListingMap.put("gender", gender);
//		ArrayList<Product> productListing;
//		String pageMode = "";
//		boolean isComplex = false;
//		if (gender.equals("men")){
//			pageMode = "menGeneral";
//		} else if (gender.equals("women")){
//			pageMode = "womenGeneral";
//		}
//		if (category != null){
//			productListingMap.put("category", category);
//			isComplex = true;
//			if((category.equals("bottoms")) & gender.equals("men")){
//				pageMode = "menBottoms";
//			} else if((category.equals("tops")) & gender.equals("men")){
//				pageMode = "menTops";
//			} if((category.equals("bottoms")) & gender.equals("women")){
//				pageMode = "womenBottoms";
//			} else if((category.equals("tops")) & gender.equals("women")){
//				pageMode = "womenTops";
//			} else if((category.equals("dresses")) & gender.equals("women")){
//				pageMode = "womenDresses";
//			} 
//		}
//		try {
//			productListing = ProductFactory.getProduct(productListingMap,isComplex);
//			request.setAttribute("productListing", productListing);
//			request.setAttribute("pageMode", pageMode);
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productlist.jsp");
//			dispatcher.include(request, response);
//			
//			// new code here
//
//			
//			
//			
//			
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		processRequest(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
