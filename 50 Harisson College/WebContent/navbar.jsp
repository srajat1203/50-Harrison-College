

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Harrison College</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
	<div class="navbar-brand">Harrison College!</div>
	<div>
<ul class="nav navbar-nav navbar-right">

<% if (session.getAttribute("curuser") == null) { %>
<li><a href="CreateUser.jsp">Signup</a></li>
<li><a href="LoginDisp.jsp">Login</a></li>
<% } else { %>
<li><a href="Login?logout=true">Logout</a></li>
<li><a href="CourseDisp.jsp">View Courses</a>
<li><a href="ClassesbySemDisp.jsp">Available Classes</a>
<% if(session.getAttribute("userType").equals(1)){%>
<li><a href="">Students</a>
<% } else { if(session.getAttribute("userType").equals(2)){%>
<li><a href="RosterOfStudent.jsp">Roster of Student</a>
<li><a href="CurrentSemesterClasses.jsp">Your Classes</a>
<li><a href="GradeSheets.jsp">Grade Sheets</a></li>
<%} else { if(session.getAttribute("userType").equals(3)){%>
<li><a href="">Advisors</a>
<%}else { if(session.getAttribute("userType").equals(4)){%>
<li><a href="">Administrators</a>
<%} } } }}%>

</ul>
	</div>
</div>
</nav>
