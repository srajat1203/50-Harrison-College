

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
		System.out.println("xxx");
		String semster = request.getParameter("semester");
		System.out.println("the semester" +semster);
		HttpSession session = request.getSession();
		
		Hcuser user = (Hcuser) session.getAttribute("curuser");
		System.out.println(user.getName());

		List<Hcclass> instrocturCurrentClasses = DBUtil.selectClassesByInstroctorBySemester(user, semster);
		Roster += "<ul>";
		if (instrocturCurrentClasses!= null && !instrocturCurrentClasses.isEmpty()) {
			for (int i = 0; i < instrocturCurrentClasses.size(); i++) {
				Roster += "<li><a href=\"ListofStudent?classid="+instrocturCurrentClasses.get(i).getCrn()+"&semester="+instrocturCurrentClasses.get(i).getSemester()+"\">"
						+ instrocturCurrentClasses.get(i).getHccourse().getSubjectcode() +""+instrocturCurrentClasses.get(i).getHccourse().getCoursenum()
						+" "
						+  instrocturCurrentClasses.get(i).getHccourse().getName()
						+" "
						+ instrocturCurrentClasses.get(i).getHcclassroom().getBldgname() +" " + instrocturCurrentClasses.get(i).getHcclassroom().getRoom() +" "+instrocturCurrentClasses.get(i).getDaytime() 
						+" "
						+instrocturCurrentClasses.get(i).getSemester()
						+ "</a></li>";

			}
			
			
		}
		Roster += "</ul>";
		request.setAttribute("Roster", Roster);
		getServletContext().getRequestDispatcher("/RosterOfStudent.jsp").forward(
				request, response);
		
	}

}
