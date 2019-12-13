<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create account</title>
</head>
<body>

<form action="/users/createUser" method="post">
Username:     <input type="text" name="username"><br>
Password:     <input type="password" name="password"><br>
Last name:    <input type="text" name="userLastName"><br>
First name:   <input type="text" name="userFirstName"><br>
Phone number: <input type="text" name="userPhoneNumber"><br>
Email address: <input type="text" name="userEmailAddress"><br>
<input type="submit" value = "Create account"><br>
</form>


</body>
</html>