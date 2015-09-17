
		<div class="navbar-brand"><img  style="max-width:60px; margin-top: -13px;" src="http://diplomaclassics.com/images/Entities/insignia/v2/HacoSealGold_220.png" /></div>
	
<nav class="navbar-default" >
		<div class="container-fluid" >
			<div>
				<ul class="nav navbar-nav navbar-right">
					<%
						if (session.getAttribute("curuser") == null) {
					%>
					<li><a href="CreateUser.jsp">Signup</a></li>
					<li><a href="LoginDisp.jsp">Login</a></li>
					
				</ul>
				
				<%
					} else {
				%>
				<li><a href="Login?logout=true">Logout</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a href="CourseDisp.jsp">View Courses</a>
						<li><a href="MajorsDisp.jsp">View Majors</a>
					<li><a href="ClassesbySemDisp.jsp">Available Classes</a> <%
 	if (session.getAttribute("userType").equals(1)) {
 %>
	<li><a href="CurrentSchedule">My Schedule</a></li>
		<li><a href="Enroll">Enroll in Class</a></li>
		<li><a href="Drop">Drop Class</a></li>
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Transcript <span class="caret"></span></a>
          <ul class="dropdown-menu">
           <li><a href="Transcripts">Unofficial Transcript</a></li>
            <li><a href="OrderTrans.jsp">Order Official Transcript</a></li>
          </ul>
        </li>

					<%
 	} else {
 			if (session.getAttribute("userType").equals(2)) {
 %>
					<li><a href="RosterOfStudent.jsp">My Classes</a>
					<li><a href="CurrentSemesterClasses">Current classes</a>
					<li><a href="GradeSheets.jsp">Grade Sheets</a></li>
					<%
						} else {
									if (session.getAttribute("userType").equals(3)) {
					%>
					<li><a href="Transcripts.jsp">Transcripts</a> 
					<li><a href="EnrollDisp.jsp">Enroll Student</a></li>
					<li><a href="DropDisp.jsp">Drop Student</a></li><%
 	} else {
 					if (session.getAttribute("userType").equals(4)) {
 %>
					<li><a href="">Administrators</a> <%
 	}
 				}
 			}
 		}
 	}
 %>
				</ul>
			</div>
		</div>
	 </nav>