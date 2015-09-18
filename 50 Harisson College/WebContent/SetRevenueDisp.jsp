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
	<link rel="stylesheet"
	href="pageStyle.css">
</head>
<body>

<div class="container">
${message}
  <form class="form-horizontal" role="form" action="SetRevenue" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Semester</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="sem" name="sem" placeholder="'fall 2015'">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Price/Credit</label>
      <div class="col-sm-10">          
        <input type="number" step=0.01 class="form-control" id="rate" name="rate" placeholder="Enter rate">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Set</button>
      </div>
    </div>
  </form>
</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
