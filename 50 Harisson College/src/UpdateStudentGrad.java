

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcenrolledclass;
import customTools.DBUtil;

/**
 * Servlet implementation class UpdateStudentGrad
 */
@WebServlet("/UpdateStudentGrad")
public class UpdateStudentGrad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String alert=""; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentGrad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		alert = "";
		if(request.getParameter("entollmentid")!= null && request.getParameter("grade")!= null)
		{
		long enrollmentid = Long.parseLong(request.getParameter("entollmentid"));
		double grade = Double.parseDouble(request.getParameter("grade"));
		System.out.println("the enrollmentid is " + enrollmentid);
		System.out.println("the grade is " + grade);
		
		
		Hcenrolledclass enrolledclass = DBUtil.selectenrollment(enrollmentid);
		enrolledclass.setGrade(grade);
		DBUtil.updateGrad(enrolledclass);
		System.out.println(enrolledclass.getSemester());
		alert = "<div class=\"alert alert-success\"> <strong>Success!</strong> Grade was assign.</div>";
		}
		else
		{
			alert = "<div class=\"alert alert-danger\"> <strong>Something went wrong!</strong> counld not assign the grad.</div>";
		}
		request.setAttribute("currentClasses",alert);
		getServletContext().getRequestDispatcher("/RosterOfStudent.jsp")
		.forward(request, response);
	}
	

}
