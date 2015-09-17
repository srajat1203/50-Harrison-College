

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;

/**
 * Servlet implementation class RemoveClass
 */
@WebServlet("/RemoveClass")
public class RemoveClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String message = "";
	 private String err = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> No such CRN exists </div>";
	 private String success = "<div class=\"alert alert-success\"> <strong>Success!</strong> Class has been removed </div>";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String temp_crn = request.getParameter("crn");
		long crn = 0;
		Hcclass rclass = null;
		Utils<Hcclass> dbc = new Utils<Hcclass>();
		if(temp_crn != null)
		{
			if(!temp_crn.isEmpty())
			{
				crn = Long.parseLong(temp_crn);
				String q = "Select c from Hcclass c where c.crn = " + crn;
				rclass = dbc.getResult(q);
			}
		}
		
		if(rclass != null)
		{
			dbc.delete(rclass);
			message = success;
		}
		else
		{
			message = err;
		}
		response.setContentType("text/html");
		request.setAttribute("message", message);
		//request.setAttribute("allInstr", allCourse);
		//request.setAttribute("allClassroom", allCourse);
		getServletContext().getRequestDispatcher("/RemoveClassDisp.jsp")
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
