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
  <link rel="stylesheet"
	href="pageStyle.css">
</head>
<body>

	<jsp:include page="navbar.jsp"/>
	<div class="container" >
	<table class="table table-striped">
	<thead><tr><th>name</th><th>department name</th><th>enable</th></tr></thead>
 	<c:forEach var="c" items="${majors}">
		<tr>
			<td>${c.name}</td>
			<td>${c.hcdept.name}</td>
			<td>${c.enable}</td>
			
  <div class="row">
			<td>
			<div class="col-xs-2 col-md-2">
			<a href = "EditMajorServlet?id=${c.id}"><button type="button" class="btn pull-left btn-success">Edit</button></a>
		</div>
		<div class="col-xs-2 col-md-2">
			<c:if test="${c.enable eq 1}"><a href = "DisableMajorServlet?id=${c.id}"><button type="button" class="btn pull-left btn-success">Disable</button></a></c:if>
			</div><div class="col-xs-2 col-md-2">
			<c:if test="${c.enable eq 0}"><a href = "EnableMajorServlet?id=${c.id}"><button type="button" class="btn pull-left btn-success">Enable</button></a></c:if>
				</div></td></div>
		
		</tr>
	</c:forEach> 
	</table>
<br>
<br>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>