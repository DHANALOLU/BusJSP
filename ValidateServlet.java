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
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	List<Double> Billing = new ArrayList<>();
	List<String> BookedBus = new ArrayList<>();
	List<String> BookedType = new ArrayList<>();
	List<Integer> BookedCount = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String busname = request.getParameter("busname");
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<Bus> validatedBuses=(List<Bus>) session.getAttribute("validatedBuses");
		List<String> checkBusName = new ArrayList<>();
		for(Bus b :validatedBuses)
		{
			checkBusName.add(b.getbusName());
		}
		if(checkBusName.contains(busname))
		{
		@SuppressWarnings("unchecked")
		List<Bus> busDetails =(List<Bus>) session.getAttribute("busDetails");
	    int count =(int)session.getAttribute("count");
	    String type =(String)session.getAttribute("type");
	    BookedBus.add(busname);
	    BookedCount.add(Integer.valueOf(count));
	    BookedType.add(type);
	    if(type.equals("SL"))
	    {
	    	IBill bill = new Sleeper(); // If Ticket type is Sleeper
			double billing = bill.printBill(busname, busDetails, count);
		    System.out.println(billing);
		  
			Billing.add(Double.valueOf(billing));
			
	    }
	    else if(type.equals("ST")) {
			IBill bill = new Seater(); // If Ticket type is Seater
			double billing = bill.printBill(busname, busDetails, count);
			
			  Billing.add(Double.valueOf(billing));
	    }
	    for(Bus b:busDetails)
	    {
	    	System.out.println(b.getsleeperTickets());
	    }
	    session.setAttribute("Billing", Billing);
	    session.setAttribute("BookedBus", BookedBus);
	    session.setAttribute("BookedCount", BookedCount);
	    session.setAttribute("BookedType", BookedType);
	    request.setAttribute("Billing", Billing);
	    request.setAttribute("BookedCount", BookedCount);   
	    request.setAttribute("BookedBus", BookedBus);
	    request.setAttribute("BookedType", BookedType);
	 
	    
	    getServletConfig().getServletContext().getRequestDispatcher("/Billing.jsp").forward(request,response);
		}
		else
		{
			response.sendRedirect("BusNotAvailable.jsp");
		}
		}
	    
	    
		
	}


