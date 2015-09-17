<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet"
	href="pageStyle.css">
</head>
<body>
	 
	<jsp:include page="navbar.jsp"/>

<div class="container" >

${message}
  <h2>Create Class</h2>
  <form role="form" action="CreateClass" method="post">
      <label for="x">Select Course</label><br>
      
      ${allCourse}
      <br><br>
      
      <label for="y">Select Instructor</label><br>
      ${allInstr}
      <br><br>
    
      <label for="z">Select Classroom</label><br>
      ${allClassroom}
      <br><br>	
    
    <div class="form-group">
      <label for="sem">Semester</label>
      <input type="text" class="form-control" id="sem" name="sem" placeholder="Enter semester">
    </div>
    <div class="form-group">
      <label for="daytime">Enter daytime</label>
      <input type="text" class="form-control" id="daytime" name="daytime" placeholder="Enter (DDD HH:mm-HH:mm)">
    </div>
    
    
    <label for="w">Enable/Disable</label><br>
	<select name="enable">
	  <optgroup label="Enable/Disable">
	    <option value="1">Enable</option>
	    <option value="2">Disable</option>
	  </optgroup>
	</select>
	<br><br>
    
    <button type="submit" class="btn btn-default">Create</button>
  </form>
</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
