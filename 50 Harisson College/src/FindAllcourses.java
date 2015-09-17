

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hccourse;
import model.Hcuser;

/**
 * Servlet implementation class FindAllcourses
 */
@WebServlet("/FindAllcourses")
public class FindAllcourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String instr = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllcourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			instr = "";
			
			
			Utils<Hccourse> dbu = new Utils<Hccourse>();
			String q = "Select u from Hccourse u";
			List<Hccourse> course = null;
			course = dbu.getList(q);
			if(course != null)
			{
				for(Hccourse cur: course)
				{
			
						instr += instrJsp(cur);
				}
			}
			
			response.setContentType("text/html");
			request.setAttribute("instr", instr);
			getServletContext().getRequestDispatcher("/classbyinstructor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String instrJsp(Hccourse course)
	{
		String n = "";
		n = "<option value=" + course.getId() + ">" + course.getSubjectcode() + ""+course.getCoursenum() +" " + course.getName() + "</option>" ;
		return n;
		
	}

}
