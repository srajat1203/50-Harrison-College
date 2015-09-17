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
  <h2>input instructor</h2>
  <form class="form-horizontal" role="form" action="Classbyinstructor" method="post">
   
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="instructorid">instructorid:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="instructorid" placeholder="Enter instructorid" name="instructorid">
      </div>
      
    
    
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>

	<jsp:include page="footer.jsp" />
</body>
</html>