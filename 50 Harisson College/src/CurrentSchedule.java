

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import customTools.DBUtil;

/**
 * Servlet implementation class CurrentSchedule
 */
@WebServlet("/CurrentSchedule")
public class CurrentSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String schedule="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentSchedule() {
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
		schedule ="";
		HttpSession session = request.getSession();
		Hcuser user = (Hcuser) session.getAttribute("curuser");
		List<Hcclass> myschedule = DBUtil.getStudentSchedule(user);
		
		if (myschedule != null && !myschedule.isEmpty()) {
			schedule += " <table class=\"table\"> <thead>  <tr>  <th>Course</th>  <th>Day/ Time</th>   <th>Location</th>  <th>Instroctour</th></tr>   </thead>  <tbody>";
			
			for (int i = 0; i < myschedule.size(); i++) {
			
				schedule += "<tr><td>"+myschedule.get(i).getHccourse().getSubjectcode()+""+myschedule.get(i).getHccourse().getCoursenum()+" "+myschedule.get(i).getHccourse().getName()+"</td><td>"
						+myschedule.get(i).getDaytime() +"</td><td>"
						+myschedule.get(i).getHcclassroom().getBldgname()  +" Room #: "+myschedule.get(i).getHcclassroom().getRoom() +"</td><td>"
						+myschedule.get(i).getHcuser().getName()  +"</td>"
						+"</tr>";
			}
			schedule += "</tbody></table>";
			
			}
		else
		{
			schedule +="<div class=\"alert alert-warning\"> <strong>Your not enrolled in any class!</strong></div>";
		}
		request.setAttribute("currentClasses",schedule);
		getServletContext().getRequestDispatcher("/CurrentSemesterClasses.jsp")
		.forward(request, response);
		
	}

}
