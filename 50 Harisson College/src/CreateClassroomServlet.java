
 

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclassroom;
import model.Hccourse;
import customTools.*;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/CreateClassroomServlet")
public class CreateClassroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClassroomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bldgname = request.getParameter("bldgname");
		int room = Integer.parseInt(request.getParameter("room"));
		int maxcap = Integer.parseInt(request.getParameter("maxcap"));
	
		Hcclassroom hcclassroom = new Hcclassroom();
		hcclassroom.setBldgname(bldgname);
		hcclassroom.setMaxcap(maxcap);
		hcclassroom.setRoom(room);
		
	
		
		HcclassroomDB.insert(hcclassroom);
		
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
