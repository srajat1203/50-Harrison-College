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


<div class="container" >
  <form class="form-inline" role="form" action="Courses" method="post">
    <div class="form-group">
      <label for="dept">Department</label>
      <input type="text" class="form-control" id="dept" name="dept" placeholder="Enter Department name">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
  

</body>
</html>
