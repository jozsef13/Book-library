<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/users/updateUser/${sessionScope.userId}" method="post">
Username:     <input type="text" name="username"><br>
Password:     <input type="password" name="password"><br>
Last name:    <input type="text" name="userLastName"><br>
First name:   <input type="text" name="userFirstName"><br>
Phone number: <input type="text" name="userPhoneNumber"><br>
Email address: <input type="text" name="userEmailAddress"><br>
<input type="submit" value="Update"><br>
</form>

<a href='' onclick = "this.href='/users/ID/' + ${sessionScope.userId}" ><button type="button">Return to your page</button></a>
</body>
</html>