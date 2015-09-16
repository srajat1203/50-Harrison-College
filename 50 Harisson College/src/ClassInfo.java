

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcclassroom;
import model.Hccourse;
import model.Hcmojor;
import model.Hcuser;

/**
 * Servlet implementation class ClassInfo
 */
@WebServlet("/ClassInfo")
public class ClassInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private String allCourse = "";
	private String allInstr = "";
	private String allClassroom = "";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String q = "select c from Hccourse c";
		Utils<Hccourse> dbc = new Utils<Hccourse>();
		List<Hccourse> courses = null;
		courses = dbc.getList(q);
		
		String p = "select u from Hcuser u where u.type = 2";
		Utils<Hcuser> dbu = new Utils<Hcuser>();
		List<Hcuser> users = null;
		users = dbu.getList(p);
		
		String m = "select r from Hcclassroom r";
		Utils<Hcclassroom> dbcl = new Utils<Hcclassroom>();
		List<Hcclassroom> classrooms = null;
		classrooms = dbcl.getList(m);
		
		
		if(courses != null)
		{
			
			allCourse =  "<select  name=\"course\">" + "<optgroup label=\"Majors\" >";
			
			for(Hccourse cur: courses)
			{	
				allCourse += courseJsp(cur);
				
			}	
			allCourse +=   "</optgroup>" +  
						 "</select>";
			
		}
		
		if(users != null)
		{
			allInstr =  "<select  name=\"instr\">" + "<optgroup label=\"Instructors\" >";
			
			for(Hcuser cur: users)
			{	
				allInstr += instrJsp(cur);
			}
			
			allInstr +=   "</optgroup>" +  
					 "</select>";
		}
		
		if(classrooms != null)
		{
			
			allClassroom =  "<select  name=\"classroom\">" + "<optgroup label=\"Classrooms\" >";
			
			for(Hcclassroom cur: classrooms)
			{	
				allClassroom += classroomJsp(cur);
			}
			
			allClassroom +=   "</optgroup>" +  
					 "</select>";
		}
		
		response.setContentType("text/html");
		request.setAttribute("allCourse", allCourse);
		request.setAttribute("allInstr", allInstr);
		request.setAttribute("allClassroom", allClassroom);
		getServletContext().getRequestDispatcher("/CreateClassDisp.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String courseJsp(Hccourse course)
	{
		String n = "<option value=" + course.getId() + ">" + course.getSubjectcode() + " " + course.getCoursenum() + "</option>" ;
		return n;
	}
	
	public String instrJsp(Hcuser user)
	{
		String n = "";
		n = "<option value=" + user.getUserid() + ">" + user.getName() + "</option>" ;
		return n;
		
	}
	
	public String classroomJsp(Hcclassroom classroom)
	{
		String n = "<option value=" + classroom.getId() + ">" + classroom.getBldgname() + " " + classroom.getRoom() + "</option>" ;
		return n;
	}
	
}
