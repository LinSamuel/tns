

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
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/indexSkeleton.jsp");
			dispatcher.include(request, response);
			
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
