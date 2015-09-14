

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hccourse;
import model.Hcdept;

/**
 * Servlet implementation class Courses
 */
@WebServlet("/Courses")
public class Courses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String num = "";
	private String code = "";
	private String desc = "";
	private String name = "";
	private String credits = "";
	private String dept = "";
	private String cname = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Courses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Utils<Hccourse> dbcourse = new Utils<Hccourse>(); 
		List<Hccourse> courses = null;
		String q = "Select c from Hccourse c";
		try
		{
			courses = dbcourse.getList(q);
			
			code="";
			num="";
			desc = "";
			name = "";
			credits = "";
			dept = "";
			cname = "";
			
			
			for(Hccourse cur: courses)
			{
				Hcdept curdept = cur.getHcdept();
				
				code += cur.getSubjectcode() + "<br><br>";
				num += cur.getCoursenum() + "<br><br>";
				desc += cur.getDescr() + "<br><br>";
				name += cur.getName() + "<br><br>";
				credits += cur.getCredits() + "<br><br>";
				dept += curdept.getName() + "<br><br>";
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println("no courses found");
		}
		
		
		
		
		response.setContentType("text/html");
		request.setAttribute("code", code);
		request.setAttribute("num", num);
		request.setAttribute("desc", desc);
		request.setAttribute("name", name);
		request.setAttribute("credits", credits);
		request.setAttribute("dept", dept);
		getServletContext().getRequestDispatcher("/CoursesDisp.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
