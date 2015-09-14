

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;

/**
 * Servlet implementation class ClassesbySem
 */
@WebServlet("/ClassesbySem")
public class ClassesbySem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String table = "";
    private String tpresent = "<div class=\"container\">" +
    "<h2>Courses</h2>" +             
    "<table class=\"table\">" + 
      "<thead>" +
        "<tr>" + 
          "<th>Course code</th>" +
          "<th>Course number</th>" + 
          "<th>Description</th>" + 
          "<th>Name</th>" + 
          "<th>Credits</th>" + 
          "<th>Department</th>" + 
        "</tr>" +
      "</thead>" + 
      "<tbody>";

    
    private String crn = "";
    private String time = "";
    private String inst = "";
    private String building = "";
    private String room = "";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesbySem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String search = request.getParameter("search");
		//System.out.println(search);
	
		if(search != null)
		{
			if(!search.isEmpty())
			{
				String q = "Select c from Hcclass c where c.semester = '" + search +  "'";
				Utils<Hcclass> dbc = new Utils<Hcclass>();
				List<Hcclass> clist = null;
				try
				{
					//System.out.println("here");
					clist = dbc.getList(q);
					//System.out.println("here2");
					crn = "";
				    time = "";
				    inst = "";
				    building = "";
				    room = "";
					for(Hcclass cur: clist)
					{
						
						
						crn += cur.getCrn() + "<br><br>";
						time += cur.getDaytime() + "<br><br>";
						inst += cur.getHcuser().getName() + "<br><br>";
						building += cur.getHcclassroom().getBldgname() + "<br><br>";
						room += cur.getHcclassroom().getRoom() + "<br><br>";
					}
					
					table = tpresent;
				}
				catch(Exception e)
				{
					System.out.println("no list in class by semester");
					table = "";
				}
			}
		}
		
		
		
		
		response.setContentType("text/html");
		
		request.setAttribute("crn", crn);
		request.setAttribute("time", time);
		request.setAttribute("inst", inst);
		request.setAttribute("building", building);
		request.setAttribute("room", room);
		request.setAttribute("table", table);
		getServletContext().getRequestDispatcher("/ClassesbySemDisp.jsp")
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
