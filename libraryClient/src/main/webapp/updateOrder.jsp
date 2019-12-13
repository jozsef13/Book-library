<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update order</title>
</head>
<body>

<form action="/store/order/update/${sessionScope.orderId}" method="post">
Updated status: <select name="oStatus">
   					<option value="Approved">Approved</option>
    				<option value="Delivered">Delivered</option>
    				<option value="Placed">Placed</option>
  				</select><br>
Order Quantity: <input type="text" name="oQuantity"><br>
Book ID: <input type="text" name="oBookId"><br>
<input type="submit" value="Update"><br>
</form>
<br>
<a href='' onclick = "this.href='/users/ID/' + ${sessionScope.userId}" ><button type="button">Return to your page</button></a>

</body>
</html>