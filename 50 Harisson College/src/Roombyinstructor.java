
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcuser;
import customTools.HcclassDB;
import customTools.HcuserDB;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hccourse;
import customTools.HccourseDB;

/**
 * Servlet implementation class Roombyinstructor
 */
@WebServlet("/Roombyinstructor")
public class Roombyinstructor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Roombyinstructor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("roombyinstructor doget");
	
		
System.out.println("doget classbyinstructor");
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		System.out.println(userid);
		Hcuser hcuser=new Hcuser();
		hcuser.setUserid(userid);
		List<Hcclass> list=HcclassDB.getclass(hcuser);
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/disroombyins.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
	}

}