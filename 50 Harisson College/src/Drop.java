

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcenrolledclass;
import model.Hcuser;
import customTools.DBUtil;

/**
 * Servlet implementation class Drop
 */
@WebServlet("/Drop")
public class Drop extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private String message = "";
    private String err = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> No such CRN in your schedule </div>";
    private String success = "<div class=\"alert alert-success\"> <strong>Success!</strong> Class has been removed </div>";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Drop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String temp_crn = request.getParameter("crn");
		long crn = 0; ;
		List<Hcenrolledclass> sched = null;
		if(temp_crn != null)
		{
			if(!temp_crn.isEmpty())
			{
				crn = Long.parseLong(temp_crn);
				
				HttpSession session = request.getSession();
				Hcuser curuser = (Hcuser) session.getAttribute("curuser");
				sched = getSchedule(curuser);
			}
		}
		
		if(sched != null)
		{
			
			outerloop:
			for(Hcenrolledclass cur: sched)
			{
				if(cur.getHcclass().getCrn() == crn)
				{
					Utils<Hcenrolledclass> dbe = new Utils<Hcenrolledclass>();
					dbe.delete(cur);
					message = success;
					break outerloop;
				}
				else
				{
					message = err;
				}
			}
		}

		response.setContentType("text/html");
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/DropDisp.jsp")
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
	

}
