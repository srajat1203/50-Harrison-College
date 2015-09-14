package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hccourse;
import dao.HccourseDB;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ManageCourseServlet")
public class ManageCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String table = "";
		HttpSession session = request.getSession();
		//Shopuser user = (Shopuser) session.getAttribute("user");
		//List<Shoplineitem> lineItems = DBOrder.getAllLineItemsByUserID(user);
		List<Hccourse> courses = HccourseDB.getAllCourses();
		request.setAttribute("courses", courses); 
		getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
