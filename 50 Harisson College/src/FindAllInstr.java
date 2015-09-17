

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcuser;

/**
 * Servlet implementation class FindAllInstr
 */
@WebServlet("/FindAllInstr")
public class FindAllInstr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String instr = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllInstr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("author") != null && request.getParameter("author").equals("xiaohua")){
			instr = "";
			
			
			Utils<Hcuser> dbu = new Utils<Hcuser>();
			String q = "Select u from Hcuser u";
			List<Hcuser> users = null;
			users = dbu.getList(q);
			if(users != null)
			{
				for(Hcuser cur: users)
				{
					if(cur.getType() == 2)
					{
						instr += instrJsp(cur);
					}
				}
			}
			
			response.setContentType("text/html");
			request.setAttribute("instr", instr);
			getServletContext().getRequestDispatcher("/classbyinstructor.jsp").forward(request, response);
		}else if(request.getParameter("author") != null && request.getParameter("author").equals("xiaohua2")){
			instr = "";
			
			
			Utils<Hcuser> dbu = new Utils<Hcuser>();
			String q = "Select u from Hcuser u";
			List<Hcuser> users = null;
			users = dbu.getList(q);
			if(users != null)
			{
				for(Hcuser cur: users)
				{
					if(cur.getType() == 2)
					{
						instr += instrJsp(cur);
					}
				}
			}
			
			response.setContentType("text/html");
			request.setAttribute("instr", instr);
			getServletContext().getRequestDispatcher("/classroombyinstructor.jsp").forward(request, response);
		}else{
			instr = "";
			
			
			Utils<Hcuser> dbu = new Utils<Hcuser>();
			String q = "Select u from Hcuser u";
			List<Hcuser> users = null;
			users = dbu.getList(q);
			if(users != null)
			{
				for(Hcuser cur: users)
				{
					if(cur.getType() == 2)
					{
						instr += instrJsp(cur);
					}
				}
			}
			
			response.setContentType("text/html");
			request.setAttribute("instr", instr);
			getServletContext().getRequestDispatcher("/ViewInstrDisp.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String instrJsp(Hcuser user)
	{
		String n = "";
		n = "<option value=" + user.getUserid() + ">" + user.getUserid() + " " + user.getName() + "</option>" ;
		return n;
		
	}
}

