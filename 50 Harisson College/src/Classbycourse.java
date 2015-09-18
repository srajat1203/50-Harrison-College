

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcuser;
import customTools.HcuserDB;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hccourse;
import customTools.HccourseDB;

/**
 * Servlet implementation class Roombyinstructor
 */
@WebServlet("/Classbycourse")
public class Classbycourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Classbycourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("classbycourse doget");
	
		
		
		int courseid = Integer.parseInt(request.getParameter("userid"));
		
		Hccourse hccourse=HccourseDB.getCourseByID(courseid);

		List<Hcclass>list= hccourse.getHcclasses();

		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/disclassbycourse.jsp").forward(request, response);
		
		

		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
	}

}
