

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcmoney;

/**
 * Servlet implementation class SetRevenue
 */
@WebServlet("/SetRevenue")
public class SetRevenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String message = "";
	private String err = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> invalid entry </div>";
	private String success = "<div class=\"alert alert-success\"> <strong>Success!</strong> new price/credit has been set </div>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetRevenue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sem = request.getParameter("sem");
		String temp_rate = request.getParameter("rate");
		if(temp_rate != null && sem != null)
		{
			if(!temp_rate.isEmpty() && !sem.isEmpty())
			{
				//System.out.println(sem + " " + temp_rate);
				double rate = Double.parseDouble(temp_rate);
				
				Utils<Hcmoney> dbm = new Utils<Hcmoney>();
				String q = "Select m from Hcmoney m where m.semester = '" + sem + "'";
				Hcmoney mon = null;
				mon = dbm.getResult(q);
				
				
				if(mon == null)
				{	
					mon = new Hcmoney();
					mon.setPrice(rate);
					mon.setSemester(sem);
					dbm.insert(mon);
				}
				else
				{
					mon.setPrice(rate);
					dbm.update(mon);
				}
				message = success;
			}
			else
			{
				message = err;
			}
		}

		else
		{
			message = err;
		}

		response.setContentType("text/html");
		request.setAttribute("message", message);
		//request.setAttribute("crn", crn);
		//request.setAttribute("course", course);
		//request.setAttribute("revenue", revenue);
		//request.setAttribute("allClassroom", allClassroom);
		getServletContext().getRequestDispatcher("/SetRevenueDisp.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
