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


  <form class="form-inline" role="form" action="RevenueCourse" method="post">
    <div class="form-group">
      <label for="semester">Semester</label>
      <input type="text" class="form-control" id="sem" name="sem" placeholder="e.g 'fall 2015'">
    </div>
    
    <button type="submit" class="btn btn-default">Get Report</button>
  </form>


 <h2>${heading}</h2>
      
  <table class="table">
    <thead>
      <tr>
        <th>Number</th>
        <th>Name</th>
        <th>Revenue</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${num}</td>
        <td>${courses}</td>
        <td>${revenue}</td>
      </tr>
      <tr>
        
    </tbody>
  </table>  
  
</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
