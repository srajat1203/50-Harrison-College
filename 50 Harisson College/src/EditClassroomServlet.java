
 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclassroom;
import model.Hcdept;
import customTools.HcclassroomDB;
import customTools.HccourseDB;
import customTools.HcdeptDB;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/EditClassroomServlet")
public class EditClassroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClassroomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idstr = request.getParameter("id");
		int id=Integer.parseInt(idstr);		
		
		Hcclassroom hcclassroom=HcclassroomDB.getClassroomByID(id);
		//Hcclassroom hcclassroom=HccourseDB.getCourseByID(id);	
		request.setAttribute("hcclassroom", hcclassroom); 
		List<Hcdept> depts = HcdeptDB.getAllDepts();
		request.setAttribute("depts", depts); 
		getServletContext().getRequestDispatcher("/editClassroom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
