<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
</head>
<body>

<table style="width:100%">
	<tr>
		<th>Book ID</th>
		<th>Name</th>
		<th>Author</th>
		<th>Price</th>
		<th>Release year</th>
		<th>Category</th>
	</tr>
	<c:forEach items = "${books}" var = "book">
		<tr>
			<td align="center"><c:out value="${book.bookId}" /></td>
			<td align="center"><a href="/books/id/${book.bookId} " ><c:out value="${book.bookName}" /></a></td>
			<td align="center"><c:out value="${book.bookAuthor.authorFirstName} ${book.bookAuthor.authorLastName}" /></td>
			<td align="center"><c:out value="${book.bookPrice}" /></td>
			<td align="center"><c:out value="${book.bookReleaseYear}" /></td>
			<td align="center"><c:out value="${book.bookCategory}" /></td>
		</tr>
	</c:forEach>
</table>
<br>

<a href='' onclick = "this.href='/users/ID/' + ${sessionScope.userId}" ><button type="button">Return to your page</button></a>

</body>
</html>