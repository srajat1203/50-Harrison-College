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
<jsp:include page="navbar.jsp" />
<div class="container">


		
${message}

  <form role="form" action="Enroll" method="post">
  		<div class="form-group" ${ishidden}>
			<label class="control-label col-sm-2">Student ID</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="student" id="student"
						placeholder="Enter Student ID">
			</div>
		</div>
    <div class="form-group">
      <label for="crn">CRN</label>
      <input type="number" class="form-control" id="crn" name="crn" placeholder="Enter crn #">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>


</div>

	<jsp:include page="footer.jsp" />

</body>
</html>
