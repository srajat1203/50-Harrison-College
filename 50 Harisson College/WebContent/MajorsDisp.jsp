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
</br>
   <form class="form-inline" role="form" action="Majors" method="post">
    <div class="form-group">
      <label for="dept">By Department</label>
      <input type="text" class="form-control" id="dept" name="dept" placeholder="Enter Department name">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>

  <h2>Majors</h2>
<div class="container">
  <ul class="list-group">
    <li class="list-group-item">${maj}</li>
  </ul>
  </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
