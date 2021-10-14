package pack;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExitServlet
 */
@WebServlet("/ExitServlet")
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitServlet() {
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
		if (request.getParameter("exit") != null) {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<Double> bill = (List<Double>)session.getAttribute("Billing");
		      bill.clear();
		    @SuppressWarnings("unchecked")
			List<Integer> BookedCount =(  List<Integer>)session.getAttribute("BookedCount");
		    BookedCount.clear();
		    @SuppressWarnings("unchecked")
			List<String> BookedBus =(  List<String>)session.getAttribute("BookedBus");
		    BookedBus.clear();
		    @SuppressWarnings("unchecked")
			List<String> BookedType =(  List<String>)session.getAttribute("BookedType");
		    BookedType.clear();
 			getServletConfig().getServletContext().getRequestDispatcher("/Exit.jsp").forward(request,response);	       

	    } else if (request.getParameter("continue") != null) {
	    	getServletConfig().getServletContext().getRequestDispatcher("/Print.jsp").forward(request,response);
	}

}
}
