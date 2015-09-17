<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
	href="pageStyle.css">
</head>
<title>Roster of students</title>
</head>
<body>
	<jsp:include page="navbar.jsp" />
<div class="container">
  	<form role="form" action="RosterOfStudents" method="post" ${ishidden}>
		<div class="form-group">
			<label class="control-label col-sm-2">Semester</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="semester" id="semester"
						placeholder="Enter Semester">
			</div>
		</div>
		<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" name="Search"
				id="Search">Search</button>
		</div>
	</div>
	</form> 
	${Roster}
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>