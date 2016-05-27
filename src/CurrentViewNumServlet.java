

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CurrentViewNumServlet
 */
@WebServlet("/CurrentViewNumServlet")
public class CurrentViewNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentViewNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(Cookie cookie : cookies){
			    if (cookie.getName().equals("JSESSIONID")) {
			    	sessionID = cookie.getValue();
			    }
			}
		}
		
		Date currentDate = new Date();
		System.out.println("date: "+ currentDate.toString());
		
		System.out.println("sessionID " + sessionID);
		
		//HashMap<String, HashMap<String,ArrayList<Date>>> lastAccessMap = new HashMap<String, HashMap<String,ArrayList<Date>>>();
//		if (context.getAttribute("currentViewNum") == null) {
//            context.setAttribute("currentViewNum", new CurrentViewNum());
//        }
		if (context.getAttribute("statusMap") == null) {
            context.setAttribute("statusMap", new HashMap<String, LastAccessMap>());
        }
        String productID = request.getParameter("productID");
		HashMap<String, LastAccessMap> statusMap = (HashMap<String, LastAccessMap>)context.getAttribute("statusMap");
		
		LastAccessMap latestAccessTime = statusMap.get(productID);
		
		if (latestAccessTime == null) {
			statusMap.put(productID, new LastAccessMap());
		} 
		
		statusMap.get(productID).addAccessTime(sessionID, currentDate);
		statusMap.get(productID).checkTimes(currentDate);
		
		
		
		//Date[] dateArray = (Date[])lastAccessMap.values().toArray();
		
		//for(Map.Entry)
		
//		for(int i = 0; i < dateArray.length; i++){
//			Date dateToTest = dateArray[i];
//			int differenceValue = currentDate.compareTo(dateToTest);
//			System.out.println("difference: " + String.valueOf(differenceValue));
//		}
		
		//CurrentViewNum ViewNum = (CurrentViewNum)context.getAttribute("currentViewNum");

        //ViewNum.increaseCount(productID);
        //Integer currentCount = ViewNum.getCurrentCount(productID);
        
        //session.setMaxInactiveInterval(20*60);
//        System.out.println("printing " + currentCount.toString());
//        request.setAttribute("ViewNum", currentCount);
        
        //HttpSession session = request.getSession();
		//session.setAttribute("user", e);
		//session.setMaxInactiveInterval(30*60);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
