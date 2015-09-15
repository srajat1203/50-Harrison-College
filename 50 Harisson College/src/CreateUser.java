

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcmojor;
import model.Hcuser;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String success = "<div class=\"alert alert-success\"> <strong>Success!</strong> New account created </div>";
    private String message = "";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		String yearOfEntry = request.getParameter("year");
		String pass = request.getParameter("pwd");
		int type = 1;
		
		Hcmojor usermajor = new Hcmojor();
		String q = "Select m from Hcmojor m where m.id = " + major;
		Utils<Hcmojor> dbm = new Utils<Hcmojor>();
		Hcmojor maj = new Hcmojor();
		try
		{
			maj = dbm.getResult(q);
		}
		catch (Exception e)
		{
			System.out.println("no such major: CreateUser");
		}
		
		Hcuser user = new Hcuser();
		user.setName(name);
		user.setHcmojor(maj);
		user.setEntrydate(yearOfEntry);
		user.setType(type);
		user.setPassword(pass);
		
		
		//System.out.println(name + " " + major + " " + yearOfEntry + " " + pass + " " + type);
		
		
		Utils<Hcuser> dbu = new Utils<Hcuser>();
		try
		{
			dbu.insert(user);
			message = success;
		}
		catch(Exception e)
		{
			System.out.println("Could not add user");
		}
		
		response.setContentType("text/html");
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/LoginDisp.jsp")
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
