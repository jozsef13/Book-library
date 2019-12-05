<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your info</title>
</head>
<body>

${user}
<br>
<a href="/books/allBooks"><button type="button"> Books inventory </button></a>
<a href="/store/allOrders"><button type="button">See all orders</button></a>
<a href="/searchOrder.jsp"><button type="button">Search your order by ID</button></a>
<a href="/users/logout"><button type="button">Logout</button></a>
<a href="/users/deleteUser/${sessionScope.userId}"><button type="button">Delete account</button></a>
</body>
</html>