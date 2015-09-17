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

	<thread><tr><th>name</th><th>majorid</th><th>entrydate</th><th>departmentid</th><th>officenum</th><th>type</th><th>password</th></tr></thread>
    <tr>
    	
    	
    	<td>${hcuser.name}</td>
        <td>${hcuser.hcmojor.id}</td>
        <td>${hcuser.entrydate}</td>
        <td>${hcuser.hcdept.id}</td>
        <td>${hcuser.officenum}</td>
        <td>${hcuser.type}</td>
        <td>${hcuser.password}</td>
        
       
    </tr>

</table>

</div>


</body>
</html>