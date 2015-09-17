<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"



    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery.rating.js"></script>
  <link rel="stylesheet"
	href="pageStyle.css">
</head>
<body>

	<jsp:include page="navbar.jsp"/>
	<div class="container">

<table>
<c:forEach var="l" items="${list}">
	<thread><tr><th>crn</th><th>coursenum</th><th>instructorid</th><th>classroomnum</th><th>semester</th><th>daytime</th><th>enable</th></tr></thread>
    <tr>
    	
    	
    	<td>${l.crn}</td>
        <td>${l.hccourse.id}</td>
        <td>${l.hcuser.userid}</td>
        <td>${l.hcclassroom.id}</td>
        <td>${l.semester}</td>
        <td>${l.daytime}</td>
        <td>${l.enable}</td>
       
    </tr>
</c:forEach>
</table>

</div>


</body>
</html>