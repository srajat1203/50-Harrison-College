

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcenrolledclass;
import model.Hcuser;
import customTools.DBUtil;

/**
 * Servlet implementation class Transcripts
 */
@WebServlet("/Transcripts")
public class Transcripts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String transcript="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transcripts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		transcript = "";
		Hcuser user = new  Hcuser();
		if(request.getParameter("student")!= null)
		{
		long strudentid = Long.parseLong(request.getParameter("student"));
		
		user = DBUtil.selectuser(strudentid);
		System.out.println("the strudent id is " + strudentid);
		}
		else
		{
			String ordertran = "<form role=\"for\" action=\"OrderTrans.jsp\"><button type=\"submit\" class=\"btn btn-default\" name=\"update\" id=\"update\">Order Official Transcript</button></form>";
			request.setAttribute("ishidden","hidden");
			System.out.println("Student is logged in");
			HttpSession session = request.getSession();
			user = (Hcuser) session.getAttribute("curuser");
			request.setAttribute("orderTranscript",ordertran);
		}
		if(user.getType()==1)
		{
			double totalpoints=0, sumpoints=0;
		int count=0;
		if(user != null && user.getType() == 1)
		{
			List<Hcenrolledclass> studentGrades = DBUtil.getStudentTranscript(user);
	
			if (studentGrades != null && !studentGrades.isEmpty()) {
				transcript += " <table class=\"table\"> <thead>  <tr>  <th>Course</th>  <th>Grade</th>   <th>GPA</th>  <th>Points</th></tr>   </thead>  <tbody>";
				String  semester =studentGrades.get(0).getSemester();
				transcript +="<tr><th colspan=\"4\" align=\"center\">"+semester+"</th></tr>";
				for (int i = 0; i < studentGrades.size(); i++) {
					if(!semester.equals(studentGrades.get(i).getSemester()))
					{
						semester= studentGrades.get(i).getSemester();
						transcript +="<tr><th colspan=\"4\" align=\"center\">"+semester+"</th></tr>";
					}
					transcript += "<tr><td>"+studentGrades.get(i).getHcclass().getHccourse().getSubjectcode()+""+studentGrades.get(i).getHcclass().getHccourse().getCoursenum()+" "+studentGrades.get(i).getHcclass().getHccourse().getName()+"</td><td>"
							+studentGrades.get(i).getGrade() +"</td><td>"
							+calculateGPA(studentGrades.get(i).getGrade()) +"</td><td>"
							+String.format(" %.2f", calculatePints(calculateGPA(studentGrades.get(i).getGrade()),studentGrades.get(i).getHcclass().getHccourse().getCredits())) +"</td>"
							+"</tr>";
					sumpoints+=calculatePints(calculateGPA(studentGrades.get(i).getGrade()),studentGrades.get(i).getHcclass().getHccourse().getCredits());
					totalpoints+=calculatePints(calculateGPA(100),studentGrades.get(i).getHcclass().getHccourse().getCredits());
					count++;
				}
				transcript +="<tr><th colspan=\"4\" align=\"center\">  "+String.format("Overall Points %.2f", sumpoints)+"</th></tr>";
				System.out.println("erned "+sumpoints);
				System.out.println("overall "+totalpoints);
				transcript +="<tr><th colspan=\"4\" align=\"center\"> "+String.format("Overall GPA  %.2f", calculateOverallGPA(totalpoints, sumpoints))+"</th></tr>";
				transcript += "</tbody></table>";
			
			}
		}
		}
		else
		{
			transcript = "<div class=\"alert alert-danger\"> <strong>Student ID!</strong> does not exist.</div>";
		}
		
		
		request.setAttribute("Transcript",transcript);
		getServletContext().getRequestDispatcher("/Transcripts.jsp")
		.forward(request, response);
		}
	
	
	public double calculateOverallGPA(double totalpoints, double earnedpoints)
	{
		double points = 0;
		if(earnedpoints> 0 && totalpoints>=earnedpoints)
		{
		points = (earnedpoints/totalpoints)*4;
		}
		return points;
	}
	
	public double calculateGPA(double grade)
	{
		double points = 0;
		if(grade> 0)
		{
		points = (grade/100)*4;
		}
		return points;
	}
	
	public double calculatePints(double GPA, double d)
	{
		double points = 0;
		System.out.println(d);
		System.out.println(GPA);
		points = GPA*d;
		System.out.println(points);
		return points;
	}

}
