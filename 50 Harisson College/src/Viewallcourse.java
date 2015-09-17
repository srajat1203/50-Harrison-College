

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hccourse;
import customTools.HccourseDB;

/**
 * Servlet implementation class Viewallcourse
 */
@WebServlet("/Viewallcourse")
public class Viewallcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewallcourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       System.out.println("doget viewallcourses");
	       
		List<Hccourse> list=HccourseDB.getAllCourses();
		for (Hccourse course : list)
		{
			
			System.out.println(course.getName());
		}   
	       
		
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/viewallcourse.jsp").forward(request, response);
		
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
		// TODO Auto-generated method stub
	}

}
