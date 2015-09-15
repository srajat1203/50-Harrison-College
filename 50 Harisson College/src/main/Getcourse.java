package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.HcclassDB;
import DB.HcuserDB;
import model.Hcclass;
import model.Hccourse;
import model.Hcuser;

/**
 * Servlet implementation class Getcourse
 */
@WebServlet("/Getcourse")
public class Getcourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getcourse() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doget getcourse");
		String courseidstr=request.getParameter("crnid");
		long courseid= Long.parseLong(courseidstr);
		
		System.out.println(courseid);
		System.out.println(courseid);
		
		Hcclass hcclass=new Hcclass();
		Hccourse hccourse=new Hccourse();
		
		
		hccourse.setId(courseid);
		
		System.out.println("1");
		System.out.println("1");
		//hcclass.setHccourse(hccourse);
		System.out.println("2");
		
		hcclass=HcclassDB.getline(courseid);
	
	
		System.out.println(hcclass.getHcuser().getName());
		
		System.out.println(hcclass.getHcuser().getName());
		System.out.println(hcclass.getHcuser().getName());
		
		
		//	List<Hcuser> list= HcuserDB.getinstructor(hcclass);
		
		request.setAttribute("hcclass", hcclass);
		getServletContext().getRequestDispatcher("/getinstructor.jsp").forward(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
		// TODO Auto-generated method stub
	}

}
