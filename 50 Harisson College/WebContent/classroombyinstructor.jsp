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
	<div class="container">
  <h2>input instructor</h2>
  <form class="form-horizontal" role="form" action="Roombyinstructor" method="post">
   
    <label for="x">Select Instructor</label><br>
	  <select  name="userid">
	   <optgroup label=Instructor>
	  	${instr} 
	    </optgroup>
	  </select>	  
	    <br><br>
    <button type="submit" class="btn btn-default">Find classes</button>
  </form>
   
  
   
</div>
         

	<jsp:include page="footer.jsp" />
</body>
</html>
