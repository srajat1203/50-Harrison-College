

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcmojor;

/**
 * Servlet implementation class Findallmajors
 */
@WebServlet("/Findallmajors")
public class Findallmajors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String allMajors = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Findallmajors() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String qString = "select u from Hcmojor u where u.enable = 1";
		Utils<Hcmojor> dbm = new Utils<Hcmojor>();
		List<Hcmojor> majors = new ArrayList<Hcmojor>();
		
		try
		{
			majors = dbm.getList(qString);
			
			allMajors =  "<select  name=\"major\">" + "<optgroup label=\"Majors\" >";
			
			for(Hcmojor cur: majors)
			{	
				 
				allMajors += getJSPMajor(cur);
						
						
			/*			
						"<optgroup label=\"User Type\" >" + 
				    "<option value=" + ">Student</option>" +
				    "<option value=\"2\">Instructor</option>" +
				    "<option value=\"3\">Advisor</option>" +
				    "<option value=\"4\">Administrator</option>" +
				  "</optgroup>" +  
				"</select>";
			*/	
			}	
			
			allMajors +=   "</optgroup>" +  
						 "</select>";
			
		}
		catch(Exception e)
		{
			System.out.println("no majors in list");
		}
		
		
		response.setContentType("text/html");
		request.setAttribute("Majors", allMajors);
		getServletContext().getRequestDispatcher("/CreateUser.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String getJSPMajor(Hcmojor major)
	{
		String n = "<option value=" + major.getId() + ">" + major.getName() + "</option>" ;
		return n;
	}

}
