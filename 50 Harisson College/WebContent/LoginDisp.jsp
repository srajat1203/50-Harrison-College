<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
	href="pageStyle.css">
</head>
<body>
	 
	<jsp:include page="navbar.jsp"/>
	
	<div class="container">
		<h2>Login</h2>
		${message}
		<form role="form" action="Login" method="post">
			<div class="form-group">
				<label for="email">Userid</label> <input type="number"
					class="form-control" id="userid" name="userid"
					placeholder="Enter id">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" name="pwd"
					placeholder="Enter password">
			</div>


			<br>
			<br>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

	</div>
</body>
</html>
