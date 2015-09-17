

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcenrolledclass;
import model.Hcuser;

/**
 * Servlet implementation class ViewStudents
 */
@WebServlet("/ViewStudents")
public class ViewStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crn = "";
		String time = "";
		String inst = "";
		String building = "";
		String room = "";
		
		String temp_userid = request.getParameter("student");
		long userid = Long.parseLong(temp_userid);
		
		//String q = "Select u from hcuser u where u.userid = " + userid;
		//Utils<Hcuser> dbu = new Utils<Hcuser>();
		//Hcuser user = dbu.getResult(q); 
		
		String p = "select p from Hcenrolledclass p";
		Utils<Hcenrolledclass> dbe = new Utils<Hcenrolledclass>();
		List<Hcenrolledclass> elist = null;
		elist = dbe.getList(p);
		
		if(elist != null)
		{
			for(Hcenrolledclass cur: elist)
			{
			
				if(cur.getHcuser().getUserid() == userid)
				{	
					crn += cur.getHcclass().getCrn() + "<br><br>";
					time += cur.getHcclass().getDaytime() + "<br><br>";
					inst += cur.getHcclass().getHcuser().getName() + "<br><br>";
					building += cur.getHcclass().getHcclassroom().getBldgname() + "<br><br>";
					room += cur.getHcclass().getHcclassroom().getRoom() + "<br><br>";
				}	
			}
		}
		
		
		response.setContentType("text/html");
		request.setAttribute("crn", crn);
		request.setAttribute("daytime", time);
		request.setAttribute("inst", inst);
		request.setAttribute("building", building);
		request.setAttribute("room", room);
		getServletContext().getRequestDispatcher("/FindAllStudents")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	

	

}
