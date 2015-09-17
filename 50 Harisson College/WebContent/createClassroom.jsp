<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="jquery.rating.css">
<script src="jquery.rating.js"></script>
<title>Welcome to Stanford University!</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<!-- create a new account -->
	<div class="container">
		<div class="container">
			<div class="jumbotron other-color">
				<center>
					<h1>Create a new Classroom</h1>
				</center>
			</div>
		</div>
		<form class="form-horizontal" role="myForm" action="CreateClassroomServlet" onsubmit="return validateForm()" method="post">
			<div class="form-group">
				<label class="control-label col-sm-5">Bldg Name :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="bldgname"
						name="bldgname">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-5">Room Number :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="room"
						name="room">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-5">Max capacity :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="maxcap"
						name="maxcap">
				</div>
			</div>			
			
		

		
			
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<center>
						<button type="submit" class="btn btn-primary btn-lg btn-block"
							value="addstudent">Create Classroom</button>
					</center>
				</div>
			</div>
		</form>
	</div>

<jsp:include page="footer.jsp"/>
</body>
</html>