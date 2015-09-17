

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hccourse;
import model.Hcmojor;
import customTools.HccourseDB;
import customTools.HcmojorDB;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/EnableMajorServlet")
public class EnableMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnableMajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid = Integer.parseInt(request.getParameter("id"));
		Hcmojor major =HcmojorDB.getMajorByID(cid);
		//Hcmojor major = HccourseDB.getCourseByID(cid);
		
		major.setEnable(1);
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
