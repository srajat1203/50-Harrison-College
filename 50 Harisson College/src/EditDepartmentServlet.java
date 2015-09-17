
 

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.HccourseDB;
import customTools.HcdeptDB;
import customTools.HcuserDB;
import model.Hccourse;
import model.Hcdept;
import model.Hcuser;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/EditDepartmentServlet")
public class EditDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idstr = request.getParameter("id");
		int id=Integer.parseInt(idstr);		
		Hcdept hcdept=HcdeptDB.getDeptByID(id);
			
		request.setAttribute("hcdept", hcdept); 
		List<Hcdept> depts = HcdeptDB.getAllDepts();
		
		request.setAttribute("depts", depts); 
		getServletContext().getRequestDispatcher("/editDepartment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
