

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hcmojor;

/**
 * Servlet implementation class Majors
 */
@WebServlet("/Majors")
public class Majors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String maj = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Majors() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String qString = "select u from Hcmojor u where u.enable = 1";
		Utils<Hcmojor> dbm = new Utils<Hcmojor>();
		List<Hcmojor> majors = null;
		majors = dbm.getList(qString);
		if(majors != null)
		{	
			for(Hcmojor cur: majors)
			{
				maj += cur.getName() + "<br><br>";
			}
		}
		
		response.setContentType("text/html");
		
		request.setAttribute("maj", maj);
		getServletContext().getRequestDispatcher("/MajorsDisp.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
