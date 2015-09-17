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
<title>Welcome to Tian Mao!</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<table class="table table-striped">
	<thead><tr><th>building name</th><th>maxcap</th><th>room</th></tr></thead>
 	<c:forEach var="c" items="${classrooms}">
		<tr>
			<td>${c.bldgname}</td>
			<td>${c.maxcap}</td>
			<td>${c.room}</td>
			
			<td><a href = "EditClassroomServlet?id=${c.id}"><button type="button" class="btn pull-left btn-info btn-lg">Edit</button></a>
			
		</tr>
	</c:forEach> 
	</table>
<br>
<a href = "index.jsp"><button type="button" class="btn btn-info btn-lg">Back>>></button></a>
<a href = "SubmitClassroomServlet"><button type="button" class="btn pull-left btn-info btn-lg">Create a classroom</button></a>
<br>
</body>
</html>