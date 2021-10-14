package pack;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FindBusServlet
 */
@WebServlet("/FindBusServlet")
public class FindBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String>  buses = new ArrayList<>();
	List<String>  buses1 = new ArrayList<>();
	List<Bus>  validatedBuses = new ArrayList<>();
	
	
     BusHelper bushelp = new BusHelper();
	 BusDetails bd = new BusDetails();
	 BusBook bb = new BusBook();
	 BusDetails bus = new BusDetails();
	 List<Bus> busDetails;
	 Map<String, List<String>> BusesAndRoutes ;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public FindBusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
     public void init()
     {
    	  busDetails=bd.createBusDetails();
    	 BusesAndRoutes = bus.createBusRouteDetails();
    
    	 
     }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		 
		 // Creating map of buses available at
		
		
         if(!buses.isEmpty())
         {
        	 buses.clear();
         }
         String source= request.getParameter("source");
         String destination= request.getParameter("destination");
       
         if(source.equals(destination))
         {
	    
        	 response.sendRedirect("FailureSandD.jsp");
         }
         else
         {
        	 bushelp.findBus(source, destination, BusesAndRoutes);
             buses = bushelp.getBuses();
             HttpSession session=request.getSession();
             session.setAttribute("buses", buses);
             session.setAttribute("busDetails", busDetails);
              if(buses.isEmpty())
              {   
            	  response.sendRedirect("FailureEmpty.jsp");
            	  
              }
              else
              {
            	 
        	request.setAttribute("busesfound", buses);
        	getServletConfig().getServletContext().getRequestDispatcher("/BusesFound.jsp").forward(request,response);
//            RequestDispatcher rd = request.getRequestDispatcher("BusesFound.jsp");
//            rd.forward(request, response);
         }}
	}
        
	}
	


