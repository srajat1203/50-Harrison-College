

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    "<h2>Classes</h2>" +             
    "<table class=\"table\">" + 
      "<thead>" +
        "<tr>" + 
          "<th>CRN</th>" +
          "<th>Day/Time</th>" + 
          "<th>Instructor</th>" + 
          "<th>Building</th>" + 
          "<th>Room number</th>" + 
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
		
		String sem = request.getParameter("sem");
		String sub = request.getParameter("subject");
		String instr = request.getParameter("instr");
		String curTime = request.getParameter("time");
		//System.out.println(search);
	
		if(sem != null)
		{
			if(!sem.isEmpty())
			{
				String q = "Select c from Hcclass c where c.semester = '" + sem +  "' and c.enable = 1";
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
		
		//Search by semester and subject
		
		if(sem !=null && sub!=null)
		{
			if(!sem.isEmpty() && !sub.isEmpty())
			{
				//System.out.println("here");
				String q = "Select c from Hcclass c where c.semester = '" + sem +  "' and c.enable = 1";
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
						if(cur.getHccourse().getSubjectcode().equalsIgnoreCase(sub))
						{
							crn += cur.getCrn() + "<br><br>";
							time += cur.getDaytime() + "<br><br>";
							inst += cur.getHcuser().getName() + "<br><br>";
							building += cur.getHcclassroom().getBldgname() + "<br><br>";
							room += cur.getHcclassroom().getRoom() + "<br><br>";
						}	
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
		
		
		//Search by semester and instructor
		
		if(sem !=null && instr!=null)
		{
			if(!sem.isEmpty() && !instr.isEmpty())
			{
				
				String q = "Select c from Hcclass c where c.semester = '" + sem +  "' and c.enable = 1";
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
						if(cur.getHcuser().getName().equalsIgnoreCase(instr))
						{
							crn += cur.getCrn() + "<br><br>";
							time += cur.getDaytime() + "<br><br>";
							inst += cur.getHcuser().getName() + "<br><br>";
							building += cur.getHcclassroom().getBldgname() + "<br><br>";
							room += cur.getHcclassroom().getRoom() + "<br><br>";
						}	
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
		
		
		
		
		//search by time
		
		if(curTime != null)
		{
			if(!curTime.isEmpty())
			{
				String q = "Select c from Hcclass c where c.enable = 1";
				Utils<Hcclass> dbc = new Utils<Hcclass>();
				List<Hcclass> clist = null;
				clist = dbc.getList(q);
				
				if(clist != null)
				{	
					crn = "";
				    time = "";
				    inst = "";
				    building = "";
				    room = "";
					for(Hcclass cur: clist)
					{
						String daytime = cur.getDaytime();
						String[] times = getTimes(daytime);
						String sTime = times[0];
						String eTime = times[1];
						boolean res = inWindow(sTime, eTime, curTime);
						if(res)
						{
							crn += cur.getCrn() + "<br><br>";
							time += cur.getDaytime() + "<br><br>";
							inst += cur.getHcuser().getName() + "<br><br>";
							building += cur.getHcclassroom().getBldgname() + "<br><br>";
							room += cur.getHcclassroom().getRoom() + "<br><br>";
						}	
					}
					
					table = tpresent;
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
	
	public  String[] getTimes(String s)
	{
		String[] tokens = s.split(" ");
		
		String temp = tokens[1];
		
		String [] tokens2 = temp.split("-");
		
		return tokens2;
	}
	
	public boolean inWindow(String sTime, String eTime, String curTime)
	{
		boolean result = false;
		
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
		Date ten = null;
		try {
			ten = parser.parse(sTime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date eighteen = null;
		try {
			eighteen = parser.parse(eTime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String someOtherDate = curTime;
		
		try {
		    Date userDate = parser.parse(someOtherDate);
		    if (userDate.after(ten) && userDate.before(eighteen)) {
		    	result = true;
		    }
		    
		} catch (ParseException e) {
		    // Invalid date was entered
			//System.out.println("no");
		}
		return result;
	}

}
