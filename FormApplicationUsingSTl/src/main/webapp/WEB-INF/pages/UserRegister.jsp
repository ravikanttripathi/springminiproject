<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to User Register Page</h1>
	<form action="saveuser" method="POST">
		<pre>
Name     :<input type="text" name="userName">
Email    :<input type="text" name="userMail">
Password :<input type="password" name="userPwd">
Role     :<input type="checkbox" value="ADMIN" name="roles">ADMIN
          <input type="checkbox" value="EMPLOYEE" name="roles">EMPLOYEE
          <input type="submit" value="Register">
</pre>
	</form>
	${data}
</body>
</html>