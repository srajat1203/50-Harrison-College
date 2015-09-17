

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcclassroom;
import customTools.HcclassroomDB;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ManageClassroomServlet")
public class ManageClassroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageClassroomServlet() {
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
		List<Hcclassroom> classrooms = HcclassroomDB.getAllClassrooms();
		request.setAttribute("classrooms", classrooms); 
		getServletContext().getRequestDispatcher("/classrooms.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
