<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.er {
	color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="?lang=en">English</a>
	<a href="?lang=hi">Hindi</a>
	<a href="?lang=te">Telugu</a>
	<a href="?lang=yo">Yoruba</a>


	<form:form action="data" method="post" modelAttribute="employee">

		<pre>
     <spring:message code="ename" /> <form:input path="empName" />
     <form:errors path="empName" cssClass="er" />
     <spring:message code="epwd" />
			<form:password path="empPwd" />
     <form:errors path="empPwd" cssClass="er" />
     <spring:message code="egen" />
			<form:radiobutton path="emmGen" value="Male" />Male<form:radiobutton
				path="emmGen" value="Female" />Female
				<form:errors path="emmGen" cssClass="er" />
	 <spring:message code="eaddr" />
			<form:textarea path="empAddr" />
	 <form:errors path="empAddr" cssClass="er" />			
	 <spring:message code="ecunt" /> <form:select path="empCounty">
	<form:option value="">---Select-</form:option>
	<form:option value="INDIA">INDIA</form:option>
	<form:option value="NIGERIA">NIGERIA</form:option>
	<form:option value="LONDON">LONDON</form:option>
	</form:select>
	<form:errors path="empCounty" cssClass="er" />
		<input type="submit" value="Register">
		</pre>
	</form:form>
</body>
${employee1}
</html>