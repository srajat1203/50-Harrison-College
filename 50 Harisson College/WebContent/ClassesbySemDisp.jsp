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
	
	<div class="container">
<h3>Search options</h3>
<br><br>

<div class="container">
  <form class="form-inline" role="form" action="ClassesbySem" method="post">
    <div class="form-group">
      <label for="sem">Semester</label>
      <input type="text" class="form-control" id="sem" name="sem" placeholder="Enter Semester">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
<br><br>


<div class="container">
  <form class="form-inline" role="form" action="ClassesbySem" method="post">
    <div class="form-group">
      <label for="sem">Semester</label>
      <input type="text" class="form-control" id="sem" name="sem" placeholder="Enter Semester">
    </div>
    <div class="form-group">
      <label for="subject">Subject:</label>
      <input type="text" class="form-control" id="subject" name="subject" placeholder="Enter subject">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
<br><br>


<div class="container">
  <form class="form-inline" role="form" action="ClassesbySem" method="post">
    <div class="form-group">
      <label for="sem">Semester</label>
      <input type="text" class="form-control" id="sem" name="sem" placeholder="Enter Semester">
    </div>
    <div class="form-group">
      <label for="instr">Instructor</label>
      <input type="text" class="form-control" id="instr" name="instr" placeholder="Enter instructor">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
<br><br>




<div class="container">
  <form class="form-inline" role="form" action="ClassesbySem" method="post">
    <div class="form-group">
      <label for="time">Time</label>
      <input type="text" class="form-control" id="time" name="time" placeholder="Enter time (HH:mm)">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
<br><br>


<div class="container">
  <form class="form-inline" role="form" action="ClassesbySem" method="post">
    <div class="form-group">
      <label for="dept">Department</label>
      <input type="text" class="form-control" id="dept" name="dept" placeholder="Enter Department name">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
<br><br>



<div class="container">
  <form class="form-inline" role="form" action="ClassesbySem" method="post">
    <div class="form-group">
      <label for="sem">Semester</label>
      <input type="text" class="form-control" id="sem" name="sem" placeholder="Enter Semester">
    </div>
    <div class="form-group">
      <label for="dept">Department</label>
      <input type="text" class="form-control" id="dept" name="dept" placeholder="Enter Department name">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
<br><br>


	${table}
      <tr>
        <td>${crn}</td>
        <td>${time}</td>
        <td>${inst}</td>
        <td>${building}</td>
        <td>${room}</td>
      </tr>
    </tbody>
  </table>
</div>
</div>
</body>
</html>
