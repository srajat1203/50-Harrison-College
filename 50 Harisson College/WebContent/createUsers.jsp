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
  <link rel="stylesheet"
	href="pageStyle.css">
</head>
<body>

	<jsp:include page="navbar.jsp"/>
		
<!-- create a new account -->
	<div class="container">
		<h1>Create a new User</h1>
		<%-- <div class="container">
			<div class="jumbotron other-color">
				<center>
					<h1>Create a new User</h1>
				</center>
			</div>
		</div> --%>
		<form class="form-horizontal" role="myForm" action="CreateUserServlet" onsubmit="return validateForm()" method="post">
		
			
			
			<div class="form-group">
				<label class="control-label col-sm-5">User Name :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="name"
						name="name" >
				</div>
			</div>
			
			
				<div class="form-group">
				<label class="control-label col-sm-5">entrydate :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="entrydate"
						name="entrydate" >
				</div>
			</div>
			
		
		
		<div class="form-group">
				<label class="control-label col-sm-5">officenum :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="officenum"
						name="officenum">
				</div>
			</div>

		<div class="form-group">
				<label class="control-label col-sm-5">type :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="type"
						name="type" >
						
					
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="control-label col-sm-5">password :</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="password"
						name="password">
						
					
				</div>
			</div>
			
			
				
			<div class="form-group">
				<label class="control-label col-sm-5" for="assignment">Major: </label>
				<div class="col-sm-5">
				<select name="major" class="form-control">
					<c:forEach var="c" items="${majors}">
					<option value="${c.id}">${c.name}</option>
                	</c:forEach>
       	 		</select>
       	 		</div>
			</div>
			
				
			<div class="form-group">
				<label class="control-label col-sm-5" for="assignment">Department: </label>
				<div class="col-sm-5">
				<select name="dept" class="form-control">
					<c:forEach var="c" items="${depts}">
					<option value="${c.id}">${c.name}</option>
                	</c:forEach>
       	 		</select>
       	 		</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<center>
						<button type="submit" class="btn btn-lg btn-block"
							value="addstudent">Create User</button>
					</center>
				</div>
			</div>
		</form>
	</div>

<jsp:include page="footer.jsp"/>
</body>
</html>