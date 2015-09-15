

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBUtil;
import model.*;

/**
 * Servlet implementation class CurrentSemesterClasses
 */
@WebServlet("/CurrentSemesterClasses")
public class CurrentSemesterClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String currentClasses="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentSemesterClasses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		currentClasses = "";
	HttpSession session = request.getSession();
		
		Hcuser user = (Hcuser) session.getAttribute("curuser");
		System.out.println(user.getName());
		
	
		String semester = "fall 2015";
		List<Hcclass> instrocturCurrentClasses = DBUtil.selectClassesByInstroctorForCurrentSemester(user, semester);
		if (instrocturCurrentClasses!= null && !instrocturCurrentClasses.isEmpty()) {
			currentClasses +="<table class=\"table\"><thead><tr><th width=\"30%\">Course</th><th width=\"30%\">Name</th><th width=\"30%\">Classroom</th><th width=\"10%\">Semester</th></tr></thead><tbody>";

			for (int i = 0; i < instrocturCurrentClasses.size(); i++) {
				currentClasses += "<tr><td>"
						+ instrocturCurrentClasses.get(i).getHccourse().getSubjectcode() +""+instrocturCurrentClasses.get(i).getHccourse().getCoursenum()
						+"</td>"
						+ "<td>"
						+  instrocturCurrentClasses.get(i).getHccourse().getName()
						+"</td>"
						+ "<td>"
						+ instrocturCurrentClasses.get(i).getHcclassroom().getBldgname() +" " + instrocturCurrentClasses.get(i).getHcclassroom().getRoom() +" "+instrocturCurrentClasses.get(i).getDaytime() 
						+"</td>"
						+ "<td>"
						+instrocturCurrentClasses.get(i).getSemester()
						+ "</td></tr>";
			}
			currentClasses+="</tbody></table>";
		}
		
		request.setAttribute("currentClasses", currentClasses);
		getServletContext().getRequestDispatcher("/CurrentSemesterClasses.jsp").forward(
				request, response);
	}

}
