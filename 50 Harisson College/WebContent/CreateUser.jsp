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
	 
	<jsp:include page="navbar.jsp"/>

<div class="container" >
  <h2>Create User</h2>
  <form role="form" action="CreateUser" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
    </div>
    
    
    <label for="name">Select Major</label>
    <br>
    ${Majors}
    <br><br>
    
    <div class="form-group">
      <label for="name">Year of Entry</label>
      <input type="text" class="form-control" id="year" name="year" placeholder="Enter year">
    </div>
    <div class="form-group">
      <label for="pwd">Create Password</label>
      <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
    </div>
    
    <button type="submit" class="btn btn-default">Create</button>
  </form>
</div>

</body>
</html>
