<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1">
	<tr>
		<td>id</td>
		<td>姓名</td>
		<td>性别</td>
		<td>年级</td>
		<td>班级</td>
	</tr>
	<c:forEach items="${students}" var="s" varStatus="st">
	<tr>
		<td>${s.id}</td>
		<td>${s.name}</td>
		<td>${s.sex}</td>
		<td>${s.grade}</td>
		<td>${s.className}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>