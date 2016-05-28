
import java.io.IOException;
import java.io.PrintWriter;
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
	 * This servlet's doGet function is called to serve the purpose of displaying the products in the home page.
	 * It gets the attributes from the HomePageProductsServlet, then redirects the information into the indexSkeleton.jsp
	 * which will ultimately all get put together in index.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			RequestDispatcher productPicsDispatcher = getServletContext().getRequestDispatcher("/HomePageProductsServlet");
			productPicsDispatcher.include(request, response);
			RequestDispatcher viewHistoryDispatcher = getServletContext().getRequestDispatcher("/VisitHistoryServlet");
			viewHistoryDispatcher.include(request, response);
			//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexSkeleton.jsp");
			//dispatcher.include(request, response);
			
			PrintWriter out = response.getWriter();
			Template.printHeader(out);
            out.println("<body>\n");
            ArrayList<Product> history = (ArrayList<Product>)request.getAttribute("viewHistory");
            
            // recently viewed

            if(!history.isEmpty())
            {
            	out.println("	<div id=\"recently-viewed-list\" class=\"row\">\n" + 
            			"		<h2>Recently Viewed</h2>\n" + 
            			"		<ul>");
            	
            	for (Product item : history)
            	{
    				out.println("        	<li id=\"recently-viewed-product\">\n" + 
    						"        		<div>\n" + 
    						"            		<a href=\"IndividualProductServlet?productID=" + item.getId() + "\"><img src=\"img/products/" + item.getDefaultImage() + "\" alt=\"productImage\" width=\"auto\" height=\"160\"></a>\n" + 
    						"                	<p>" + item.getName() + "</p>\n" + 
    						"                	<p>" + item.getBrand() + "</p>\n" + 
    						"                	<p>" + item.getPrice() + "</p> \n" + 
    						"        		</div>\n" + 
    						"        	</li>");
            	}
            	
            	out.println("		</ul>\n" + 
            			"	</div>");
            	
            }
            
            // splash
            out.println("		<div class=\"content\">\n" + 
            		"			<img class=\"splash\" src=\"img/pic.jpg\" width=\"700\" height=\"auto\" align=\"middle\"/>\n" + 
            		"		</div>");
            
            // for women
            Template.printBody(out, "	<div class=\"row\">\n" + 
            		"	<h2>New Releases for Women</h2>");
            
			RequestDispatcher homePageDispatcher = getServletContext().getRequestDispatcher("/HomePageProductsServlet");
			homePageDispatcher.include(request, response);
			ArrayList<Product> womenHomePageList = (ArrayList<Product>)request.getAttribute("productListHomeWomen");
			ArrayList<Product> menHomePageList = (ArrayList<Product>)request.getAttribute("productListHomeMen");
                        
			for(Product item : womenHomePageList)
			{
				out.println("        <div class=\"third text-center\">\n" + 
						"            <a href=\"IndividualProductServlet?productID=" + item.getId() + 
						"			 \"><img src=\"img/products/" + item.getDefaultImage() + "\" alt=\"productImage\" width=\"150\" height=\"auto\"></a>");
				out.println("                <p>" + item.getName() + "</p>\n" + 
						"                <p>" + item.getBrand() + "</p>\n" + 
						"                <p>" + item.getPrice() + "</p>");
				out.println("</div>");
			}
			
			out.println("</div>");
			
		// for men
            Template.printBody(out, "	<div class=\"row\">\n" + 
            		"	<h2>New Releases for Men</h2>");
            
			for(Product item : menHomePageList)
			{
				out.println("        <div class=\"third text-center\">\n" + 
						"            <a href=\"IndividualProductServlet?productID=" + item.getId() + 
						"			 \"><img src=\"img/products/" + item.getDefaultImage() + "\" alt=\"productImage\" width=\"150\" height=\"auto\"></a>");
				out.println("                <p>" + item.getName() + "</p>\n" + 
						"                <p>" + item.getBrand() + "</p>\n" + 
						"                <p>" + item.getPrice() + "</p>");
				out.println("</div>");
			}
    			
    		out.println("</div>");
    		
            out.println("</body");
            Template.printFooter(out);
			//String testString = (String)request.getAttribute("test123");
			//System.out.println(">>" + "HELLO");
			
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
