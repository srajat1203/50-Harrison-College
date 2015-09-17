
 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hccourse;
import model.Hcdept;
import model.Hcmojor;
import customTools.*;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/CreateMajorServlet")
public class CreateMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int deptID = Integer.parseInt(request.getParameter("dept"));
		
		Hcmojor major = new Hcmojor();
		
		major.setName(name);
		major.setEnable(1);
		Hcdept dept = HcdeptDB.getDeptByID(deptID);
		major.setHcdept(dept);
		
		HcmojorDB.insert(major);
		
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
