
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcclass;
import model.Hcclassroom;
import model.Hcenrolledclass;
import model.Hcuser;
import customTools.HcclassDB;
import customTools.HcuserDB;

/**
 * Servlet implementation class Classbyinstructor
 */
@WebServlet("/Classroombystudent")
public class Classroombystudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Classroombystudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("student"));
		
		//Hcuser hcuser=HcuserDB.getStudentByID(userid);
		Utils<Hcuser> dbu = new Utils<Hcuser>();
		String q = "Select u from Hcuser u where u.userid = " + userid;
		Hcuser cuser = null;
		cuser = dbu.getResult(q);
		
		System.out.println(cuser.getName());
		
		
		List<Hcenrolledclass> list=null;
		Utils<Hcenrolledclass> dbe = new Utils<Hcenrolledclass>();
		String m = "Select e from Hcenrolledclass e";
		list = dbe.getList(m);
		
		
		
		if(list == null)
		{
			System.out.println("null list");
		}
		if(list.size() == 0){
			System.out.println("the list is empty");
		}
		
		List<Hcclassroom> nlist = new ArrayList<Hcclassroom>();
		
		
		for(Hcenrolledclass cur: list)
		{
			if(cur.getHcuser().getUserid() == cuser.getUserid())
			{
				Hcclassroom entry = new Hcclassroom();
				entry = cur.getHcclass().getHcclassroom();
				nlist.add(entry);
			}
		}
		
		//System.out.println(list.size());
		//
		//hcuser.setName("bb");
		
		
		//List<Hcclass> list=HcclassDB.(hcuser);
		//List<Hcclass> list=HcclassDB.getclass(hcuser);
		
		
	//System.out.println(hcclass.getSemester());
	//System.out.println(hcclass.getSemester());	
	//System.out.println(hcclass.getSemester());
	
		request.setAttribute("list", nlist);
		getServletContext().getRequestDispatcher("/disroombystudent.jsp").forward(request, response);
		
		
		
		
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
