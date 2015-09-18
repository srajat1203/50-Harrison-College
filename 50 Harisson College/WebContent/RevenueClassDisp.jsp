<jsp:include page="navbar.jsp"/>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Revenue Class</title>
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



 <h2>${heading}</h2>
      
  <table class="table">
    <thead>
      <tr>
        <th>CRN</th>
        <th>Course</th>
        <th>Revenue</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${crn}</td>
        <td>${course}</td>
        <td>${revenue}</td>
      </tr>
      <tr>
        
    </tbody>
  </table>  
  
</div>

</body>
</html>
