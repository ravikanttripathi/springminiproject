<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="update" method="post" modelAttribute="emp">
		<pre>
		Emp Id<form:input path="empId" readonly="true" />
		EMP Name<form:input path="empName" />
		Emp PWD <form:input path="empPwd" />
		Emp Gen<form:radiobutton path="emmGen" value="Male" />Male<form:radiobutton
				path="emmGen" value="Female" />Female
			
	    Emp Address<form:textarea path="empAddr" />
	    Emp Country<form:input path="empCounty" />
		<input type="submit" value="UPDATE">
		</pre>
	</form:form>

</body>
</html>