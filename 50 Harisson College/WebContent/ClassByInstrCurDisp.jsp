<jsp:include page="navbar.jsp"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Classes by Instructor cur</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet"
	href="pageStyle.css">
</head>
<body>

<div class="container">


<div class="container">
    <form role="form" action="ClassbyInstrCur" method="post">
      <label for="x">Select Instructor</label><br>
	  <select  name="instr">
	   <optgroup label=Instructor>
	  	${instr} 
	    </optgroup>
	  </select>	  
	    <br><br>
    <button type="submit" class="btn btn-default">Find Classes</button>
	</form>

  <h2>Classes</h2>            
  <table class="table">
    <thead>
      <tr>
        <th>CRN</th>
        <th>Subject</th>
        <th>Daytime</th>
        <th>Semester</th>
        <th>Location</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${crn}</td>
        <td>${sub}</td>
        <td>${daytime}</td>
        <td>${sem}</td>
        <td>${place}</td>
      </tr>
    </tbody>
  </table>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>
