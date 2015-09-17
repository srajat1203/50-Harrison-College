
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
					<li><a href="Courses">View Courses</a></li>
						<li><a href="MajorsDisp.jsp">View Majors</a></li>
					<li><a href="ClassesbySemDisp.jsp">Available Classes</a> </li><%
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
					<li><a href="RosterOfStudent.jsp">My Classes</a></li>
					<li><a href="CurrentSemesterClasses">Current classes</a></li>
					<li><a href="GradeSheets.jsp">Grade Sheets</a></li>
					<%
						} else {
									if (session.getAttribute("userType").equals(3)) {
					%>
					<li><a href="Transcripts.jsp">Transcripts</a> </li>
					<li><a href="EnrollDisp.jsp">Enroll Student</a></li>
					<li><a href="DropDisp.jsp">Drop Student</a></li><%
 	} else {
 					if (session.getAttribute("userType").equals(4)) {
 %>
 <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage <span class="caret"></span></a>
          <ul class="dropdown-menu">
					<li><a href="ManageUserServlet">Users</a></li>
      			<li><a href="ManageCourseServlet">Courses</a></li>
      			<li><a href="ManageClassroomServlet">Classrooms</a></li>
      			<li><a href="ManageDepartmentServlet">Departments</a></li>
      			<li><a href="ManageMajorServlet">Majors</a></li>
      			<li><a href="RemoveClassDisp.jsp">Class</a></li>
					</ul>
        </li>
        
         <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Add New<span class="caret"></span></a>
          <ul class="dropdown-menu">
					<li><a href="SubmitUserServlet">User</a></li>
      			<li><a href="SubmitCourseServlet">Course</a></li>
      			<li><a href="SubmitClassroomServlet">Classroom</a></li>
      			<li><a href="SubmitDepartmentServlet">Department</a></li>
      			<li><a href="SubmitMajorServlet">Major</a></li>
      				<li><a href="ClassInfo">Class</a></li>
					</ul>
        </li>
               <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">View <span class="caret"></span></a>
          <ul class="dropdown-menu">
					<li><b>Classes</b></li>
					 <li role="separator" class="divider"></li>
      			<li><a href="classbyinstructor.jsp">By Instructor</a></li>
      			<li><a href="FindAllInstr">By taught Instructor</a></li>
      			<li><a href="FindAllStudents">By Student</a></li>
      			<li><a href="classbycourse.jsp">By Course</a></li>
      			<li><b>Classrooms</b></li>
					 <li role="separator" class="divider"></li>
					 <li><a href="classroombyinstructor.jsp">By Instructor</a></li>
           			<li><a href="classroombystudent.jsp">By Student</a></li>
      			<li><a href="classroombycourse.jsp">By Course</a></li>
					</ul>
					<li><b>Students</b></li>
					 <li role="separator" class="divider"></li>
					 <li><a href="classroombystudent.jsp">Taught by an Instructor</a></li>
					 <li><b>Instructors</b></li>
					 <li role="separator" class="divider"></li>
					 <li><a href="instructorbyclass.jsp">have taught a class</a></li>
        </li>
					<%
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