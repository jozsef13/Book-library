<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
</head>
<body>

<table style="width:100%">
	<tr>
		<th>Order ID</th>
		<th>Book</th>
		<th>Quantity</th>
		<th>Ship date</th>
		<th>Status</th>
	</tr>
	<c:forEach items = "${orders}" var = "order">
		<tr>
			<td align="center"><a href="/store/order/${order.oId} " ><c:out value="${order.oId}" /></a></td>
			<td align="center"><a href="/books/id/${order.oBookId}"><c:out value="${order.oBookId}" /></a></td>
			<td align="center"><c:out value="${order.oQuantity}" /></td>
			<td align="center"><c:out value="${order.oShipDate}"/></td>
			<td align="center"><c:out value="${order.oStatus}" /></td>
		</tr>
	</c:forEach>
</table>
<br>

<a href='' onclick = "this.href='/users/ID/' + ${sessionScope.userId}" ><button type="button">Return to your page</button></a>

</body>
</html>