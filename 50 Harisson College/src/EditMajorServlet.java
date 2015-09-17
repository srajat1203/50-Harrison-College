
 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcdept;
import model.Hcmojor;
import customTools.HccourseDB;
import customTools.HcdeptDB;
import customTools.HcmojorDB;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/EditMajorServlet")
public class EditMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idstr = request.getParameter("id");
		int id=Integer.parseInt(idstr);		
		
		
		Hcmojor hcmojor=HcmojorDB.getMajorByID(id);
		//Hcmojor hcmojor=HccourseDB.getCourseByID(id);	
		
		request.setAttribute("hcmajor", hcmojor); 
		List<Hcdept> depts = HcdeptDB.getAllDepts();
		request.setAttribute("depts", depts); 
		getServletContext().getRequestDispatcher("/editMajor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
