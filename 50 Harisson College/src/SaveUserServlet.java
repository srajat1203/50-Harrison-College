
 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcdept;
import model.Hcmojor;
import model.Hcuser;
import customTools.*;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/SaveUserServlet")
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String entrydate = request.getParameter("entrydate");
		int officenum=Integer.parseInt(request.getParameter("officenum"));
		int type=Integer.parseInt(request.getParameter("type"));
		String password = request.getParameter("password");
		
		
		
        int majorid=Integer.parseInt(request.getParameter("major"));
		
		int deptid=Integer.parseInt(request.getParameter("dept"));
		
		Hcdept hcdept=HcdeptDB.getDeptByID(deptid);

		Hcmojor hcmojor=HcmojorDB.getMajorByID(majorid);
		
		
		//Hcdept hcdept=HcdeptDB.getDeptByID(majorid);
		
		
		Hcuser hcuser=HcuserDB.getUserByID(id);
		
		hcuser.setHcmojor(hcmojor);
		hcuser.setHcdept(hcdept);
		
		
		hcuser.setEntrydate(entrydate);
		hcuser.setName(name);
		hcuser.setPassword(password);
	    hcuser.setType(type);
	    hcuser.setOfficenum(officenum);

		HcuserDB.update(hcuser);
	
		List<Hcuser> hcusers=HcuserDB.getAllUsers();
		//List<Hcuser> hcusers = HcclassroomDB.getAllClassrooms();
		request.setAttribute("hcuser", hcusers); 
		getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
