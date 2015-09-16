<!--  -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Harrison College</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-brand">Harrison College!</div>
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
					<li><a href="ClassesbySemDisp.jsp">Available Classes</a> <%
 	if (session.getAttribute("userType").equals(1)) {
 %>
	<li><a href="CurrentSchedule">My Schedule</a></li>
		<li><a href="Enroll">Enroll in Class</a></li>
            <li><a href="Transcripts">Unofficial Transcript</a></li>
            <li><a href="OrderTrans.jsp">Order Official Transcript</a></li>
       
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
					<li><a href="EnrollDisp.jsp">Enroll Student</a></li><%
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