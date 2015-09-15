package main;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customerTools.DBUtil;
import model.Hcuser;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("login doget");
		
		String message="";
		String name=request.getParameter("name");
		System.out.println(name);
		Hcuser hcuser=new Hcuser();
		
		
		  EntityManager em = DBUtil.getEmFactory().createEntityManager();
		  EntityTransaction trans = em.getTransaction();
		
	      
		  String qString = "SELECT u FROM Hcuser u where u.name = '" +name + "'   ";
		   // String qString1 = "SELECT u FROM User u where u.upassword = '" +upassword + "'   ";
	      TypedQuery<Hcuser> q =  em.createQuery(qString, Hcuser.class);
		    
	      try{
			    hcuser = q.getSingleResult();
		       }
		    
		    
		    catch(Exception e){
		       }
		    
	      //if()
	    	  
	  	if(hcuser.getName()!= null)
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("currentuser", hcuser);
			message="correct"+hcuser.getName()+hcuser.getType();
			response.setContentType("text/html");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/c1234567.jsp")
			.forward(request, response);
			
			
		}  
	  	
	  	else
		{
			message ="incorrect username";
			response.setContentType("text/html");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/login.jsp")
			.forward(request, response);
			
		}
	     
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}