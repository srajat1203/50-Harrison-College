

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcuser;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private String err = "<div class=\"alert alert-danger\"> <strong>Error ! </strong> No such user exists </div>";
	private String message = "";
	private int choice = 0;
	private String nextpage = "";
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
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pwd");
		String temp_type = request.getParameter("type");
		int type = 0;
		if(temp_type != null)
		{
			if (!temp_type.isEmpty())
			{
				type = Integer.parseInt(temp_type);
			}
		}
		
		
		
		if(userid != null && pass!=null)
		{
			if(!userid.isEmpty() && !pass.isEmpty())
			{
				String qString = "Select u from Hcuser u where u.userid = " + userid + " and u.password = '" + pass + "' and u.type = " + type ;
				Utils<Hcuser> dbu = new Utils<Hcuser>();
				Hcuser user = new Hcuser();
				try
				{
					user = dbu.getResult(qString);
					//System.out.println(user.getName());
					
					if(type == 1)
					{
						choice = 1;
						//nextpage = "/Student";
					}
					else if(type == 2)
					{
						choice = 2;
						//nextpage = "/Instructor";
					}
					else if (type == 3)
					{
						choice = 3;
						//nextpage = "/Advisor";
					}
					else if (type == 4)
					{
						choice = 4;
						//nextpage = "/Admin";
					}
					
					HttpSession session = request.getSession();
					session.setAttribute("curuser", user);
					nextpage = "/Courses";
					
				}
				catch(Exception e)
				{
					System.out.println("no user found");
					message = err;
					choice = 5;
					nextpage = "/LoginDisp.jsp";
					
				}
			}
		}
		
		
		

		response.setContentType("text/html");
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(nextpage)
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
