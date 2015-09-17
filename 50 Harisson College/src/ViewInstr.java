

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcenrolledclass;

/**
 * Servlet implementation class ViewInstr
 */
@WebServlet("/ViewInstr")
public class ViewInstr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewInstr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String uid = "";
		String name = "";
		String temp_userid = request.getParameter("instr");
		long userid = Long.parseLong(temp_userid);
		//System.out.println(userid);
		
		//String q = "Select u from hcuser u where u.userid = " + userid;
		//Utils<Hcuser> dbu = new Utils<Hcuser>();
		//Hcuser user = dbu.getResult(q); 
		
		String p = "select p from Hcenrolledclass p";
		Utils<Hcenrolledclass> dbe = new Utils<Hcenrolledclass>();
		List<Hcenrolledclass> elist = null;
		elist = dbe.getList(p);
		
		if(elist != null)
		{
			for(Hcenrolledclass cur: elist)
			{
			
				if(cur.getHcclass().getHcuser().getUserid() == userid)
				{	
					uid += cur.getHcuser().getUserid() + "<br><br>";
					name += cur.getHcuser().getName() + "<br><br>";
					
				}	
			}
		}
		
		//System.out.println("here");
		response.setContentType("text/html");
		request.setAttribute("userid", uid);
		request.setAttribute("name", name);
		getServletContext().getRequestDispatcher("/FindAllInstr")
		.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
	
}	