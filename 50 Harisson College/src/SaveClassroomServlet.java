
 

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
import model.Hcclassroom;
import model.Hccourse;
import model.Hcdept;
import model.Hcuser;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/SaveClassroomServlet")
public class SaveClassroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveClassroomServlet() {
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
		int id=Integer.parseInt(request.getParameter("id"));
	
		Hcclassroom hcclassroom = HcclassroomDB.getClassroomByID(id);
		hcclassroom.setBldgname(bldgname);
		hcclassroom.setMaxcap(maxcap);
		hcclassroom.setRoom(room);
		
		
		HcclassroomDB.update(hcclassroom);
	
		
		List<Hcclassroom> hcclassrooms = HcclassroomDB.getAllClassrooms();
		request.setAttribute("classrooms", hcclassrooms); 
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
