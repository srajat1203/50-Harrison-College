
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcuser;
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
@WebServlet("/Roombycourse")
public class Roombycourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Roombycourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("roombyinstructor doget");
	
		
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		Hcuser hcuser=HcuserDB.getUserByID(userid);
		
	    List<Hcclass>list= hcuser.getHcclasses();
	    
	    for(int i=0;i<list.size();i++){
		    Hcclass hcclass=list.get(i);
			
		    System.out.println(hcclass.getHcclassroom().getBldgname() +"11111<<<<<<<<<<<<<<<<<<<");
		    System.out.println(hcclass.getHcclassroom().getMaxcap() +"11111<<<<<<<<<<<<<<<<<<<");
		}
		
	    
	    
	//	Hccourse course= HccourseDB.getline(courseid);
		
		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/disroombyins.jsp").forward(request, response);
		
		

		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
	}

}
