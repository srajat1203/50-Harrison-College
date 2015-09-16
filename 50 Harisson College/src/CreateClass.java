

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcuser;

/**
 * Servlet implementation class CreateClass
 */
@WebServlet("/CreateClass")
public class CreateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String message = "";
    private String err = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> Conflicts with an existing class </div>";
    private String success = "<div class=\"alert alert-success\"> <strong>Success!</strong> New class added </div>";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String temp_course = request.getParameter("course");
		String temp_instr = request.getParameter("instr");
		String temp_classroom = request.getParameter("classroom");
		String temp_enable = request.getParameter("enable");
		
		long course = Long.parseLong(temp_course);
		long instr = Long.parseLong(temp_instr);
		long classroom = Long.parseLong(temp_classroom);
		String sem = request.getParameter("sem");
		String daytime = request.getParameter("daytime");
		int enable = Integer.parseInt(temp_enable);
		
		//System.out.println(course + " " + instr + " " + classroom + " " + sem + " " + daytime + " " + enable);
		
		Utils<Hcuser> dbu = new Utils<Hcuser>();
		
		
		
		//response.setContentType("text/html");
		//request.setAttribute("allCourse", allCourse);
		//request.setAttribute("allInstr", allCourse);
		//request.setAttribute("allClassroom", allCourse);
		//getServletContext().getRequestDispatcher("/ClassInfo")
		//.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
