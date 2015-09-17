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
<title>Insert title here</title>
</head>
<body>

<table>
<c:forEach var="item" items="${list}">
	<thread><tr><th>courseid</th><th>name</th><th>credits</th><th>description</th><th>subjectcode</th><th>departmentid</th><th>enable</th></tr></thread>
    <tr>
    	<td>${item.id}</td>
    	<td>${item.name}</td>
    	<td>${item.credits}</td>
    	<td>${item.descr}</td>
    	<td>${item.subjectcode}</td>
    	<td>${item.hcdept.id}</td>
    	<td>${item.enable}</td>
    </tr>
</c:forEach>
</table>




</body>
</html>