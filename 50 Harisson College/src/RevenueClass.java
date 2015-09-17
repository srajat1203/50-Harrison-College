

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcdept;
import model.Hcenrolledclass;
import model.Hcmoney;

/**
 * Servlet implementation class RevenueClass
 */
@WebServlet("/RevenueClass")
public class RevenueClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String heading = "Revenue by Class";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String crn = "";
		String course = "";
		String revenue = "";
		
		
		
		String classes = "";
		double credits = 0.0;
		double total = 0.0;
		
		
		
				Utils<Hcclass> dbc = new Utils<Hcclass>();
				String m = "Select c from Hcclass c";
				List<Hcclass> clist = null;
				clist = dbc.getList(m);
				
				if(clist != null)
				{
					if(!clist.isEmpty())
					{
						for( Hcclass cur: clist)
						{	
							classes += cur.getCrn() + " " + cur.getHccourse().getSubjectcode() + " " + cur.getHccourse().getCoursenum();
							
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
										
										if(e.getHcclass().getCrn() == cur.getCrn() )
										{
											//System.out.println("here is " + e.getHcclass().getCrn());
											credits += e.getHcclass().getHccourse().getCredits();
										}
									}
									double rate = getRate(cur.getSemester());
									total = rate*credits;
									crn += cur.getCrn() + "<br><br>";
									course += cur.getHccourse().getSubjectcode() + " " + cur.getHccourse().getCoursenum() + "<br><br>";
									revenue += total + "<br><br>";
									//System.out.println(rate + " " + credits + " " + total);
								}
							}
						}	
					}
				}
					

		
		
		
		response.setContentType("text/html");
		request.setAttribute("heading", heading);
		request.setAttribute("crn", crn);
		request.setAttribute("course", course);
		request.setAttribute("revenue", revenue);
		//request.setAttribute("allClassroom", allClassroom);
		getServletContext().getRequestDispatcher("/RevenueClassDisp.jsp")
		.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public double getRate(String sem)
	{

		Utils<Hcmoney> dbm = new Utils<Hcmoney>();
		String a = "Select m from Hcmoney m where m.semester = '" + sem + "'";
		Hcmoney mon = null;
		mon = dbm.getResult(a);
		double rate = 500;
		if(mon != null)
		{
			rate = mon.getPrice();
		}
		return rate;
	}

}
