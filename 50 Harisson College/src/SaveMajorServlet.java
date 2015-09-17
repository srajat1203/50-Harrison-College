
 

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

import customTools.*;
import model.Hccourse;
import model.Hcdept;
import model.Hcmojor;
import model.Hcuser;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/SaveMajorServlet")
public class SaveMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveMajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int deptID = Integer.parseInt(request.getParameter("dept"));
		int id = Integer.parseInt(request.getParameter("id"));
        Hcmojor major = HcmojorDB.getMajorByID(id);
		
		major.setName(name);
		
		Hcdept dept = HcdeptDB.getDeptByID(deptID);
		major.setHcdept(dept);
		
		HcmojorDB.update(major);
		
		List<Hcmojor> majors = HcmojorDB.getAllMajors();
		request.setAttribute("majors", majors); 
		getServletContext().getRequestDispatcher("/majors.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
