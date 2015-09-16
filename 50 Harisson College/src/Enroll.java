

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;














import customTools.DBUtil;
import model.Hcclass;
import model.Hcenrolledclass;
import model.Hcuser;

/**
 * Servlet implementation class Enroll
 */
@WebServlet("/Enroll")
public class Enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String message = "";
    private String err1 = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> Duplicate crn </div>";
    private String err2 = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> You have another class at same and day </div>";
    private String err3 = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> Conflict </div>";
    private String success = "<div class=\"alert alert-success\"> <strong>Success!</strong> New class added </div>";
    
 
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enroll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int choice = 1;
		
		
		String temp_crn = request.getParameter("crn");
		long crn = 0;
		Hcclass curclass = null;
		if(temp_crn != null)
		{
			if(!temp_crn.isEmpty())
			{
				crn = Long.parseLong(temp_crn);
				String q = "Select c from Hcclass c where c.crn = " + crn;
				Utils<Hcclass> dbc = new Utils<Hcclass>();
				curclass = dbc.getResult(q);
			}
		}
		
		
		if(curclass != null)
		{
			HttpSession session = request.getSession();
			Hcuser curuser = (Hcuser) session.getAttribute("curuser");
			List<Hcenrolledclass> classes = getSchedule(curuser);
			
			outerloop:
			for(Hcenrolledclass cur: classes)
			{
				if(cur.getHcclass().getCrn() == curclass.getCrn())
				{
					//System.out.println("already exists");
					message = err1;
					choice = 0;
					break outerloop;
				}
				
				else if(cur.getHcclass().getDaytime().equals(curclass.getDaytime()))
				{
					//System.out.println("exact same daytime, so conflict");
					message = err2;
					choice = 0;
					break outerloop;
				}
				
				else if(timeConflict(cur.getHcclass().getDaytime(), curclass.getDaytime()) && dayConflict(cur.getHcclass().getDaytime(), curclass.getDaytime()))
				{
					
					System.out.println("Conflict");
					message = err3;
					choice = 0;
					break outerloop;
					
				}
				
				
			}
			
			System.out.println(choice);
			
			if(choice == 1)
			{
				//System.out.println("no conflict");
				message = success;
				Utils<Hcenrolledclass> dbe = new Utils<Hcenrolledclass>();
				Hcenrolledclass e = new Hcenrolledclass();
				e.setHcuser(curuser);
				e.setHcclass(curclass);
				e.setSemester(curclass.getSemester());
				dbe.insert(e);
			}
			
		}
		
	
		response.setContentType("text/html");
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/EnrollDisp.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	
	public List<Hcenrolledclass> getSchedule(Hcuser curuser)
	{
		List<Hcenrolledclass> sched = new ArrayList<Hcenrolledclass>();
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT h FROM Hcenrolledclass h WHERE h.hcuser=:hcuser";
		List<Hcenrolledclass> clsess = null;
		TypedQuery<Hcenrolledclass> q = em.createQuery(query, Hcenrolledclass.class);
		q.setParameter("hcuser", curuser);
		try {
			clsess = q.getResultList();
		} catch (Exception e) {
		} finally {
			em.close();
		}
		
		for(Hcenrolledclass cur: clsess)
		{
			if(cur.getHcclass().getEnable() == 1)
			{
				sched.add(cur);
			}
		}
		
		return sched;
		
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
		String alldays = alldaytime[0];
		
		
		String [] curdaytime = content.split(" ");
		String curday = curdaytime[0];
		
		
		if(alldays.toLowerCase().contains(curday.toLowerCase()))
		{
			res = true;
			//System.out.println("day conflict");
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
