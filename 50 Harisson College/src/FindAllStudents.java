

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcuser;

/**
 * Servlet implementation class FindAllStudents
 */
@WebServlet("/FindAllStudents")
public class FindAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String students = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		students = "";
		
		
		Utils<Hcuser> dbu = new Utils<Hcuser>();
		String q = "Select u from Hcuser u";
		List<Hcuser> users = null;
		users = dbu.getList(q);
		if(users != null)
		{
			for(Hcuser cur: users)
			{
				if(cur.getType() == 1)
				{
					students += studentJsp(cur);
				}
			}
		}
		
		response.setContentType("text/html");
		request.setAttribute("students", students);
		//request.setAttribute("allInstr", allCourse);
		//request.setAttribute("allClassroom", allCourse);
		getServletContext().getRequestDispatcher("/ViewStudentsDisp.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String studentJsp(Hcuser user)
	{
		String n = "";
		n = "<option value=" + user.getUserid() + ">" + user.getUserid() + " " + user.getName() + "</option>" ;
		return n;
		
	}

}
