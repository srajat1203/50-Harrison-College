

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
 * Servlet implementation class GradeSheets
 */
@WebServlet("/GradeSheets")
public class GradeSheets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String sheet="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeSheets() {
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
		sheet="";
		
		String semster = request.getParameter("semester");

	//Hcclass classCRN = DBUtil.selectclass(Long.parseLong(semster));
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
		if (instrocturCurrentClasses!= null && !instrocturCurrentClasses.isEmpty()) 
		{
			sheet += " <table class=\"table\"> <thead>  <tr>  <th>Course</th>   <th>Student ID</th>  <th>Student Name</th>    <th>Grade</th> </tr>   </thead>  <tbody>";

			for (int i = 0; i < instrocturCurrentClasses.size(); i++) {
				List<Hcenrolledclass> gradesheet = DBUtil.rosterOfStudent(instrocturCurrentClasses.get(i));
				long crn =0;
				if (gradesheet!= null && !gradesheet.isEmpty()) {
					for (int j = 0; j < gradesheet.size(); j++) {
						if(crn != gradesheet.get(i).getHcclass().getCrn())
						{
							crn= gradesheet.get(i).getHcclass().getCrn();
							sheet +="<tr><th colspan=\"4\" align=\"center\"> Class CRN: "+crn+"</th></tr>";
						}
						sheet += "<tr><td> "
								+gradesheet.get(j).getHcclass().getHccourse().getSubjectcode()+gradesheet.get(j).getHcclass().getHccourse().getCoursenum()
								+ "  " 
								+gradesheet.get(j).getHcclass().getHccourse().getName()
								+"</td><td> " 
								+gradesheet.get(j).getHcuser().getUserid()
								+ "</td><td> " 
								+ gradesheet.get(j).getHcuser().getName()
								+ "</td><td> "
								+ gradesheet.get(j).getGrade() 
								+  "</td></tr>";
							}
				}
			}
		}
			sheet += "</tbody></table>";
		
		request.setAttribute("sheet", sheet);
		getServletContext().getRequestDispatcher("/GradeSheets.jsp").forward(
				request, response);
		
	}

}
