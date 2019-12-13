<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place order</title>
</head>
<body>

Book ID = ${book.bookId}<br>
Name = ${book.bookName}<br>
Author = ${book.bookAuthor.authorFirstName} ${book.bookAuthor.authorLastName}<br>
Release year = ${book.bookReleaseYear}<br>
Category = ${book.bookCategory}<br>
Price = ${book.bookPrice}<br>

<form action="/store/order/bookId=${sessionScope.bookId}&userId=${sessionScope.userId}" method="POST">
Quantity: <input type="text" name="oQuantity"><br>
<input type="submit" value = "Place order"><br>
</form>
<br>
<a href='' onclick = "this.href='/users/ID/' + ${sessionScope.userId}" ><button type="button">Return to your page</button></a>


</body>
</html>