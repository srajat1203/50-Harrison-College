<jsp:include page="navbar.jsp"/>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
</head>
<body>


<div class="container">
    <form role="form" action="ViewStudents" method="post">
      <label for="x">Select Student</label><br>
	  <select  name="student">
	   <optgroup label=student>
	  	${students} 
	    </optgroup>
	  </select>	  
	    <br><br>
    <button type="submit" class="btn btn-default">Find Classes</button>
	</form>

<h3>Classes by Student</h3>
<table class="table">
    <thead>
      <tr>
        <th>CRN</th>
        <th>daytime</th>
        <th>Instructor</th>
        <th>Building</th>
        <th>Room</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${crn}</td>
        <td>${daytime}</td>
        <td>${inst}</td>
        <td>${building}</td>
        <td>${room}</td>
      </tr>
    </tbody>
  </table>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
