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

<div class="container">
  <h2>Courses</h2>            
  <table class="table">
    <thead>
      <tr>
        <th>Course code</th>
        <th>Course number</th>
        <th>Description</th>
        <th>Name</th>
        <th>Credits</th>
        <th>Department</th>
        
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${code}</td>
        <td>${num}</td>
        <td>${desc}</td>
        <td>${name}</td>
        <td>${credits}</td>
        <td>${dept}</td>
      </tr>
    </tbody>
  </table>
</div>



<br><br>
<div class="container" >
  <form class="form-inline" role="form" action="DropDisp.jsp" method="post">
  
    <button type="submit" class="btn btn-default">Drop Class</button>
  </form>
</div>
  

</body>
</html>
