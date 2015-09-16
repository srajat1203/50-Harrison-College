

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OfficialTranscript
 */
@WebServlet("/OfficialTranscript")
public class OfficialTranscript extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message="";
	private  Random random = new Random();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficialTranscript() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		message ="";
		boolean cardinfoCor = false, bilinfo = false, shipinfo = false;
		//card information
				String cardnum = request.getParameter("c_num");
				String carddate = request.getParameter("c_date");
				String cvv = request.getParameter("c_code");

				if(cardnum != "" && carddate != "" && cvv != "")
					cardinfoCor= true;

				//billing info
				String b_address = request.getParameter("b_address");
				String b_city = request.getParameter("b_city");
				String b_state = request.getParameter("b_state");
				String b_zipcode = request.getParameter("b_zipcode");
				System.out.println(request.getParameter("ship_to_billing_address"));
				String s_address ="";
				String s_city ="";
				String s_state ="";
				String s_zipcode  ="";
				if(b_address != "" && b_city != "" && b_state != "" &&  b_zipcode != "")
					bilinfo= true;
			//shipping into
				if (request.getParameter("ship_to_billing_address")==null)
				{
				 s_address = request.getParameter("s_address");
				 s_city = request.getParameter("s_city");
				 s_state = request.getParameter("s_state");
				 s_zipcode = request.getParameter("s_zipcode");
				 shipinfo = true;
				}
				else
				{
					 s_address = b_address;
					 s_city = b_city;
					 s_state =b_state;
					 s_zipcode = b_zipcode;
					 if(s_address != "" && s_city != "" && s_state != "" &&  s_zipcode != "")
						 shipinfo= true;
				}
				
				
				if(shipinfo && bilinfo && cardinfoCor)	
				{
					request.setAttribute("ishidden","hidden");
					message+="<div class=\"alert alert-success\"><strong>Your Payment was successful!</strong> your order conformation number is "+ random.nextInt(10)+""+
							random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10)+""+random.nextInt(10)+""+".</div>";
				}
				else
				{
					message+="<div class=\"alert alert-danger\"><strong>Error!</strong> Please make sure you fill all fields.</div>";
				}
				request.setAttribute("message",message);
				getServletContext().getRequestDispatcher("/OrderTrans.jsp")
				.forward(request, response);
	}

}
