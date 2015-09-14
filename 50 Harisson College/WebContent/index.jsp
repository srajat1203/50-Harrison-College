<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Harisson College</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	

<title>Welcome to Harisson College</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
	<div class="jumbotron other-color">
		<center>
			 <h1>Welcome to Harisson College!!</h1>
      			<p>what is it that binds us to this place...</p>
      			<p><a href="ManageCourseServlet" class="btn btn-success btn-lg">Create, update, list or disable a course</a></p>
      			<p><a href="ManageClassroomServlet" class="btn btn-success btn-lg">Create, update, list or disable a classroom</a></p>
      			<p><a href="ManageDepartmentServlet" class="btn btn-success btn-lg">Create, update, list or disable a department</a></p>
      			<p><a href="ManageMajorServlet" class="btn btn-success btn-lg">Create, update, list or disable a major</a></p>
      			<p><a href="AddClassServlet" class="btn btn-success btn-lg">Add class to schedule for current or later semester</a></p>
      			<p><a href="RemoveClassServlet" class="btn btn-success btn-lg">Remove class from schedule for current or later semester</a></p>
      			<p><a href="ChangeUserTypeServlet" class="btn btn-success btn-lg">Change a new users type to (student, instructor, advisor or administrator)</a></p>
      			<p><a href="EditEnrollmentServlet" class="btn btn-success btn-lg">Override maximum enrollment hold</a></p>
		</center>
	</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>