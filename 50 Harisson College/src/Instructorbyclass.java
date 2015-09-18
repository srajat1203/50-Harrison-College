
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hccourse;
import model.Hcuser;
import customTools.DBUtil;
import customTools.HcclassDB;
import customTools.HccourseDB;

/**
 * Servlet implementation class Classbyinstructor
 */
@WebServlet("/Instructorbyclass")
public class Instructorbyclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Instructorbyclass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("doget classbyinstructor");
		
		int crnid = Integer.parseInt(request.getParameter("crnid"));
		System.out.println(crnid);
		
		
		//Hccourse hccourse=HccourseDB.getCourseByID(crnid);
		//Hcclass hcclass = HcclassDB.getClassByID(crnid);
		
		Hcclass cclass = null;
		Utils<Hcclass> dbc = new Utils<Hcclass>();
		String q = "Select c from Hcclass c where c.crn = " + crnid;
		cclass =  dbc.getResult(q);
		
		
		Hcuser instr = cclass.getHcuser();
		
		List<Hcuser> list= new ArrayList<Hcuser>(); 
		list.add(instr);
		

		request.setAttribute("list", list);
		getServletContext().getRequestDispatcher("/disinstructorbyclass.jsp").forward(request, response);
		
		
		
		
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
