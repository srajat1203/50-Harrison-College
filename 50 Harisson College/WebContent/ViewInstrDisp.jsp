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
    <form role="form" action="ViewInstr" method="post">
      <label for="x">Select Instructor</label><br>
	  <select  name="instr">
	   <optgroup label=Instructor>
	  	${instr} 
	    </optgroup>
	  </select>	  
	    <br><br>
    <button type="submit" class="btn btn-default">Find Students</button>
	</form>

<h3>List of students</h3>
<table class="table">
    <thead>
      <tr>
        <th>User id</th>
        <th>Name</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${userid}</td>
        <td>${name}</td>
      </tr>
    </tbody>
  </table>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
