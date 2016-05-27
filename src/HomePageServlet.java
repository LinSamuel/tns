/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
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
 *
 * @author Kevin
 */
@WebServlet(urlPatterns = {"/"})
public class HomePageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Template.printHeader(out);
            out.println("<body>\n");
            
            RequestDispatcher recentlyViewedDispatcher = getServletContext().getRequestDispatcher("/VisitHistoryServlet");
            recentlyViewedDispatcher.include(request, response);
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
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
