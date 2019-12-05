<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search for order</title>
</head>
<body>

Enter the ID of the order you are looking for <input type="text" id = "orderId" name = "orderId"><br>

<a href='' onclick = "this.href='/store/order/' + document.getElementById('orderId').value" ><button type="button">Search</button></a>
<a href='' onclick = "this.href='/users/ID/' + ${sessionScope.userId}" ><button type="button">Return to your page</button></a>

</body>
</html>