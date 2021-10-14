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
 * Servlet implementation class ValidateBusServlet
 */
@WebServlet("/ValidateBusServlet")
public class ValidateBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Bus>  validatedBuses = new ArrayList<>();
	BusBook bb = new BusBook();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateBusServlet() {
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
		if(!validatedBuses.isEmpty())
		{
			validatedBuses.clear();
		}

	   int count =Integer.parseInt(request.getParameter("count"));
	   String type = request.getParameter("type");
	   
        HttpSession session=request.getSession();
      @SuppressWarnings("unchecked")
	List<String> buses=(List<String> )session.getAttribute("buses");
      System.out.println(buses.isEmpty());
      @SuppressWarnings("unchecked")
	List<Bus> busDetails = (List<Bus>)session.getAttribute("busDetails");
      
       session.setAttribute("busDetails", busDetails);
       session.setAttribute("count", count);
       session.setAttribute("type", type);
       
		  validatedBuses= bb.validateBusBasedOnTicket(buses, busDetails, type, count);
		  
		session.setAttribute("validatedBuses", validatedBuses);
		if(validatedBuses.isEmpty())
		{
			 response.sendRedirect("FailureValidation.jsp");
		}
		else
		{ 
			
			request.setAttribute("validatedbuses", validatedBuses );
			getServletConfig().getServletContext().getRequestDispatcher("/PrintValidatedBuses.jsp").forward(request,response);
		}
		
	}
	}
