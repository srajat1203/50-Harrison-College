
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.DBUtil;
import model.Hcclass;
import model.Hcenrolledclass;

/**
 * Servlet implementation class ListofStudent
 */
@WebServlet("/ListofStudent")
public class ListofStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String Roster = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListofStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Roster = "";
		if(request.getParameter("classid")!= null)
		{
		long classid = Long.parseLong(request.getParameter("classid"));
		String semester = request.getParameter("semester");
		System.out.println("in list of studint " + classid);
		System.out.println("in list of studint semester " + semester);
		Hcclass classObj = DBUtil.selectclass(classid);

		System.out.println("after classObj " + classObj.getSemester());
		List<Hcenrolledclass> studentlist = DBUtil.rosterOfStudent(classObj,
				semester);
		System.out.println("after studentlist ");

		if (studentlist != null && !studentlist.isEmpty()) {
			Roster += " <table class=\"table\"> <thead>  <tr>     <th>Student</th>     <th>Grad</th>   <th>Semester</th>    <th></th> </tr>   </thead>  <tbody>";
			for (int i = 0; i < studentlist.size(); i++) {
				Roster += "<tr><form role=\"for\" action=\"UpdateStudentGrad?entollmentid="
						+ studentlist.get(i).getId() +"\" method=\"post\">"
						+ "<td> "
						+ studentlist.get(i).getHcuser().getUserid()
						+ "  "
						+ studentlist.get(i).getHcuser().getName()
						+ "</td><td> "
						+ "<div class=\"col-sm-10\"><input type=\"text\" class=\"form-control\" name=\"grade\" id=\"grade\"	placeholder=\""
						+ studentlist.get(i).getGrade() + "\">"
						+ "</input></div>" +   "</td><td> "
						+ studentlist.get(i).getSemester() + "</td><td> "
						+"<button type=\"submit\" class=\"btn btn-default\" name=\"update\" id=\"update\">Assign Grade</button>"
						+ "</td></form></tr>";
				System.out.println(studentlist.get(i).getId());

			}

			Roster += "</tbody></table>";
		}
		else
		{
			Roster += "<div class=\"alert alert-warning\">  <strong>No Students enrolled in this class!</strong></div>";
		}
		}
		request.setAttribute("currentClasses", Roster);
		getServletContext().getRequestDispatcher("/CurrentSemesterClasses.jsp")
				.forward(request, response);
	}

}
