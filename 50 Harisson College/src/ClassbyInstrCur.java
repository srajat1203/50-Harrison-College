

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcenrolledclass;

/**
 * Servlet implementation class ClassbyInstrCur
 */
@WebServlet("/ClassbyInstrCur")
public class ClassbyInstrCur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassbyInstrCur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crn = "";
		String sub = "";
		String daytime = "";
		String sem = "";
		String place = "";
		
		String temp_userid = request.getParameter("instr");
		long userid = Long.parseLong(temp_userid);
		
		String p = "select c from Hcclass c";;
		Utils<Hcclass> dbc = new Utils<Hcclass>();
		List<Hcclass> clist = null;
		clist = dbc.getList(p);
		
		if(clist != null)
		{
			for(Hcclass cur: clist)
			{
				if(cur.getEnable() == 1)
				{	
					crn += cur.getCrn() + "<br><br>";
					sub += cur.getHccourse().getName() + "<br><br>";
					daytime += cur.getDaytime() + "<br><br>";
					sem += cur.getSemester() + "<br><br>";
					place += cur.getHcclassroom().getBldgname() + " " + cur.getHcclassroom().getRoom() + "<br><br>";
				}	
			}
		}
		
		
		response.setContentType("text/html");
		request.setAttribute("crn", crn);
		request.setAttribute("sub", sub);
		request.setAttribute("daytime", daytime);
		request.setAttribute("sem", sem);
		request.setAttribute("place", place);
		getServletContext().getRequestDispatcher("/FindAllInstr?author=rajat")
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
