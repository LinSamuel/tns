

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tns.*;
/**
 * Servlet implementation class VisitHistoryServlet
 */
@WebServlet("/VisitHistoryServlet")
public class VisitHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * The purpose of this servlet's doGet method is to keep track of the view history
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        if (session.getAttribute("visitHistory") == null) {
            session.setAttribute("visitHistory", new VisitHistory());
        }
        VisitHistory viewHistory = (VisitHistory)session.getAttribute("visitHistory");
        //String productIDtoAdd = request.getParameter("productID");
        Product productToAdd = (Product)request.getAttribute("theProduct");
        if(productToAdd != null){
        	//System.out.println(productIDtoAdd);
            viewHistory.addVisitedProduct(productToAdd);
        }
        ArrayList<Product> viewProductHistory;
			//viewProductHistory = ProductFactory.getProductView(viewHistory.getVisitHistory());
        
        //This long line of code sets an attribute to the request called 'viewHistory', with a value of an arraylist of Product objects
        request.setAttribute("viewHistory", new ArrayList<Product>(viewHistory.getVisitHistory().values()));

        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
