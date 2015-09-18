

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class RevenueInstr
 */
@WebServlet("/RevenueInstr")
public class RevenueInstr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String heading = "Revenue by Instructor";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueInstr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sem = request.getParameter("sem");
		
		Utils<Hcmoney> dbm = new Utils<Hcmoney>();
		String a = "Select m from Hcmoney m where m.semester = '" + sem + "'";
		Hcmoney mon = null;
		mon = dbm.getResult(a);
		double rate = 500;
		if(mon != null)
		{
			rate = mon.getPrice();
		}
		
		
		String instr = "";
		double credits = 0.0;
		double total = 0.0;
		
		
		if(sem != null)
		{
			if(!sem.isEmpty())
			{
				Utils<Hcuser> dbu = new Utils<Hcuser>();
				String m = "Select u from Hcuser u where u.type = 2";
				List<Hcuser> ulist = null;
				ulist = dbu.getList(m);
				
				if(ulist != null)
				{
					if(!ulist.isEmpty())
					{
						for( Hcuser cur: ulist)
						{	
							instr += cur.getName();
							
							Utils<Hcenrolledclass> dbe = new Utils<Hcenrolledclass>();
							String q = "Select e from Hcenrolledclass e";
							List<Hcenrolledclass> elist = null;
							elist = dbe.getList(q);
							
							if(elist != null)
							{
								if(!elist.isEmpty())
								{
									credits = 0.0;
									total = 0.0;
									for(Hcenrolledclass e: elist)
									{
										if(e.getHcclass().getHcuser().getUserid() == cur.getUserid() && e.getHcclass().getSemester().equalsIgnoreCase(sem))
										{
											credits += e.getHcclass().getHccourse().getCredits();
										}
									}
									total = rate*credits;
									instr += "   " + total + "<br><br>";
								}
							}
						}	
					}
				}
					

			}
		}
		
				
		response.setContentType("text/html");
		request.setAttribute("heading", heading);
		request.setAttribute("instr", instr);
		//request.setAttribute("allClassroom", allClassroom);
		getServletContext().getRequestDispatcher("/RevenueInstrDisp.jsp")
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
