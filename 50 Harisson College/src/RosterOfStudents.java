

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcclass;
import model.Hcuser;
import customTools.DBUtil;

/**
 * Servlet implementation class RosterOfStudents
 */
@WebServlet("/RosterOfStudents")
public class RosterOfStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String Roster=""; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RosterOfStudents() {
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
		Roster="";
	
		String semster = request.getParameter("semester");

		HttpSession session = request.getSession();
		
		Hcuser user = (Hcuser) session.getAttribute("curuser");
			System.out.println(user.getName());
			List<Hcclass> instrocturCurrentClasses = null; 
			if(request.getParameter("semester") != null && request.getParameter("semester") != "")
			{
			instrocturCurrentClasses = DBUtil.selectClassesByInstroctorBySemester(user,semster);
			}
			else
			{
				instrocturCurrentClasses = DBUtil.selectClassesByInstroctorBySemester(user);
				request.setAttribute("ishidden","hidden");
			}
		Roster +="<table class=\"table\"><thead><tr><th width=\"30%\">CRN (Rosters of Students)</th><th width=\"30%\">Course</th><th width=\"30%\">Location</th><th width=\"10%\">Semester</th></tr></thead><tbody>";

		if (instrocturCurrentClasses!= null && !instrocturCurrentClasses.isEmpty()) {
			for (int i = 0; i < instrocturCurrentClasses.size(); i++) {
				Roster += "<tr><td><a href=\"ListofStudent?classid="+instrocturCurrentClasses.get(i).getCrn()+"&semester="+instrocturCurrentClasses.get(i).getSemester()+"\">"
						+ instrocturCurrentClasses.get(i).getCrn() 
						+" </a></td>"
						+ "<td>"
						+instrocturCurrentClasses.get(i).getHccourse().getSubjectcode() +""+instrocturCurrentClasses.get(i).getHccourse().getCoursenum()
						+ " "
						+  instrocturCurrentClasses.get(i).getHccourse().getName()
						+"</td>"
						+ "<td>"
						+ instrocturCurrentClasses.get(i).getHcclassroom().getBldgname() +" " + instrocturCurrentClasses.get(i).getHcclassroom().getRoom() +"   "+instrocturCurrentClasses.get(i).getDaytime() 
						+"</td>"
						+ "<td>"
						+instrocturCurrentClasses.get(i).getSemester()
						+ "</td>";

			}
			
			
		}
		Roster +="</tbody></table>";
		request.setAttribute("Roster", Roster);
		getServletContext().getRequestDispatcher("/RosterOfStudent.jsp").forward(
				request, response);
		
	}

}
