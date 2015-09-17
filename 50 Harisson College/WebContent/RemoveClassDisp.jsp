<jsp:include page="navbar.jsp"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>RemoveClass</title>
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
  <h2>Remove Class</h2>
  <form role="form" action="RemoveClass" method="post">
    <div class="form-group">
      <label for="crn">CRN</label>
      <input type="number" class="form-control" id="crn" name="crn" placeholder="Enter CRN #">
    </div>
    
    <button type="submit" class="btn btn-default">Remove</button>
  </form>
</div>

</body>
</html>
