<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>EMPID</th>
				<th>EMP NAME</th>
				<th>EMP PWD</th>
				<th>EMP GEN</th>
				<th>EMP ADDRESS</th>
				<th>EMP COUNTRY</th>
				<th colspan="2">ACTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="ob">
				<tr>
					<th><c:out value="${ob.empId}" /></th>
					<th><c:out value="${ob.empName}" /></th>
					<th><c:out value="${ob.empPwd}" /></th>
					<th><c:out value="${ob.emmGen}" /></th>
					<th><c:out value="${ob.empAddr}" /></th>
					<th><c:out value="${ob.empCounty}" /></th>
					<th><a href="edit?id=${ob.empId}">Edit</a></th>||
					<th><a href="delete?id=${ob.empId}">Delete</a></th>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
</body>
</html>