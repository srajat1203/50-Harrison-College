package Servlet;
 

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HccourseDB;
import dao.HcdeptDB;
import dao.HcuserDB;
import model.Hccourse;
import model.Hcdept;
import model.Hcuser;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/CreateCourseServlet")
public class CreateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("coursename");
		int coursenum = Integer.parseInt(request.getParameter("coursenumber"));
		String subjectcode = request.getParameter("subjectcode");
		String descr = request.getParameter("description");
		double credits = Double.parseDouble(request.getParameter("credits"));
		int deptID = Integer.parseInt(request.getParameter("dept"));
		
		Hccourse course = new Hccourse();
		course.setCoursenum(coursenum);
		course.setCredits(credits);
		course.setDescr(descr);
		course.setEnable(1);
		Hcdept dept = HcdeptDB.getDeptByID(deptID);
		course.setHcdept(dept);
		course.setName(name);
		course.setSubjectcode(subjectcode);
		
		HccourseDB.insert(course);
		
		List<Hccourse> courses = HccourseDB.getAllCourses();
		request.setAttribute("courses", courses); 
		getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
