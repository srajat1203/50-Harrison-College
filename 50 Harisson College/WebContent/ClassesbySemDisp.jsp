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
  <h2>Select Semester</h2>
  <form role="form" action = "ClassesbySem" method="post">
    <div class="form-group">
      <label for="search">Semester</label>
      <input type="text" class="form-control" id="search" name="search" placeholder="Enter sem. E.g 'fall 2011'">
    </div>
    <button type="submit" class="btn btn-default">Search</button>
  </form>
</div>

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

</body>
</html>
