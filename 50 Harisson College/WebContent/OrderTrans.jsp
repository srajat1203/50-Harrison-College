<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
</head>
<title>Order Transcript</title>
</head>
<body>
	<jsp:include page="navbar.jsp" />
<div class="container">
${message}
<div  id="formholder" name="formholder"  ${ishidden}>
   <form role="form" action = "OfficialTranscript" method ="post">
 <div class="form-group">
 		<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <label for="email">Number of Transcripts:</label>
      <input type="text" class="form-control" id="t_num" name="t_num" onchange="calculate_Total_price(this);">
</div>
      </div>
        <div class="col-lg-6">
        <div class="input-group">
       <label for="email">Total: $</label>
       <input type="text" class="form-control" id="total" name="total" disabled>
</div>
</div>
</div>
  </div>

  <div class="form-group">
  <h2>Card Information</h2>
      <label for="email">Credit Card Number:</label>
      <input type="text" class="form-control" id="c_num" name="c_num">
    </div>
     <div class="form-group">
      <label for="email">Expiration Date:</label>
      <input type="text" class="form-control" id="c_date" name="c_date">
    </div>
     <div class="form-group">
      <label for="email">CVV code:</label>
      <input type="text" class="form-control" id="c_code" name="c_code">
    </div>
    <br> <br> <br>
    <h2>Billing Information</h2>
      <div id="billing_address_form_part">
     <div class="form-group">
      <label for="email">Billing Address:</label>
      <input type="text" class="form-control" id="b_address" name="b_address">
    </div>
     <div class="form-group">
      <label for="email">City:</label>
      <input type="text" class="form-control" id="b_city" name="b_city">
    </div>
     <div class="form-group">
      <label for="email">State:</label>
      <input type="text" class="form-control" id="b_state" name="b_state">
    </div>
    <div class="form-group">
      <label for="email">Zipcode:</label>
      <input type="text" class="form-control" id="b_zipcode" name="b_zipcode">
    </div>
    </div>
     <div id="ship_to_billing_address_form_part">
    <label for="ship_to_billing_address">Ship to billing address? 
        <input type="checkbox" name="ship_to_billing_address" id="ship_to_billing_address" />
    </label>
</div>
    <br><br><br>
        <div id="shipping_address_form_part">
     <h2>Shipping Information</h2>

      <div class="form-group">
      <label for="email">Shipping Address:</label>
      <input type="text" class="form-control" id="s_address" name="s_address">
    </div>
     <div class="form-group">
      <label for="email">City:</label>
      <input type="text" class="form-control" id="s_city" name="s_city">
    </div>
     <div class="form-group">
      <label for="email">State:</label>
      <input type="text" class="form-control" id="s_state" name="s_state">
    </div>
    <div class="form-group">
      <label for="email">Zipcode:</label>
      <input type="text" class="form-control" id="s_zipcode" name="s_zipcode">
    </div>
 </div>
    <button type="submit" class="btn btn-default" >Submit</button>
  </form> 
  </div>
</div>

<script type="text/javascript">
function calculate_Total_price(text)
{
    price = document.getElementById('total');
    total_price = document.getElementById('t_num');
    price.value =  total_price.value * 5 ;
} 

$("input#ship_to_billing_address").prop("checked", true);
$("#shipping_address_form_part").hide();

$("input#ship_to_billing_address").click(function(){ 
if ($("input#ship_to_billing_address").is(':checked')) 
{ 
    // Checked, hide shipping address 
   $("#shipping_address_form_part").hide(500);
} 
else 
{ 
    // Show shipping address on uncheck 
    $("#shipping_address_form_part").show();
} 
});
</script>

</body>
</html>
</body>
</html>