

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcclassroom;
import model.Hccourse;
import model.Hcuser;

/**
 * Servlet implementation class CreateClass
 */
@WebServlet("/CreateClass")
public class CreateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String message = "";
    private String err1 = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> Conflicts with Instructor schedule </div>";
    private String err2 = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> Conflicts with Existing class </div>"; 
    private String success = "<div class=\"alert alert-success\"> <strong>Success!</strong> New class added </div>";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String temp_course = request.getParameter("course");
		String temp_instr = request.getParameter("instr");
		String temp_classroom = request.getParameter("classroom");
		String temp_enable = request.getParameter("enable");
		
		long course = Long.parseLong(temp_course);
		long instr = Long.parseLong(temp_instr);
		long classroom = Long.parseLong(temp_classroom);
		String sem = request.getParameter("sem");
		String daytime = request.getParameter("daytime");
		int enable = Integer.parseInt(temp_enable);
		
		//System.out.println(course + " " + instr + " " + classroom + " " + sem + " " + daytime + " " + enable);
		
		Utils<Hcuser> dbu = new Utils<Hcuser>();
		String q = "Select u from Hcuser u where u.userid = " + instr;
		Hcuser user = dbu.getResult(q);
		
		Utils<Hccourse> dbc = new Utils<Hccourse>();
		String p = "Select c from Hccourse c where c.id = " + course;
		Hccourse curcourse = dbc.getResult(p);
		
		Utils<Hcclassroom> dbcl = new Utils<Hcclassroom>();
		String m = "Select c from Hcclassroom c where c.id = " + classroom;
		Hcclassroom curclassroom = dbcl.getResult(m);
		
		
		//System.out.println(user.getName());
		
		
		//classConflict(daytime, curclassroom);
		
		if(instrConflict(user, daytime, sem) || classConflict(daytime, curclassroom))
		{
			
		}
		else
		{
			//System.out.println("i");
			Utils<Hcclass> dbs = new Utils<Hcclass>();
			Hcclass nclass = new Hcclass();
			nclass.setHccourse(curcourse);
			nclass.setHcuser(user);
			nclass.setHcclassroom(curclassroom);
			nclass.setSemester(sem);
			nclass.setDaytime(daytime);
			nclass.setEnable(enable);
			
			dbs.insert(nclass);
			message = success;
			
		}
		
		response.setContentType("text/html");
		request.setAttribute("message", message);
		//request.setAttribute("allInstr", allCourse);
		//request.setAttribute("allClassroom", allCourse);
		getServletContext().getRequestDispatcher("/ClassInfo")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean classConflict(String daytime, Hcclassroom classroom)
	{
		boolean res = false;
		
		List<Hcclass> clist = null;
		Utils<Hcclass> dbc = new Utils<Hcclass>();
		String q = "Select c from Hcclass c";
		clist = dbc.getList(q);
		
		if(clist != null)
		{
			outerloop:
			for(Hcclass cur: clist)
			{	
				if(cur.getDaytime().equals(daytime))
				{
					if(cur.getHcclassroom().getId() == classroom.getId())
					{
						message = err2;
						//System.out.println("class conflict exact");
						res = true;
						break outerloop;
					}
				}
				
				if(timeConflict(cur.getDaytime(), daytime) && dayConflict(cur.getDaytime(), daytime))
				{
					if(cur.getHcclassroom().getId() == classroom.getId())
					{
						message = err2;
						//System.out.println("class conflict");
						res = true;
						break outerloop;
					}	
				}
			}		
		}
		
		return res;
	}
	
	public boolean instrConflict(Hcuser user, String daytime, String sem)
	{
		
		//System.out.println("here");
		boolean res = false;
		
		List<Hcclass> slist = null;
		String q = "Select c from Hcclass c where c.semester = '" + sem + "'";
		Utils<Hcclass> dbc = new Utils<Hcclass>();
		slist = dbc.getList(q);
		
		if(slist != null)
		{
			outerloop:
			for(Hcclass cur: slist)
			{
				//System.out.println(cur.getHcuser().getName());
				if(cur.getHcuser().getUserid() == user.getUserid())
				{
					//System.out.println("in user");
					if(cur.getDaytime().equals(daytime))
					{
						//System.out.println("daytime conflict");
						message = err1;
						res = true;
						break outerloop;
					}
					
					else if(timeConflict(cur.getDaytime(), daytime) && dayConflict(cur.getDaytime(), daytime))
					{
						//System.out.println("daytime conflict");
						message = err1;
						res = true;
						break outerloop;
					}
				}
			}
		}
		return res;
	}	
	
	public boolean timeConflict(String all, String cur)
	{
		
		//System.out.println("in func 2");
		boolean res = false;
		
		String [] time1 = getTimes(all);
		String sTime1 = time1[0];
		String eTime1 = time1[1];
		//System.out.println(sTime1 + " " + eTime1);
		
		
		String [] time2 = getTimes(cur);
 		String sTime2 = time2[0];
 		String eTime2 = time2[1];
 		//System.out.println(sTime2 + " " + eTime2);
 		
 		
 		if(inWindow(sTime2, eTime2, sTime1) || inWindow(sTime2, eTime2, eTime1))
 		{
 			res = true;
 			//System.out.println("time conflict");
 		}
 		
		return res;
	}

	public boolean dayConflict(String container, String content)
	{
		
		//System.out.println("in fucn 1");
		boolean res = false;
		
		String[] alldaytime = container.split(" ");
		String alldays = alldaytime[0].toLowerCase();
		
		
		String [] curdaytime = content.split(" ");
		String curday = curdaytime[0].toLowerCase();
		
		breakloop:
		for(int i=0; i<curday.length(); i++)
		{
			if(alldays.contains(""+curday.charAt(i)))
			{
				res = true;
				//System.out.println("all day "+alldays);
				//System.out.println("Char "+curday.charAt(i));
				//System.out.println("there is conflict with days");
				break breakloop;
			}
		}
		return res;
		
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
